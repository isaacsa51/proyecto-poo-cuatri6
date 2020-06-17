/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saie.proyecto.poo;

//Importante importar la librería SQL para poder integrar la conexión de una base de datos MySQL al programa
import java.sql.*;

public class ConexionBD {
    public void conectarBD(){
        //Crear un try catch para saber la razón si falla la conexión a la BD
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Cambiar la dirección de la base de datos por IP si es necesario
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/multivideo", "root", "");

            //Esta sección valida si se puede obtener información de la base de datos y mostrarlos en consola
            /*Statement stnt = conn.createStatement();
            ResultSet rs = stnt.executeQuery("select * from employees");
            while(rs.next()){
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6));
                stnt.close();
                conn.close();
            }*/
        }catch(Exception error){
            System.out.println(error);
        }
    }
}
