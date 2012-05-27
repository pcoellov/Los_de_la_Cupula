/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_pcoello.clases;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Carrito {
    
    private ArrayList<Integer> productos;
    private ArrayList<Integer> cantidades;
    String nombre;
    
    public Carrito (ArrayList<Integer> productos, ArrayList<Integer> cantidades, String nombre) {
        this.productos = productos;
        this.cantidades = cantidades;
        this.nombre = nombre;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(ArrayList<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Integer> productos) {
        this.productos = productos;
    }
}
