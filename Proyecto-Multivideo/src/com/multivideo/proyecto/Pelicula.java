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
    protected void checarDisponibilidad(String producto, int cantidad){
        try { 
			String qChecarDisponibilidad = "SELECT nombre FROM peliculas WHERE nombre = ? AND stock > 0";

			PreparedStatement execQuery = conn.prepareStatement(qChecarDisponibilidad);
			
			execQuery.setString(1, producto);
			ResultSet resultQuery = execQuery.executeQuery();

            DefaultTableModel tablaTotal = (DefaultTableModel) ventanaPrincipal.tblTotal.getModel();
            tablaTotal.setRowCount(0);

            //Poner información del producto a la tabla
            while(resultQuery.next()){
                Object PeliculaSeleccionada[] =  {
                    producto,
                    cantidad
                    //resultQuery.getFloat("Precio")
                };

                // Poner información sacada en cada columna de la tabla
                tablaTotal.addRow(PeliculaSeleccionada);
            }

			// //Checar disponibilidad
			// if(resultQuery.next()){
            //     //Poner información del producto a la tabla
            //     while(resultQuery.next()){
            //         Object PeliculaSeleccionada[] =  {
            //             producto,
            //             cantidad,
            //             resultQuery.getFloat("precio")
            //         };

            //         // Poner información sacada en cada columna de la tabla
            //         tablaTotal.addRow(PeliculaSeleccionada);
            //     }
			// }else{
			// 	JOptionPane.showMessageDialog(null, "La pelicula no se encuentra en stock o seleccionó más peliculas de los que se disponen.", "Productos sin disponibilidad", JOptionPane.WARNING_MESSAGE);
			// }
		}catch(SQLException e){
			e.printStackTrace();
		}
	} 
}
