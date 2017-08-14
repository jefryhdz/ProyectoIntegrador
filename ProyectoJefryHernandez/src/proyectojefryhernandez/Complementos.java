/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojefryhernandez;

/**
 *
 * @author Jefry Hernandez
 */
public interface Complementos {
    public boolean mover(Pieza p, int a, int b, int x, int y, Object[][] tab);
    public boolean capturar(Pieza p, int a, int b, int x, int y, Object [][]tab);
    
}
