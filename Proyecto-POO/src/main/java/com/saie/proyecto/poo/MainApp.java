package com.saie.proyecto.poo;

public class MainApp {
    public static void main(String[] args) {
        //Instanciar objeto bdConn
        ConexionBD bdConn = new ConexionBD();
        
        //Mandar a llamar el método de la clase para poder conectarse a la bd
        bdConn.conectarBD();
    }
}
