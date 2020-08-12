package com.multivideo.proyecto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Renta {
	//Conexión a la BD
	Connection conn = ConexionBD.getInstance().getConnection();

	//Métodos
	protected void crearRenta(String nombre, String telefono, String INE, String fechaInicio, String fechaFin, String pelicula){

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
