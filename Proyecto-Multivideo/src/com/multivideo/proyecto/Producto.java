package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Producto{
    //Conexión con BD mediado con un Singleton
    Connection conn = ConexionBD.getInstance().getConnection();

    InicioApp ventanaPrincipal = new InicioApp();

	//Métodos
    protected int checarDisponibilidad(String producto, int cantidad){
        try { 
			String qChecarDisponibilidad = "SELECT nombre, cantidad FROM productos WHERE nombre = ? AND cantidad > 0";

			PreparedStatement execQuery = conn.prepareStatement(qChecarDisponibilidad);
			
			execQuery.setString(1, producto);
			ResultSet resultQuery = execQuery.executeQuery();

			//Checar disponibilidad
			if(resultQuery.next()){
				int productosStock = resultQuery.getInt("cantidad");

				//Crear resta entre los productos seleciconados y la cantidad en inventario para checar si se puede retirar
				int resta = cantidad - productosStock;

				if(resta > 0){
					JOptionPane.showMessageDialog(null, "Se seleccionó más productos de los que se disponen.", "Producto sin stock", JOptionPane.WARNING_MESSAGE);

					return 1;
				}else{
					return 0;
				}
			}else{
				JOptionPane.showMessageDialog(null, "El producto no se encuentra en stock", "Productos sin stock", JOptionPane.WARNING_MESSAGE);

				return 1;
			}
		}catch(SQLException e){
            e.printStackTrace();
		}

		return 0;
	}
	
	protected void mostrarCompra(String producto, int cantidad, InicioApp ventanaApp){
		try{
			String queryCompra = "SELECT nombre, cantidad, precio FROM productos WHERE nombre = ?";

			PreparedStatement execQuery = conn.prepareStatement(queryCompra);
			
			execQuery.setString(1, producto);
			ResultSet resultQuery = execQuery.executeQuery();

			DefaultTableModel tablaTotal = (DefaultTableModel) ventanaApp.tblTotal.getModel();

			//Hacer que la tabla se de cuenta de la ultima posición
            tablaTotal.setRowCount(tablaTotal.getRowCount());

			while(resultQuery.next()){
				//Obtener precio total
				float precioTotal = resultQuery.getFloat("precio") * cantidad;

				//Campos a rellenar
				Object resultadoProducto[] = {
					producto,
					cantidad,
					precioTotal
				};

				//Poner información en la tabla 
				tablaTotal.addRow(resultadoProducto);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
