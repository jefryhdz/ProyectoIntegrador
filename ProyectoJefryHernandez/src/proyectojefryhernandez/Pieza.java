/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojefryhernandez;

import java.awt.Color;

/**
 *
 * @author Jefry Hernandez
 */
public class Pieza {

    private Color color;

    public Pieza(Color color) {
        this.color = color;
    }

    public Pieza() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
