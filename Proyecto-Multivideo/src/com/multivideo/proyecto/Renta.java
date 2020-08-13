package com.multivideo.proyecto;

import java.sql.CallableStatement;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Renta {
	//Conexión a la BD
	Connection conn = ConexionBD.getInstance().getConnection();

	//Métodos
	protected void crearRenta(String ine, String idPelicula, String inicio, String entrega){
            try{
                String procRenta = "CALL Insertar_Renta(?, ?, ?, ?)";
                
                CallableStatement cs = null;
                
                cs = conn.prepareCall(procRenta);
                cs.setString(1, ine);
                cs.setString(2, idPelicula);
                cs.setString(3, inicio);
                cs.setString(4, entrega);
                
                //Ejecutar procedimiento
                cs.execute();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al intentar crear renta.\n" + e, "Error", JOptionPane.WARNING_MESSAGE);
            }
	}

	protected void elimRenta(int idrenta){
		PeliculasRentadas tablaRentas = new PeliculasRentadas();

		try{
			String queryElimRenta = "DELETE FROM rentas WHERE idrenta = ?";
			PreparedStatement execQuery = null;

			execQuery = conn.prepareStatement(queryElimRenta);
			execQuery.setInt(1, idrenta);
			execQuery.executeUpdate();

		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al intentar eliminar la renta.\n" + e, "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
