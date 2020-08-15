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
	protected void crearRenta(String nombre, String telefono, String ine, String pelicula, String inicio, String entrega){
            
		try{
			String regCliente = "{CALL Insertar_Clientes(?, ?, ?)}";

			CallableStatement procCliente = null;

			procCliente = conn.prepareCall(regCliente);

			procCliente.setString(1, ine);
			procCliente.setString(2, nombre);
			procCliente.setString(3, telefono);

			procCliente.execute();

			//Crear renta
			try{
				String procRenta = "{CALL Insertar_Renta(?, ?, ?, ?, ?)}";

				CallableStatement cs = null;

				cs = conn.prepareCall(procRenta);
				cs.setString(1, ine);
				cs.setString(2, telefono);
				cs.setString(3, pelicula);
				cs.setString(4, inicio);
				cs.setString(5, entrega);

				//Ejecutar procedimiento
				cs.execute();

				JOptionPane.showMessageDialog(null, "Renta creada exitosamente!");

			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error al intentar crear renta.\n" + e, "Error", JOptionPane.WARNING_MESSAGE);
			}

		}catch (Exception e){
			e.printStackTrace();
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
