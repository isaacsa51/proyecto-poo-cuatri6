package com.multivideo.proyecto;

import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Pelicula {
	ConexionBD bdcon = new ConexionBD();
	Connection conStatus = bdcon.connBD;
	
	InicioApp ventanaPrincipal = new InicioApp(); 

	//Métodos
	protected void mostrarPeliculasLista(){
        try{
            String qBuscarPeliculas = "SELECT * FROM peliculas";

            PreparedStatement execQuery = conStatus.prepareStatement(qBuscarPeliculas);
            ResultSet resQuery = execQuery.executeQuery();

            DefaultListModel listaPeliculas = new DefaultListModel();
            
            while (resQuery.next()) {
                String pelicula = resQuery.getString("nombre");

                //Agregar elemento
                listaPeliculas.addElement(pelicula);
            }

            ventanaPrincipal.lstPeliculas.setModel(listaPeliculas);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            if(bdcon != null)
                bdcon.desconectarBD();
        }
    }

    protected void mostrarProductosLista(){
        try{
            String qBuscarProductos = "SELECT * FROM productos";

            PreparedStatement execQuery = conStatus.prepareStatement(qBuscarProductos);
            ResultSet resQuery = execQuery.executeQuery();

            DefaultListModel listaProductos = new DefaultListModel();

            while(resQuery.next()){
                String producto = resQuery.getString("nombre");

                //Agregar elemento
                listaProductos.addElement(producto);
            }

            ventanaPrincipal.lstProductos.setModel(listaProductos);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            if(bdcon != null)
                bdcon.desconectarBD();
        }
    } 

    protected void checarDisponibilidad(String producto, int cantidad){
		
	} 
}
