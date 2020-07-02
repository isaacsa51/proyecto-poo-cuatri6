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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ghost
 */
public class ReportesMod {
    
    ConexionBD bdcon = new ConexionBD();
    Reportes vista;
    
    public ReportesMod(Reportes vist){
       vista = vist;
    }
    
    public void mostrar(String condicion){
        Connection connection;
        PreparedStatement ps;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/multivideo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            ps = connection.prepareStatement("SELECT * FROM ventas WHERE ?");
            
            ps.setString(1, condicion);
            ResultSet result = ps.executeQuery();
            
            DefaultTableModel modelotabla = (DefaultTableModel) vista.tbl_reportes.getModel();
            modelotabla.setRowCount(0);
            
            String cliente;
            String producto;
            ResultSet temp;
            
            while(result.next()){
                
                //Obtener nombre de cliente
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
                
                modelotabla.addRow(o);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void dia(){
        mostrar("fecha=TODAY()");
    }
    
    public void mes(){
        mostrar("MONTH(fecha)=MONTH(CURRENT_TIMESTAMP)");
    }
    
    public void año(){
        mostrar("YEAR(fecha)=YEAR(CURRENT_TIMESTAMP)");
    }
    
    public void regresar(){
        
    }
}
