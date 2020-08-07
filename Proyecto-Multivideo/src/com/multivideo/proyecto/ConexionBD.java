package com.multivideo.proyecto;

//Importante importar la librería SQL para poder integrar la conexión de una base de datos MySQL al programa
import java.sql.*;

public class ConexionBD {


    // Propiedades
    private static Connection conn = null;
 
    // Constructor
    private ConexionBD(){
 
        String url = "jdbc:mysql://localhost:3306/multivideo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String usuario = "root";
        String password = "";
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectado!");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    } // Fin constructor
    
    // Métodos
    public static Connection getConnection(){
        if (conn == null){
            new ConexionBD();
        }
        
        return conn;
    }

    public static void cerrarConexion() throws SQLException {
        if (conn != null){
            conn.close();
        }
    }


    // //Variables de la base de datos
    // protected Connection connBD;
    // private static final String driver = "com.mysql.cj.jdbc.Driver";
    // private static final String user = "root";
    // private static final String password = "";
    // private static final String url = "jdbc:mysql://localhost:3306/multivideo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";



    // //create an object of SingleObject
    // private static ConexionBD singletonConn = new ConexionBD();

    // //make the constructor private so that this class cannot be
    // //instantiated
    // private ConexionBD(){}

    // //Get the only object available
    // public static ConexionBD getInstance(){
    //     return singletonConn;
    // }

    // // Método singleton
    // public void hacerConexion(){
    //     connBD = null;

    //     try{
    //         Class.forName(driver);
    //         connBD = DriverManager.getConnection(url, user, password);

    //         if(connBD != null){
    //             System.out.println("Conexión establecida");
    //         }
                
    //     }catch(ClassNotFoundException | SQLException errorBD){
    //         System.out.println("Error con la BD \n" + errorBD);
    //     }
    // }

    // //Método para desconectar y cerrar base de datos
    // public void desconectarBD(){
    //     connBD = null;

    //     if(connBD == null){
    //         System.out.println("Conexión terminada");
    //     }
    // }

    // public Connection getConexion(){
    //     return connBD;
    // }

    // //Constructor de la clase para conectarse a la BD
    // public ConexionBD(){
    //     connBD = null;

        // try{
        //     Class.forName(driver);
        //     connBD = DriverManager.getConnection(url, user, password);

        //     if(connBD != null){
        //         //System.out.println("Conexión establecida");

        //         //Esta sección valida si se puede obtener información de la base de datos y mostrarlos en consola
        //         /*Statement stnt = conn.createStatement();
        //         ResultSet rs = stnt.executeQuery("select * from employees");
        //         while(rs.next()){
        //             System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6));
        //             stnt.close();
        //             conn.close();
        //         }*/
        //     }
            
    //     }catch(ClassNotFoundException | SQLException errorBD){
    //         System.out.print("PRUEBA\n\n" + errorBD);
    //     }
    // }

    // //Método para poder conectarse y hacer una instancia de este método
    // public Connection getConexion(){
    //     return connBD;
    // }
}
