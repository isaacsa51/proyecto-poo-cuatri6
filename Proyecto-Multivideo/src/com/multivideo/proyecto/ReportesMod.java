/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ghost
 */
public class ReportesMod {
    //Conexión con BD mediado con un Singleton
    Connection conn = ConexionBD.getInstance().getConnection();
    Reportes vista;
    
    public ReportesMod(Reportes vist){
       vista = vist;
    }
    
    public void mostrar(String condicion){
        Connection connection;
        PreparedStatement ps = null;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/multivideo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            
            if(condicion == "dia")
            ps = connection.prepareStatement("SELECT * FROM compras WHERE CURDATE() = fecha");
            else if(condicion == "mes")
            ps = connection.prepareStatement("SELECT * FROM compras WHERE YEAR(CURDATE()) = YEAR(fecha) AND MONTH(CURDATE()) = MONTH(fecha)");
            else if(condicion == "año")
            ps = connection.prepareStatement("SELECT * FROM compras WHERE YEAR(CURDATE()) = YEAR(fecha)");
            //ps = connection.prepareStatement("SELECT * FROM compras");
            
            //ps.setString(1, condicion);
            ResultSet result = ps.executeQuery();
            
            DefaultTableModel modelotabla = (DefaultTableModel) vista.tbl_reportes.getModel();
            modelotabla.setRowCount(0);
            
            String rtipo = "";
            String rcliente = "";
            String rnombre = "";
            int rcantidad = 0;
            
            ResultSet temp;
            
            while(result.next()){
                
                /*//Obtener nombre de cliente
                ps = connection.prepareStatement("Select nombre FROM clientes WHERE INE=?");
                ps.setString(1, result.getString("INE"));
                temp = ps.executeQuery();
                cliente = temp.getString("nombre");
                
                //PRODUCTOS
                ps = connection.prepareStatement("Select nombre FROM productos WHERE idproducto=?");
                ps.setString(1, result.getString("idproducto"));
                temp = ps.executeQuery();
                producto = temp.getString("nombre");
                
                Object o[] = {result.getInt("id_ventas"), 
                    result.getString(cliente), 
                    result.getString(producto), 
                    result.getInt("cantidad"),
                    result.getString("fecha"),
                    result.getFloat("precio"),};
                
                modelotabla.addRow(o);*/
                
                //Si es un producto...
                System.out.println(result.getInt("idcompra"));
                if(result.getInt("cantidad_producto") != 0){
                    rtipo = "Compra/Producto";
                    
                    ps = connection.prepareStatement("Select nombre FROM productos WHERE idproducto=?");
                    //ps.setString(1, Integer.toString(result.getInt("idproducto")));
                    ps.setInt(1, result.getInt("idproducto"));
                    temp = ps.executeQuery();
                    temp.next();
                    rnombre = temp.getString("nombre");
                    
                    rcantidad = result.getInt("cantidad_producto");
                }
                //Si es renta
                else if(result.getInt("cantidad_renta") != 0){
                    rtipo = "Renta/Pelicula";
                    
                    //Look for movie name
                    ps = connection.prepareStatement("Select nombre FROM peliculas WHERE idpelicula=?");
                    ps.setString(1, Integer.toString(result.getInt("idpelicula")));
                    temp = ps.executeQuery();
                    temp.next();
                    rnombre = temp.getString("nombre");
                    
                    rcantidad = result.getInt("cantidad_renta");
                }
                else{
                    rtipo = "Compra/Pelicula";
                    
                    //Look for movie name
                    ps = connection.prepareStatement("Select nombre FROM peliculas WHERE idpelicula=?");
                    ps.setString(1, Integer.toString(result.getInt("idpelicula")));
                    temp = ps.executeQuery();
                    temp.next();
                    rnombre = temp.getString("nombre");
                    
                    rcantidad = result.getInt("cantidad_pelicula");
                }
                
                //Obtener nombre de cliente
                ps = connection.prepareStatement("Select nombre FROM clientes WHERE ine=?");
                ps.setString(1, result.getString("ine"));
                temp = ps.executeQuery();
                temp.next();
                rcliente = temp.getString("nombre");
                
                
                Object o[] = {result.getInt("idcompra"), 
                    rtipo,
                    rnombre,
                    rcliente,
                    rcantidad,
                    result.getString("fecha"),
                    result.getFloat("total")};
                modelotabla.addRow(o);
            }
            vista.tbl_reportes.setModel(modelotabla);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public void regresar(){
        
    }
}
