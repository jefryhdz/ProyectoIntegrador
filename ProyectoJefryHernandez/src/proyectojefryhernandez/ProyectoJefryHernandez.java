/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojefryhernandez;

import java.awt.Color;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Jefry Hernandez
 */
public class ProyectoJefryHernandez {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[][] tablero = new Object[19][19];
        tablero(tablero, 0, 0);
        Imprimir(tablero);
        boolean jugador1 = false;
        boolean jugador2 = false;
        boolean juego;
        int cont = 1, x, y, x1, y1;
        while (jugador1 == false && jugador2 == false) {
            if (cont % 2 == 0) {
                juego = false;
                while (juego == false) {

                    System.out.println("Jugador del rey");
                    System.out.println("Ingrese las coordenadas de la pieza que desea mover:");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    if (tablero[x][y] instanceof Pieza) {
                        if ((tablero[x][y] instanceof Duque) || (tablero[x][y] instanceof Rey)) {
                            System.out.println("Ingrese la posicion que desea moverse: ");
                            x1 = sc.nextInt();
                            y1 = sc.nextInt();
                            Pieza c = (Pieza) tablero[x][y];
                            if (c.mover(c, x, y, x1, y1, tablero)) {
                                if (c instanceof Rey) {
                                    if (x == 9 && y == 9) {
                                        ((Rey) c).setCas(false);
                                        tablero[x1][y1] = tablero[x][y];
                                        tablero[x][y] = " ";
                                    }
                                    if (x1 == 9 && y1 == 9) {
                                        if (((Rey) c).isCas()) {
                                            tablero[x1][y1] = tablero[x][y];
                                            tablero[x][y] = " ";

                                        } else {
                                            System.out.println("No se puede posicionar en el castillo del centro");
                                        }
                                    }
                                    if (tablero[x1][y1] instanceof Castillo) {
                                        jugador2 = true;
                                    } else {
                                        tablero[x1][y1] = tablero[x][y];
                                        tablero[x][y] = " ";

                                    }
                                }
                                if (x == x1) {
                                    if (y != y1) {
                                        if (y1 > 0) {
                                            if (tablero[x1][y1 - 1] instanceof Pieza) {
                                                if ((tablero[x1][y1 - 1] instanceof Rebelde)) {
                                                    Pieza t = (Pieza) tablero[x1][y1 - 1];
                                                    if (t.capturar(t, x1, y1, x1, y1 - 1, tablero)) {
                                                        tablero[x1][y1 - 1] = " ";
                                                    }
                                                }
                                            } else if (y1 != tablero.length - 1) {
                                                if (tablero[x1][y1 + 1] instanceof Pieza) {
                                                    if ((tablero[x1][y1 + 1] instanceof Rebelde)) {
                                                        Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                        if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                            tablero[x1][y1 + 1] = " ";
                                                        }
                                                    }
                                                } else if (x1 > 0 && tablero[x1 - 1][y1] instanceof Pieza) {
                                                    if ((tablero[x - 1][y1] instanceof Rebelde)) {
                                                        Pieza t = (Pieza) tablero[x1 - 1][y1];
                                                        if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                            tablero[x1 - 1][y1] = " ";
                                                        }
                                                    }
                                                } else if (x1 != tablero.length - 1) {
                                                    if (tablero[x1 + 1][y1] instanceof Pieza) {
                                                        if ((tablero[x + 1][y1] instanceof Rebelde)) {
                                                            Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                            if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                                tablero[x1 + 1][y1] = " ";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (x1 == 0) {
                                                if (y1 != tablero.length - 1) {
                                                    if (tablero[x1][y1 + 1] instanceof Pieza) {
                                                        if ((tablero[x1][y1 + 1] instanceof Rebelde)) {
                                                            Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                            if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                                tablero[x1][y1 + 1] = " ";
                                                            }
                                                        }
                                                    } else if (tablero[x1 - 1][y1] instanceof Pieza) {
                                                        if ((tablero[x - 1][y1] instanceof Rebelde)) {
                                                            Pieza t = (Pieza) tablero[x1 - 1][y1];
                                                            if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                                tablero[x1 - 1][y1] = " ";
                                                            }
                                                        }
                                                    } else if (x1 != tablero.length - 1) {
                                                        if (tablero[x1 + 1][y1] instanceof Pieza) {
                                                            if ((tablero[x + 1][y1] instanceof Rebelde)) {
                                                                Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                                if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                                    tablero[x1 + 1][y1] = " ";
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (y == y1) {
                                        if (tablero[x1][y1 - 1] instanceof Pieza) {
                                            if ((tablero[x1][y1 - 1] instanceof Rebelde)) {
                                                Pieza t = (Pieza) tablero[x1][y1 - 1];
                                                if (t.capturar(t, x1, y1, x1, y1 - 1, tablero)) {
                                                    tablero[x1][y1 - 1] = " ";
                                                }
                                            }
                                        }
                                        if (y1 != tablero.length - 1) {
                                            if (tablero[x1][y1 + 1] instanceof Pieza) {
                                                if ((tablero[x1][y1 + 1] instanceof Rebelde)) {
                                                    Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                    if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                        tablero[x1][y1 + 1] = " ";
                                                    }
                                                }
                                            }
                                        }
                                        if (tablero[x1 - 1][y1] instanceof Pieza) {
                                            if ((tablero[x - 1][y1] instanceof Rebelde)) {
                                                Pieza t = (Pieza) tablero[x1 - 1][y1];
                                                if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                    tablero[x1 - 1][y1] = " ";
                                                }
                                            }
                                        }
                                        if (x1 != tablero.length - 1) {
                                            if (tablero[x1 + 1][y1] instanceof Pieza) {
                                                if ((tablero[x1 + 1][y1] instanceof Rebelde)) {
                                                    Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                    if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                        tablero[x1 + 1][y1] = " ";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                juego = true;
                            } else {
                                System.out.println("¡No se puede mover a la posicion ingresada!\n !Trate de nuevo!");
                            }
                        } else {
                            System.out.println("¡No puede mover la pieza escogida!\n¡TRATE DE NUEVO!");

                        }
                    }
                    Imprimir(tablero);
                }
            } else {
                juego = false;
                while (juego == false) {
                    System.out.println("Jugador de los Rebeldes");
                    System.out.println("Ingrese las coordenadas de la pieza que desea mover:");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    if (tablero[x][y] instanceof Pieza) {
                        if (tablero[x][y] instanceof Rebelde) {
                            System.out.println("Ingrese la posicion que desea moverse: ");
                            x1 = sc.nextInt();
                            y1 = sc.nextInt();
                            Pieza c = (Pieza) tablero[x][y];
                            if (c.mover(c, x, y, x1, y1, tablero)) {
                                tablero[x1][y1] = tablero[x][y];
                                tablero[x][y] = " ";
                                if (x == x1) {
                                    if (y > 0) {
                                        if (tablero[x1][y1 - 1] instanceof Pieza) {
                                            if ((tablero[x1][y1 - 1] instanceof Rey)) {
                                                Pieza t = (Pieza) tablero[x1][y1 - 1];
                                                if (t.capturar(t, x1, y1, x1, y1 - 1, tablero)) {
                                                    tablero[x1][y1 - 1] = " ";
                                                    jugador1 = true;
                                                }
                                            } else if ((tablero[x1][y1 - 1] instanceof Duque)) {
                                                Pieza t = (Pieza) tablero[x1][y1 - 1];
                                                if (new Pieza().duqueinmortal(x1, y1 - 1, tablero)) {

                                                } else {
                                                    if (t.capturar(t, x1, y1, x1, y1 - 1, tablero)) {
                                                        tablero[x1][y1 - 1] = " ";
                                                    }
                                                }
                                            }
                                        } else if (y1 != tablero.length - 1) {
                                            if (tablero[x1][y1 + 1] instanceof Pieza) {
                                                if ((tablero[x1][y1 + 1] instanceof Rey)) {
                                                    Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                    if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                        tablero[x1][y1 + 1] = " ";
                                                        jugador1 = true;
                                                    }
                                                } else if ((tablero[x1][y1 + 1] instanceof Duque)) {
                                                    Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                    if (new Pieza().duqueinmortal(x1, y1 + 1, tablero)) {

                                                    } else {
                                                        if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                            tablero[x1][y1 + 1] = " ";
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (x1 > 0) {
                                            if (tablero[x1 - 1][y1] instanceof Pieza) {
                                                if ((tablero[x1 - 1][y1] instanceof Rey)) {
                                                    Pieza t = (Pieza) tablero[x1 - 1][y1];
                                                    if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                        tablero[x1 - 1][y1] = " ";
                                                        jugador1 = true;
                                                    }
                                                } else if ((tablero[x1 - 1][y1] instanceof Duque)) {
                                                    Pieza t = (Pieza) tablero[x1 - 1][y1];
                                                    if (new Pieza().duqueinmortal(x1 - 1, y1, tablero)) {

                                                    } else {
                                                        if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                            tablero[x1 - 1][y1] = " ";
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (x1 != tablero.length - 1) {
                                            if (tablero[x1 + 1][y1] instanceof Pieza) {
                                                if ((tablero[x1 + 1][y1] instanceof Rey)) {
                                                    Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                    if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                        tablero[x1 + 1][y1] = " ";
                                                        jugador1 = true;
                                                    }
                                                } else if ((tablero[x1 + 1][y1] instanceof Duque)) {
                                                    Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                    if (new Pieza().duqueinmortal(x1 + 1, y1, tablero)) {

                                                    } else {
                                                        if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                            tablero[x1 + 1][y1] = " ";
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (y == y1) {
                                    if (tablero[x1][y1 - 1] instanceof Pieza) {
                                        if ((tablero[x1][y1 - 1] instanceof Rey)) {
                                            Pieza t = (Pieza) tablero[x1][y1 - 1];
                                            if (t.capturar(t, x1, y1, x1, y1 - 1, tablero)) {
                                                tablero[x1][y1 - 1] = " ";
                                                jugador1 = true;
                                            }
                                        } else if ((tablero[x1][y1 - 1] instanceof Duque)) {
                                            Pieza t = (Pieza) tablero[x1][y1 - 1];
                                            if (new Pieza().duqueinmortal(x1, y1 - 1, tablero)) {

                                            } else {
                                                if (t.capturar(t, x1, y1, x1, y1 - 1, tablero)) {
                                                    tablero[x1][y1 - 1] = " ";
                                                }
                                            }
                                        }
                                    }
                                    if (y1 != tablero.length - 1) {
                                        if (tablero[x1][y1 + 1] instanceof Pieza) {
                                            if ((tablero[x1][y1 + 1] instanceof Rey)) {
                                                Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                    tablero[x1][y1 + 1] = " ";
                                                    jugador1 = true;
                                                }
                                            } else if ((tablero[x1][y1 + 1] instanceof Duque)) {
                                                Pieza t = (Pieza) tablero[x1][y1 + 1];
                                                if (new Pieza().duqueinmortal(x1, y1 + 1, tablero)) {

                                                } else {
                                                    if (t.capturar(t, x1, y1, x1, y1 + 1, tablero)) {
                                                        tablero[x1][y1 + 1] = " ";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (tablero[x1 - 1][y1] instanceof Pieza) {
                                        if ((tablero[x1 - 1][y1] instanceof Rey)) {
                                            Pieza t = (Pieza) tablero[x1 - 1][y1];
                                            if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                tablero[x1 - 1][y1] = " ";
                                                jugador1 = true;
                                            }
                                        } else if ((tablero[x1 - 1][y1] instanceof Duque)) {
                                            Pieza t = (Pieza) tablero[x1 - 1][y1];
                                            if (new Pieza().duqueinmortal(1 - 1, y1, tablero)) {
                                            } else {
                                                if (t.capturar(t, x1, y1, x1 - 1, y1, tablero)) {
                                                    tablero[x1 - 1][y1] = " ";
                                                }
                                            }
                                        }
                                    }
                                    if (x1 != tablero.length - 1) {
                                        if (tablero[x1 + 1][y1] instanceof Pieza) {
                                            if ((tablero[x1 + 1][y1] instanceof Rey)) {
                                                Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                    tablero[x1 + 1][y1] = " ";
                                                    jugador1 = true;
                                                }
                                            } else if ((tablero[x1 + 1][y1] instanceof Duque)) {
                                                Pieza t = (Pieza) tablero[x1 + 1][y1];
                                                if (new Pieza().duqueinmortal(x1 + 1, y1, tablero)) {

                                                } else {
                                                    if (t.capturar(t, x1, y1, x1 + 1, y1, tablero)) {
                                                        tablero[x1 + 1][y1] = " ";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                juego = true;

                            } else {
                                System.out.println(" ¡No se puede mover a la posicion ingresada!\n !Trate de nuevo!");
                            }

                        } else {
                            System.out.println(" ¡No puede mover la pieza escogida!\n¡TRATE DE NUEVO!");
                        }
                        Imprimir(tablero);
                    }
                }
            }
            cont++;
        }
        if (jugador1) {
            System.out.println("Ganador el jugador que llevaba Rebeldes");
        } else {
            System.out.println("Ganador el jugador que usaba el Rey");
        }
    }

    public static Object[][] tablero(Object tablero[][], int cont, int con) {
        if ((cont == 0 && con == 0) || (cont == 0 && con == 1) || (cont == 0 && con == tablero.length - 1) || (cont == 0 && con == tablero.length - 2) || (cont == 1 && con == 0) || (cont == 1 && con == 1) || (cont == 1 && con == tablero.length - 1) || (cont == 1 && con == tablero.length - 2)) {
            tablero[cont][con] = new Castillo();
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        } else if (con == tablero.length - 1 && cont == tablero.length - 1) {
            tablero[cont][con] = new Castillo();
            return tablero;
        } else if ((cont == tablero.length - 1 && con == 0) || (cont == tablero.length - 1 && con == 1) || (cont == tablero.length - 1 && con == tablero.length - 1) || (cont == tablero.length - 1 && con == tablero.length - 2) || (cont == tablero.length - 2 && con == 0) || (cont == tablero.length - 2 && con == 1) || (cont == tablero.length - 2 && con == tablero.length - 1) || (cont == tablero.length - 2 && con == tablero.length - 2)) {
            tablero[cont][con] = new Castillo();
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        } else if (cont == 9 && con == 9) {
            tablero[cont][con] = new Castillo();
            tablero[cont][con] = new Rey(Color.white);
            con++;
            return tablero(tablero, cont, con);
        } else if ((cont == 0 && con == 2) || (cont == 0 && con == 5) || (cont == 0 && con == 13) || (cont == 0 && con == 16)) {
            tablero[cont][con] = new Rebelde(Color.BLACK);
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        } else if ((cont == 2 && con == 0) || (cont == 2 && con == 5) || (cont == 2 && con == 13) || (cont == 2 && con == tablero.length - 1)) {
            tablero[cont][con] = new Rebelde(Color.black);
            if (con != tablero.length - 1) {
                con++;
            } else {
                cont++;
                con = 0;
            }
            return tablero(tablero, cont, con);
        } else if (cont == 3 && con != tablero.length - 1) {
            if ((con == 7) || (con == 9) || (con == 11)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                con++;
                return tablero(tablero, cont, con);
            }
        } else if (cont == 4 && con != tablero.length - 1) {
            if ((con == 6) || (con == 12)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else if (con == 8 || con == 10) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                con++;
                return tablero(tablero, cont, con);

            }
        } else if (cont == 5) {
            if ((con == 0) || (con == 2) || (con == 5) || (con == 13) || (con == 16) || (con == tablero.length - 1)) {
                if (con == tablero.length - 1) {
                    tablero[cont][con] = new Rebelde(Color.BLACK);
                    cont++;
                    con = 0;
                    return tablero(tablero, cont, con);
                } else {
                    tablero[cont][con] = new Rebelde(Color.BLACK);
                    con++;

                    return tablero(tablero, cont, con);
                }
            } else {
                tablero[cont][con] = " ";
                con++;
                return tablero(tablero, cont, con);
            }
        }/* else if (cont == 6) {
            if ((con == 4) || (con == 14)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else if (con == 9) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);

            }
        } else if (cont == 7) {
            if ((con == 3) || (con == 15)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);

            } else if (con == 8 || con == 10) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        }*/ else if (cont == 8) {
            if ((con == 4) || (con == 7) || (con == 9) || (con == 11 || (con == 14))) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        } else if (cont == 9) {
            if (con == 3 || con == 15) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else if ((con == 6) || (con == 8) || (con == 10) || (con == 12)) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        } else if (cont == 10) {
            if ((con == 4) || (con == 7) || (con == 9) || (con == 11 || (con == 14))) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        } else if (cont == 11) {

            if ((con == 3) || (con == 15)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);

            } else if (con == 8 || con == 10) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        } else if (cont == 12) {
            if ((con == 4) || (con == 14)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else if (con == 9) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        } else if (cont == 13) {
            if ((con == 0) || (con == 2) || (con == 5) || (con == 13) || (con == 16) || (con == tablero.length - 1)) {
                if (con == tablero.length - 1) {
                    tablero[cont][con] = new Rebelde(Color.BLACK);
                    cont++;
                    con = 0;
                    return tablero(tablero, cont, con);
                } else {
                    tablero[cont][con] = new Rebelde(Color.BLACK);
                    con++;

                    return tablero(tablero, cont, con);
                }
            } else {
                tablero[cont][con] = " ";
                con++;
                return tablero(tablero, cont, con);
            }
        } else if (cont == 14) {
            if ((con == 6) || (con == 12)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else if (con == 8 || con == 10) {
                tablero[cont][con] = new Duque(Color.white);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                if (con == tablero.length - 1 && cont != tablero.length - 1) {
                    cont++;
                    con = 0;
                } else if (con != tablero.length - 1) {
                    con++;
                }
                return tablero(tablero, cont, con);
            }
        } else if (cont == 15 && con != tablero.length - 1) {
            if ((con == 7) || (con == 9) || (con == 11)) {
                tablero[cont][con] = new Rebelde(Color.BLACK);
                con++;
                return tablero(tablero, cont, con);
            } else {
                tablero[cont][con] = " ";
                con++;
                return tablero(tablero, cont, con);
            }
        } else if ((cont == 16 && con == 0) || (cont == 16 && con == 5) || (cont == 16 && con == 13) || (cont == 16 && con == tablero.length - 1)) {
            tablero[cont][con] = new Rebelde(Color.black);
            if (con != tablero.length - 1) {
                con++;
            } else {
                cont++;
                con = 0;
            }
            return tablero(tablero, cont, con);
        } else if ((cont == tablero.length - 1 && con == 2) || (cont == tablero.length - 1 && con == 5) || (cont == tablero.length - 1 && con == 13) || (cont == tablero.length - 1 && con == 16)) {
            tablero[cont][con] = new Rebelde(Color.BLACK);
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        } else {
            tablero[cont][con] = " ";
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        }
    }

    public static void Imprimir(Object tablero[][]) {
        System.out.println("   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18");
        for (int i = 0; i < tablero.length; i++) {
            if (i < 10) {
                System.out.print(" " + i);
            } else {
                System.out.print(i);
            }
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println("");

        }
    }
}
