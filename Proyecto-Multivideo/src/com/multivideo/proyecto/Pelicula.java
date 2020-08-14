package com.multivideo.proyecto;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pelicula {
	//Conexión con BD mediado con un Singleton
    Connection conn = ConexionBD.getInstance().getConnection();

    InicioApp ventanaPrincipal = new InicioApp();

	//Métodos
    protected int checarDisponibilidad(String pelicula, int cantidad){
        try {
            String qChecarDisponibilidad = "SELECT nombre, cantidad FROM peliculas WHERE nombre = ? AND cantidad > 0";

            PreparedStatement execQuery = conn.prepareStatement(qChecarDisponibilidad);

            execQuery.setString(1, pelicula);
            ResultSet resQuery = execQuery.executeQuery();

            //Checar disponibilidad
            if(resQuery.next()){
                int peliculasStock = resQuery.getInt("cantidad");

                //Crear resta entre peliculas seleccionadas y en stock
                int resta = cantidad - peliculasStock;

                if(resta > 0){
                    JOptionPane.showMessageDialog(null, "Se seleccionó más productos de los que se disponen.", "Pelicula sin stock", JOptionPane.WARNING_MESSAGE);

                    return 1;
                }else{
                    return 0;
                }
            }else{
                JOptionPane.showMessageDialog(null, "La pelicula no se encuentra en stock", "Productos sin stock", JOptionPane.WARNING_MESSAGE);

				return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
