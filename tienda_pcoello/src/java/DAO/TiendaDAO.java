/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

    
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import tienda_pcoello.clases.Producto;

/**
 *
 * @author Pablo
 */
public class TiendaDAO {

    private Connection conn;

    // CONSTRUCTOR INICIADO CON UN DATASOURCE
    public TiendaDAO(DataSource ds) {
        try {
            conn = ds.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException("Error en la base de datos",e);
        }
    }

    // METODO PARA CORTAR LA CONEXIÓN
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // METODO DE BUSQUEDA DE PRODUCTO POR NOMBRE
    public List<Producto> getProductoNombre(String nombre) {
        return getProductosQuery("nombre LIKE '%" + nombre + "%'");
    }

    // METODO DE BUSQUEDA DE PRODUCTO POR PRECIO
    public List<Producto> getProductoPrecio(float precio) {
        return getProductosQuery("precio = " + precio);
    }

    public List<Producto> getTodosLibros() {
        return getProductosQuery(null);
    }

    // BUSQUEDA DE TODOS LOS PRODUCTOS EN LA BASE DE DATOS
    private List<Producto> getProductosQuery(String where) {
        List<Producto> productos = new ArrayList<Producto>(); // Creamos lista vacía de productos
        Statement stm = null;                          // Nuevo statement a null
        try {
            stm = this.conn.createStatement();                 
            String sql = "SELECT nombre, categoria, imagen, precio FROM Producto"; // Creamos la query
            if (where != null) {                            // Si tiene busquedas concretas se añaden
                sql += " WHERE " + where;
            }
            ResultSet rs = stm.executeQuery(sql);          // En resultset asignamos el resultado de la query
            productos = crearProductoListFromRS(rs);     // Creamos la lista de todos los productos desde el resultset anterior
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException("Error al realizar la consulta",e); // Mensaje de error si falla la consulta
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {          
                System.err.println("Error al realizar la consulta: " + e.getLocalizedMessage());
            }
        }
        return productos;  // Devolvemos la lista de productos encontrada
    }

    
   /* private void cargarAutores(List<Libro> libros) {

        Statement stm = null;
        try {
            stm = this.conn.createStatement();

            for (Libro libro : libros) {
                ResultSet rs = stm.executeQuery("SELECT autores.idAutor, nombre, nacionalidad FROM autores, relacionlibroautor "
                        + "WHERE autores.idAutor = relacionlibroautor.idAutor "
                        + "AND relacionlibroautor.idLibro = " + libro.getId());
                libro.setAutores(crearAutorListFromRS(rs));
                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al realizar la consulta",e);
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                System.err.println("Error al realizar la consulta: " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }
    
    private List<Autor> crearAutorListFromRS(ResultSet rs) throws SQLException {
        List<Autor> autores = new ArrayList<Autor>();
        while (rs.next()) {
            int id = rs.getInt("idAutor");
            String nombre = rs.getString("nombre");
            String nacionalidad = rs.getString("nacionalidad");
            autores.add(new Autor(id, nombre, nacionalidad));
        }
        return autores;
    }
*/
    
    // METODO CREAR LISTA DE PRODUCTOS DESDE RESULTSET
    private List<Producto> crearProductoListFromRS(ResultSet rs) throws SQLException {
        List<Producto> productos = new ArrayList<Producto>();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            int categoria = rs.getInt("categoria");
            String imagen = rs.getString("imagen");
            float precio = rs.getInt("precio");
            productos.add(new Producto(nombre,categoria,imagen,precio));
        }
        return productos;
    }
}
