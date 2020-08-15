/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;

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

    public void mostrar(String condicion, String utilfecha){
        String query;

        if(condicion == "dia"){
            query = "SELECT * FROM compras WHERE fecha = ?";
            mostrarDia(query, utilfecha);
        }else if(condicion == "mes"){
            query = "SELECT * FROM compras WHERE YEAR(?) = YEAR(fecha) AND MONTH(?) = MONTH(fecha)";
            mostrarMes(query, utilfecha);
        }else if(condicion == "anio"){
            query = "SELECT * FROM compras WHERE YEAR(?) = YEAR(fecha)";
            mostrarAnio(query, utilfecha);
        }
    }

    protected void mostrarDia(String query, String fecha){
        PreparedStatement execQ = null;

        try{
            execQ = conn.prepareStatement(query);
            execQ.setString(1, fecha);

            ResultSet resQ = execQ.executeQuery();

            DefaultTableModel modelotabla = (DefaultTableModel) vista.tbl_reportes.getModel();
            modelotabla.setRowCount(0);

            while (resQ.next()){
                Object reporte[] = {
                        resQ.getInt("idcompra"),
                        resQ.getInt("idrenta"),
                        resQ.getString("nombre_pelicula"),
                        resQ.getString("fecha"),
                        resQ.getFloat("total")
                };

                modelotabla.addRow(reporte);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void mostrarMes(String query, String fecha){
        PreparedStatement execQ = null;

        try{
            execQ = conn.prepareStatement(query);
            execQ.setString(1, fecha);
            execQ.setString(2, fecha);

            ResultSet resQ = execQ.executeQuery();

            DefaultTableModel modelotabla = (DefaultTableModel) vista.tbl_reportes.getModel();
            modelotabla.setRowCount(0);

            while (resQ.next()){
                Object reporte[] = {
                        resQ.getInt("idcompra"),
                        resQ.getInt("idrenta"),
                        resQ.getString("nombre_pelicula"),
                        resQ.getString("fecha"),
                        resQ.getFloat("total")
                };

                modelotabla.addRow(reporte);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void mostrarAnio(String query, String fecha){
        PreparedStatement execQ = null;

        try{
            execQ = conn.prepareStatement(query);
            execQ.setString(1, fecha);

            ResultSet resQ = execQ.executeQuery();

            DefaultTableModel modelotabla = (DefaultTableModel) vista.tbl_reportes.getModel();
            modelotabla.setRowCount(0);

            while (resQ.next()){
                Object reporte[] = {
                        resQ.getInt("idcompra"),
                        resQ.getInt("idrenta"),
                        resQ.getString("nombre_pelicula"),
                        resQ.getString("fecha"),
                        resQ.getFloat("total")
                };

                modelotabla.addRow(reporte);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
