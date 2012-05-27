/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_pcoello.clases;

/**
 *
 * @author Pablo
 */
public class Producto {
    
    private int id;
    private String nombre;
    private int categoria;
    private String imagen;
    private float precio;
    
    public Producto (String nombre, int categoria, String imagen, float precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.imagen = imagen;
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }   
}
