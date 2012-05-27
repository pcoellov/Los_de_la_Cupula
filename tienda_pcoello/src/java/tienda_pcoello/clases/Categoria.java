/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_pcoello.clases;

/**
 *
 * @author Pablo
 */
public class Categoria {
    
    private int id;
    private String nombre;
    
    public Categoria (String nombre) {
        this.nombre = nombre;
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
    
}
