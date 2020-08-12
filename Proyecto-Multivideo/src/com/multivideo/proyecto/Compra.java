package com.multivideo.proyecto;

import java.sql.Connection;

public class Compra {
	//Conexión a la BD
	Connection conn = ConexionBD.getInstance().getConnection();

	//Métodos
	protected void crearCompra(String[] productos, int[] cantidad, float precioTotal, float precioCliente){

	}
}
