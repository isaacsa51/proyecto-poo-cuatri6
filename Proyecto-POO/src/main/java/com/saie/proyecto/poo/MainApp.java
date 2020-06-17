package com.saie.proyecto.poo;

import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainApp {
    public static void main(String[] args) {
        Connection estadoConn;
        
        //Instanciar objeto bdConn
        ConexionBD bdConn = new ConexionBD();
        
        //Mandar a llamar el método de la clase para poder conectarse a la bd
        estadoConn = bdConn.conectarBD();

        LoginForm loginUI = new LoginForm();
        loginUI.runLogin();

        //En caso de error mostrar ventana de error antes de ingresar al login
        if(estadoConn == null){
            //JOptionPane.showMessageDialog(null, "Hubo un error al intentar conectarse a la base de datos.", "Error con BD", JOptionPane.ERROR_MESSAGE);

            loginUI.runLogin();

//            JFrame app = new JFrame("Sistema - Multivideo");
//            app.setContentPane(new LoginForm().loginPanel);
//            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            app.setLocationRelativeTo(null);
//            app.pack();
//            app.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Después de esta ventana tendría que abrir el login form para su inicio de sesión.", "Conectado", JOptionPane.DEFAULT_OPTION);
            
//            JFrame app = new JFrame("Sistema - Multivideo");
//            app.setContentPane(new LoginForm().loginPanel);
//            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            app.setLocationRelativeTo(null);
//            app.pack();
//            app.setVisible(true);
        }
    }
}
