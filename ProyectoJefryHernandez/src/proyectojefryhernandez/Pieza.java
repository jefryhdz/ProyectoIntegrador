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
public class Pieza implements Complementos {

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

    @Override
    public boolean mover(Pieza p, int a, int b, int x, int y, Object[][] tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean capturar(Pieza p, int a, int b, int x, int y, Object[][] tab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean duqueinmortal(int x, int y, Object[][] tab) {
        int a = 0, b = 0;     
        boolean an = false;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] instanceof Pieza) {
                    if (tab[i][j] instanceof Rey) {
                        a = i;
                        b = j;
                    }
                }
            }
        }
        int cont = 1;
        int contduqe = 1;
        if (a > 0 && a < tab.length - 1 && b > 0 && b < tab.length - 1) {
            while (contduqe <= 4 && a + cont < tab.length && a - cont >= 0 && b + cont < tab.length && b - cont >= 0) {
                if (tab[a + cont][b] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a + cont][b];
                    if (c instanceof Duque) {
                        contduqe++;
                        int x1 = a + cont;
                        int y1 = b;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }
                }  if (tab[a][cont + b] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a][cont + b];
                    if (c instanceof Duque) {
                        contduqe++;
                        int x1 = a;
                        int y1 = cont + b;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }
                } if (tab[a - cont][b] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a - cont][b];
                    if (c instanceof Duque) {
                        contduqe++;
                        int x1 = a - cont;
                        int y1 = b;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }

                    }
                } if (tab[a][b - cont] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a][b - cont];
                    if (c instanceof Duque) {
                        int x1 = a;
                        int y1 = b - cont;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }
                } if (tab[a - cont][b - cont] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a - cont][b - cont];
                    if (c instanceof Duque) {
                        int x1 = a - cont;
                        int y1 = b - cont;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }
                } if (tab[a - cont][b + cont] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a - cont][b + cont];
                    if (c instanceof Duque) {
                        int x1 = a - cont;
                        int y1 = b + cont;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }
                } if (tab[a + cont][b + cont] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a + cont][b + cont];
                    if (c instanceof Duque) {
                        int x1 = a + cont;
                        int y1 = b + cont;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }

                } if (tab[a + cont][b - cont] instanceof Pieza) {
                    Pieza c = (Pieza) tab[a + cont][b - cont];
                    if (c instanceof Duque) {
                        int x1 = a + cont;
                        int y1 = b - cont;
                        if (x1 == x && y1 == y) {
                            an = true;
                        }
                    }
                }
                cont++;
            }
        }
      
        return an;
    }

}
