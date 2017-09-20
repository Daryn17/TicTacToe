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
    private String titulo = "Tic Tac Toe MVC   ";

     //En el constructor inicializamos nuestros objetos 
    public controlador( vistaJuego vista , modelo modelo){
        this.vista = vista;
        this.juego = modelo;
    }
    
    //Inicia los valores del jFrame VISTA con los datos del MODELO
    // tambien añadimos el ActionListener a los botones de la VISTA
    public void iniciarTablero(){
        vista.setTitle( this.titulo );
        vista.setLocationRelativeTo(null);
        this.vista.pos00.addActionListener(this);
        this.vista.pos01.addActionListener(this);
        this.vista.pos02.addActionListener(this);
        this.vista.pos10.addActionListener(this);
        this.vista.pos11.addActionListener(this);
        this.vista.pos12.addActionListener(this);
        this.vista.pos20.addActionListener(this);
        this.vista.pos21.addActionListener(this);
        this.vista.pos22.addActionListener(this);
    }
    
    //Función que se encarga de manar la posicion que se preciono y ademas coloca la marca en la vista
    @Override
    public void actionPerformed(ActionEvent e) {
         Object boton = e.getSource();

        if( this.juego.ganador()== 0 )
        {
            if( boton == this.vista.pos00 )
                this.vista.pos00.setText( this.juego.ColocarMovimiento(1) );
            else if(boton == this.vista.pos01)
                this.vista.pos01.setText( this.juego.ColocarMovimiento(2) );
            else if(boton == this.vista.pos02)
                this.vista.pos02.setText( this.juego.ColocarMovimiento(3) );
            else if(boton == this.vista.pos10)
                this.vista.pos10.setText( this.juego.ColocarMovimiento(4) );
            else if(boton == this.vista.pos11)
                this.vista.pos11.setText( this.juego.ColocarMovimiento(5) );
            else if(boton == this.vista.pos12)
                this.vista.pos12.setText( this.juego.ColocarMovimiento(6) );
            else if(boton == this.vista.pos20)
                this.vista.pos20.setText( this.juego.ColocarMovimiento(7) );
            else if(boton == this.vista.pos21)
                this.vista.pos21.setText( this.juego.ColocarMovimiento(8) );
            else if(boton == this.vista.pos22)
                this.vista.pos22.setText( this.juego.ColocarMovimiento(9) );
            if( this.juego.get_error())
                JOptionPane.showMessageDialog(null, "Error: la casilla ya esta marcada \n Perdiste tu turno");            

            this.vista.setTitle( this.titulo + this.juego.get_turno());
        }
        //Aquí se verifica si hay un ganador o si el juego concluyo en empate
        if( this.juego.ganador()== 1 )
            mensaje(" 'X' ");
        else if( this.juego.ganador()== 2 )
            mensaje(" 'O' ");
        else if( this.juego.ganador()== 3 )
            mensaje(" 'Es un empate' ");
    }
    
    public void mensaje(String msj){
        int seleccion = JOptionPane.showOptionDialog(null,"Gano el jugador " + msj + "\n ¿Que desea hacer?", "Fin del juego",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,    // null para icono por defecto.
                       new Object[] { " Jugar otra vez ", " Salir de Programa " },
                       "Jugar otra vez");

        if (seleccion != -1)
            if( (seleccion+1)==1 )
            {
                this.juego.juegoNuevo();
                this.vista.setTitle(titulo);
                this.vista.pos00.setText( "" );
                this.vista.pos01.setText( "" );
                this.vista.pos02.setText( "" );
                this.vista.pos10.setText( "" );
                this.vista.pos11.setText( "" );
                this.vista.pos12.setText( "" );
                this.vista.pos20.setText( "" );
                this.vista.pos21.setText( "" );
                this.vista.pos22.setText( "" );
            }
            else
                System.exit(0);
    }
    
    
}
