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
public class Rey extends Pieza {

    private String nombre = "©";
    private boolean cas = true;

    public Rey() {
        super();
    }

    public Rey(Color color) {
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

    public boolean isCas() {
        return cas;
    }

    public void setCas(boolean cas) {
        this.cas = cas;
    }

    @Override
    public boolean mover(Pieza p, int a, int b, int x, int y, Object[][] tab) {
        int resta;
        if ((a == x && b > y) || (a == x && b < y)) {
            if (b > y) {
                resta = b - y;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a][b - i] instanceof Pieza) {
                        return false;
                    }
                }
                return true;
            } else {
                resta = y - b;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a][b + i] instanceof Pieza) {
                        return false;
                    }
                }
                return true;
            }
        } else if ((a > x && b == y) || (a < x && b == y)) {
            if (a > x) {
                resta = a - x;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a - i][b] instanceof Pieza) {
                        return false;
                    }
                }
                return true;

            } else {
                resta = x - a;
                for (int i = 1; i <= resta; i++) {
                    if (tab[a + i][b] instanceof Pieza) {
                        System.out.println(tab[a][y - 1]);
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
        if (a == x && y > 0 && a > 0 && y < tab.length-1 && x < tab.length-1) {
            if (b < y) {
                if ((tab[a][y + 1] instanceof Rebelde) && (tab[a + 1][y] instanceof Rebelde) && (tab[a][y - 1] instanceof Rebelde)) {
                    return true;
                } else {
                    return false;
                }
            } else {

                if (tab[a][y - 1] instanceof Rebelde && tab[a + 1][y] instanceof Rebelde && tab[a - 1][y] instanceof Rebelde) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if ((x > 0) && (b == y )&& (y > 0) &&( y < tab.length-1) && (x < tab.length-1)) {
            if (a > x) {
                if (tab[x - 1][b] instanceof Rebelde && tab[x][b + 1] instanceof Rebelde && tab[x][b - 1] instanceof Rebelde) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (tab[x + 1][y] instanceof Rebelde && tab[x][b + 1] instanceof Rebelde && tab[x][b - 1] instanceof Rebelde) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if (x == 0) {
            if (tab[x + 1][b] instanceof Rebelde && tab[x][y + 1] instanceof Rebelde && tab[x][y - 1] instanceof Rebelde) {
                return true;
            } else {
                return false;
            }
        } else if (y == tab.length - 1) {
            if ((tab[x][y - 1] instanceof Rebelde) && (tab[x + 1][y] instanceof Rebelde) && (tab[x - 1][y] instanceof Rebelde)) {
                return true;
            } else {
                return false;
            }
        } else if (y == 0) {
            if ((tab[x - 1][y] instanceof Rebelde) && (tab[x + 1][y] instanceof Rebelde) && (tab[x][y + 1] instanceof Rebelde)) {
                return true;
            } else {
                return false;
            }
        } else if (x == tab.length - 1) {
            if ((tab[x][y - 1] instanceof Rebelde) && (tab[x][y + 1] instanceof Rebelde) && (tab[x - 1][y] instanceof Rebelde)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
