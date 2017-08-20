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
public class Duque extends Pieza {

    private String nombre = "o";

    public Duque() {
    }

    public Duque(Color color) {
        super(color);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean mover(Pieza p, int a, int b, int x, int y, Object[][] tab) {
        int resta;
        if ((a == x && b > y) || (a == x && b < y)) {
            if (b > y) {
                resta = b - y;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a][b - i] instanceof Pieza||tab[a][b - i] instanceof Castillo) {
                        return false;
                    }
                }
                return true;
            } else {
                resta = y - b;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a][b + i] instanceof Pieza||tab[a][b + i] instanceof Castillo) {
                        return false;
                    }
                }
                return true;
            }
        } else if ((a > x && b == y) || (a < x && b == y)) {
            if (a > x) {
                resta = a - x;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a - i][b] instanceof Pieza||tab[a - i][b] instanceof Castillo) {
                        return false;
                    }
                }
                return true;

            } else {
                resta = x - a;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a + i][b] instanceof Pieza||tab[a + i][b] instanceof Castillo) {                      
                        return false;
                    } else {
                    }
                }
                return true;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean capturar(Pieza p, int a, int b, int x, int y, Object[][] tab) {
        if (a == x && y > 0) {                   
            if (b < y) {
                if (tab[a][y + 1] instanceof Rebelde) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println(tab[a][y+1]);
                if (tab[a][y - 1] instanceof Rebelde) {                    
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (x > 0&&b==y) {
                if (a > x) {
                    if (tab[x - 1][b] instanceof Rebelde) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (tab[x + 1][y] instanceof Rebelde) {
                        return true;
                    } else {
                        return false;
                    }

                }
            } else {
                return false;
            }
        }
    }
}
