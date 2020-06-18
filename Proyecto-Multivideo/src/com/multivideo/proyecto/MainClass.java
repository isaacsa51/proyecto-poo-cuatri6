package com.multivideo.proyecto;

import java.sql.*;
import javax.swing.JOptionPane;

public class MainClass {
    public static void main(String[] args) {
        //Instanciar objeto ConexionBD
        ConexionBD bdcon = new ConexionBD();

        //Crear variable para el estado de la conexión
        Connection estadoBD = bdcon.connBD;

        //Mandar a llamar el método para poder conectarse
        bdcon.getConexion();

        if(estadoBD == null){
            JOptionPane.showMessageDialog(null, "Error al intentar conectarse con la base de datos. \n\nFavor de contactarse con el técnico del programa.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            //Método para poder iniciar la ventana login

            //Todas las excepciones generadas fueron por parte del NetBeans
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            // Crear y mostrar la ventana
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new VentanaLogin().setVisible(true);
            }
            });
        }
    }
}
