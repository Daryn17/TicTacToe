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
    private boolean error = false;//Bandera para controlar los errores que lleguen a suceder 
    
    //Creación de un costructor vacio
    public modelo() {
    }
    
    //Se limpia el tablero y se vuelven a poner la variables como al inicio 
    public void juegoNuevo(){
        for (int i = 0; i < this.tableroJuego.length; i++) {
            for (int j = 0; j < this.tableroJuego.length; j++) {
                this.tableroJuego[i][j] = "";
            }
        }
        this.ganador = 0;
        this.error = false;
        this.turno = 1;
    }
    
    //Resive la posición de donde el jugador apreto, por medio del controlador 
    //Coloca la marca en la matriz ya sea X o O 
    public String ColocarMovimiento(int posicion)
    {
        String jugada="";
        if(turno==1)
        {
            jugada = marcar(posicion , this.marcaX);
            //si no se pudo marcar => continua con su turno
            turno = 2;
            if ( ganoFila(this.tableroJuego, this.marcaX)|| 
                    ganoColumna(this.tableroJuego, this.marcaX)|| 
                    ganoDiagonal(this.tableroJuego, this.marcaX))
                this.ganador=1;
            else if ( empate() )
                this.ganador=3;
        }
        else
        {
            jugada =  marcar(posicion , this.marcaO);
            turno = 1;
            if ( ganoFila(this.tableroJuego, this.marcaO)|| 
                    ganoColumna(this.tableroJuego, this.marcaX)|| 
                    ganoDiagonal(this.tableroJuego, this.marcaX))
                this.ganador=2;
            else if ( empate() )
                this.ganador=3;
        }
        return jugada;
    }
    
    //Coloca la marca del jugador
    private String marcar(int Posicion, String value)
    {
       String marca="";
       switch (Posicion)
       {
           case 1:marca = sub_marcar(0,0,value); break;
           case 2:marca = sub_marcar(0,1,value); break;
           case 3:marca = sub_marcar(0,2,value); break;
           case 4:marca = sub_marcar(1,0,value); break;
           case 5:marca = sub_marcar(1,1,value); break;
           case 6:marca = sub_marcar(1,2,value); break;
           case 7:marca = sub_marcar(2,0,value); break;
           case 8:marca = sub_marcar(2,1,value); break;
           case 9:marca = sub_marcar(2,2,value); break;
       }
       return marca;
    }
    
    private String sub_marcar(int x, int y, String value)
    {
        String marca="";
        this.error=false;
        if( this.tableroJuego[x][y].equals("") ) //se puede marcar
        {
            this.tableroJuego[x][y] = value;
            marca = value;
        }
        else//ya esta marcado
        {
            marca = this.tableroJuego[x][y];
            this.error=true;//Error=>se trata de marcar casilla ya marcada
        }
        return marca;
    }
    
    //Retorna el error
    public boolean get_error()
    {
        return this.error;
    }

    //Retorna el turno del jugador
    public String get_turno()
    {
        return (this.turno==1)? "Turno: X":"Turno: O";
    }

    //Retorna el ganador de la partida
    public byte ganador()
    {
        return this.ganador;
    }

    //funcion que determina quien gano la partida
    public boolean ganoFila( String matriz[][], String marca ){
        //busqueda la jugada ganadora por fila
        for ( int i = 0 ; i < matriz.length ; i++ )
        {
            byte count=0;
            for ( int j = 0 ; j < matriz.length ; j++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        return false;
    }
    
    public boolean ganoColumna(String matriz[][], String marca){
        //busqueda la jugada ganadora por columnas
        for ( int j = 0 ; j < matriz.length ; j++ )
        {
            byte count=0;
            for ( int i = 0 ; i < matriz.length ; i++)
                count+=( matriz[i][j].equals(marca) )?1:0;
            if( count == 3)
                 return true;
        }
        return false;
    }
    
    public boolean ganoDiagonal(String matriz[][],String marca){
        //busqueda la jugada ganadora por diagonales
        if(  matriz[0][0].equals(marca) && matriz[1][1].equals(marca) && matriz[2][2].equals(marca) )
            return true;

        if(  matriz[0][2].equals(marca) && matriz[1][1].equals(marca) && matriz[2][0].equals(marca) )
            return true;
        
        return false;
    }

    //Funcion que determina si hay empate o si el juego continua 
    private boolean empate()
    {
        for ( int i = 0 ; i < tableroJuego.length ; i++ )
           for ( int j = 0 ; j < tableroJuego.length ; j++)
                if( tableroJuego[i][j].equals(""))
                    return false;
        return true;
    }

}
