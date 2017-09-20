/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import vista.vistaJuego;
import controlador.controlador;
import modelo.modelo;
/**
 *
 * @author darin
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                 //nuevas instancias de clase
        modelo modelo = new modelo();
        vistaJuego vista = new vistaJuego();
        controlador controlador = new controlador( vista , modelo );
        controlador.iniciarTablero();
        vista.setVisible(true);
    }
    
}
