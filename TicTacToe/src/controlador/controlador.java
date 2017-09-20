/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
//Se importa la vista y el modelo para poder acceder a ellas desde el controlador 
import modelo.modelo;
import vista.vistaJuego;

//Se importan estas librerias para realizar eventos 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author darin
 */
//Se le implemente el actionlistener a la clase controlador 
public class controlador implements ActionListener{
    private vistaJuego vista;
    private modelo juego;
    private String titulo = "Tic Tac Toe MVC";

     //En el constructor inicializamos nuestros objetos 
    public controlador( vistaJuego vista , modelo modelo){
        this.vista = vista;
        this.juego = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    
}
