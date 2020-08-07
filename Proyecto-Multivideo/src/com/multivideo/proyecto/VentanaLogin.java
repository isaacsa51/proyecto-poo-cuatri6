package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VentanaLogin extends javax.swing.JFrame {
    //Conexión con BD mediado con un Singleton
    Connection conn = ConexionBD.getConnection();

    //ConexionBD conn = ConexionBD.getInstance();
    //Connection = estadoBD = conn.connBD;

    //Crea la ventana con todos sus componentes
    public VentanaLogin() {
        initComponents();
    }

    /*      No modificar el método initComponents     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloLogin = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txfdUsuario = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pfldContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTituloLogin.setFont(new java.awt.Font("SF Pro Text", 1, 13)); // NOI18N
        lblTituloLogin.setText("Sistema gestor de inventario - MULTIVIDEO");

        lblUsuario.setText("Usuario");

        txfdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfdUsuarioActionPerformed(evt);
            }
        });

        lblPassword.setText("Contrasena");

        btnLogin.setText("Iniciar Sesión");
        btnLogin.setActionCommand("jButton");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTituloLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExit)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfdUsuario)
                                    .addComponent(pfldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTituloLogin)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txfdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(pfldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnExit))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*      No modificar el método initComponents     */

    private void txfdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfdUsuarioActionPerformed

    //Iniciar sesión al dar click al botón
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        //Instanciar objeto Usuario
        Usuario usuarioAcciones = new Usuario();

        //Obtener los valores de los TextField
        String user = txfdUsuario.getText();
        String pass = String.valueOf(pfldContrasena.getPassword());

        //Mandar a llamar el método login para poder hacer los queries necesarios
        if(usuarioAcciones.loginUsuario(user, pass) == 1){
            //Cerrar ventana actual
			this.setVisible(false);
        }
    }
    
    //Al dar click salir de la aplicación
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {        
        this.dispose();
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTituloLogin;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pfldContrasena;
    private javax.swing.JTextField txfdUsuario;
    // End of variables declaration//GEN-END:variables
}
