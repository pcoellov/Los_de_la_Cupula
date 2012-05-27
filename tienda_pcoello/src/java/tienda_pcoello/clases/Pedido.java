/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_pcoello.clases;

/**
 *
 * @author Pablo
 */
public class Pedido {
    
    private int id;
    private String nombre;
    private int producto;
    private int cantidad;
    private int estado;
    
    public Pedido(String nombre, int producto, int cantidad, int estado) {
        this.nombre = nombre;
        this.producto = producto;
        this.cantidad = cantidad; 
        this.estado = estado; 
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

}
