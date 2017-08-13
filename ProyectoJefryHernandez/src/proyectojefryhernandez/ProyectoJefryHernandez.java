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
public class ProyectoJefryHernandez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[][] tablero = new Object[19][19];
        tablero(tablero, 0, 0);
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

    public static Object[][] tablero(Object tablero[][], int cont, int con) {
        if ((cont == 0 && con == 0) || (cont == 0 && con == 1) || (cont == 0 && con == tablero.length - 1) || (cont == 0 && con == tablero.length - 2) || (cont == 1 && con == 0) || (cont == 1 && con == 1) || (cont == 1 && con == tablero.length - 1) || (cont == 1 && con == tablero.length - 2)) {
            tablero[cont][con] = "X";
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        } else if (con == tablero.length - 1 && cont == tablero.length - 1) {
            tablero[cont][con] = "X";
            return tablero;
        } else if ((cont == tablero.length - 1 && con == 0) || (cont == tablero.length - 1 && con == 1) || (cont == tablero.length - 1 && con == tablero.length - 1) || (cont == tablero.length - 1 && con == tablero.length - 2) || (cont == tablero.length - 2 && con == 0) || (cont == tablero.length - 2 && con == 1) || (cont == tablero.length - 2 && con == tablero.length - 1) || (cont == tablero.length - 2 && con == tablero.length - 2)) {
            tablero[cont][con] = "X";
            if (con == tablero.length - 1 && cont != tablero.length - 1) {
                cont++;
                con = 0;
            } else if (con != tablero.length - 1) {
                con++;
            }
            return tablero(tablero, cont, con);
        } else if (cont == 9 && con == 9) {
            tablero[cont][con] = "X";
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
            } else if (cont == 5) {
                if ((con == 0) || (con == 2) || (con == 5) || (con == 13) || (con == 16) || (con == tablero.length - 1)      {
                    if (con != tablero.length - 1) {
                        tablero[cont][con] = new Rebelde(Color.BLACK);
                        con++;
                        return tablero(tablero, cont, con);
                    } else {
                        tablero[cont][con] = new Rebelde(Color.BLACK);
                        cont++;
                        con = 0;
                        return tablero(tablero, cont, con);
                    }
                } else {
                    tablero[cont][con] = " ";
                    con++;
                    return tablero(tablero, cont, con);
                }
            } else {
                tablero[cont][con] = " ";
                con++;
                return tablero(tablero, cont, con);
            }
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

}
