package com.multivideo.proyecto;

import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pelicula {
	//Conexión con BD mediado con un Singleton
    Connection conn = ConexionBD.getInstance().getConnection();

    InicioApp ventanaPrincipal = new InicioApp();

	//Métodos

    /*
     *  @param nombre, nombre de la persona
     *  @param telefono, telefono de la persona
     *  @param INE, identificación dejada ingresando su clave de lector, también puede ser curp
     *  @param fechaInicio, inicio de la renta
     *  @param fechaFin, fin de la renta
     *  @param pelicula, nombre de la pelicula
     */
    protected void crearRenta(String nombre, String telefono, String INE, String fechaInicio, String fechaFin, String pelicula){
        
    }

    protected void compraPelicula(){

    }
}
