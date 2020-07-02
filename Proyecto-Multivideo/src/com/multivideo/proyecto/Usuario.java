package com.multivideo.proyecto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Usuario extends JDialog{
	private JTextField tfUser;
	private JPasswordField pfPassword;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnCrear;
	private JButton btnCancelar;

	static GraphicsConfiguration gc;

	public void aggUsuario(){
		JFrame frame= new JFrame(gc);	
		frame.setTitle("Agregar usuarios");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(10, 10, 100, 100);
		tfUser = new JTextField(20);
		tfUser.setBounds(20, 20, 100, 100);

		lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(30, 30, 100, 100);
		pfPassword = new JPasswordField(20);
		pfPassword.setBounds(40, 40, 100, 100);
		
		btnCancelar= new JButton("Cancel");
		btnCancelar.setBounds(140, 40, 100, 50);

		btnCrear= new JButton("Agregar usuario");
		btnCrear.setBounds(150, 50, 200, 100);
		
		btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if() {
                    
                // }else{

                // }
            }
		});
		
        btnCancelar.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
		});
	}

	public String getUsername() {
        return tfUser.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
}
