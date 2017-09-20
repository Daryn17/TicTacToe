/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author darin
 */
public class modelo {
    // Declaración de todas las variables involucradas en el juego 
    private byte turno = 1;// variable para identificar cual jugador esta jugando 1 = jugador 1 y 2 = jugador 2 
    // Variables para marcar en la matriz 
    private String marcaX = "X";
    private String marcaO = "O";
    // Variable para identificar cual jugador gano o si hubo un empate
    // 1 = jugador 1 gano, 2 = jugador 2 gano y 3 = se empato el juego 
    private byte ganador = 0;
    // Matriz para visiualizar los moviminetos
    private String tableroJuego[][] = {{"","",""},
                                       {"","",""},
                                       {"","",""}
                                      };
    //Creación de un costructor vacio
    public modelo() {
    }
    
    
}
