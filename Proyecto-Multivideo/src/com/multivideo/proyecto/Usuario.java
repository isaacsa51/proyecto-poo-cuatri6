package com.multivideo.proyecto;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.*;

public class Usuario extends JDialog{
	ConexionBD bdcon = new ConexionBD();
	Connection conStatus = bdcon.connBD;

	//Ventanas
	JFrame frameAgg = new JFrame();
	JFrame frameEliminar = new JFrame();

	protected void ventanaRegistro(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAgg.pack();
		frameAgg.setSize(500, 300);
		frameAgg.setResizable(false);
		frameAgg.setLocationRelativeTo(null);
		frameAgg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAgg.setVisible(true);

		frameAgg.setTitle("Registro de usuario");
		JPanel panelRegistro = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		panelRegistro.setLayout(new BoxLayout(panelRegistro, BoxLayout.Y_AXIS));
		JPanel panelAgg = new JPanel();

		panelRegistro.add(panelAgg);
		panelRegistro.add(panel);
		frameAgg.add(panelRegistro);

		JLabel lblTitulo = new JLabel("REGISTRO DE UN NUEVO USUARIO");
		panelAgg.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Setting initial grid values to 0,0
		grid.gridx=0;
		grid.gridy=0;

		JLabel lblUsuario  = new JLabel("Usuario :");
		panel.add(lblUsuario, grid);
		grid.gridx=1;
		JTextField tfUsuario = new JTextField(20);
		panel.add(tfUsuario, grid);
		grid.gridx=0; grid.gridy=1;


		JLabel lblPassword = new JLabel("Contrasena:");
		panel.add(lblPassword, grid);
		grid.gridx=1;

		JPasswordField pfPassword = new JPasswordField(20);
		panel.add(pfPassword, grid);
		grid.gridx=0; grid.gridy=2;
		
		grid.gridwidth = 4;
		grid.anchor = GridBagConstraints.CENTER;

		//Botones
		JButton btnRegistrar = new JButton("Registrar");
		JButton btnCancelar = new JButton("Cancelar");
		
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 3;
		panel.add(btnRegistrar, grid);

		grid.gridx = 2;
		grid.gridy = 3;
		panel.add(btnCancelar, grid);

		//Ejecutar al presionar el botón
		btnRegistrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Validar si los campos no esten vacios
				if(tfUsuario.getText() != ""){
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos pedidos", "Error", JOptionPane.WARNING_MESSAGE);
					frameAgg.setVisible(false);
					ventanaRegistro();
				}else{
					//Guardar datos en la base de datos
					agregarUsuario(tfUsuario.getText(), pfPassword.getPassword());
				}
			}
		});

		//Salir al dar click en el botón Cancelar
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameAgg.dispose();
			}
		});
	}

	protected void ventanaEliminacion(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameEliminar.pack();
		frameEliminar.setSize(500, 300);
		frameEliminar.setResizable(false);
		frameEliminar.setLocationRelativeTo(null);
		frameEliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEliminar.setVisible(true);

		frameEliminar.setTitle("Eliminar un usuario");
		JPanel panelEliminacion = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		panelEliminacion.setLayout(new BoxLayout(panelEliminacion, BoxLayout.Y_AXIS));
		JPanel panelElim = new JPanel();

		panelEliminacion.add(panelElim);
		panelEliminacion.add(panel);
		frameEliminar.add(panelEliminacion);

		JLabel lblTitulo = new JLabel("ELIMINACIÓN DE UN USUARIO");
		panelElim.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Setting initial grid values to 0,0
		grid.gridx=0;
		grid.gridy=0;

		JLabel lblIdUsuario  = new JLabel("ID: ");
		panel.add(lblIdUsuario, grid);
		grid.gridx=1;
		JTextField tfID = new JTextField(20);
		panel.add(tfID, grid);
		grid.gridx=0; grid.gridy=1;
		
		grid.gridwidth = 4;
		grid.anchor = GridBagConstraints.CENTER;

		//Botones
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnCancelar = new JButton("Cancelar");
		
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 3;
		panel.add(btnEliminar, grid);

		grid.gridx = 2;
		grid.gridy = 3;
		panel.add(btnCancelar, grid);

		//Ejecutar al presionar el botón
		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Validar si los campos no esten vacios
				//...

				//Hacer un parse de String a Int para poder pasar el parametro
				int ID = Integer.parseInt(tfID.getText());

				//Eliminar usuario
				eliminarUsuario(ID);
			}
		});

		//Salir al dar click en el botón Cancelar
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameEliminar.dispose();
			}
		});
	}

	private void agregarUsuario(String usuario, char[] password){
		//De los dos parametros obtenidos de la ventana de registro, hacer el query para insertarlo dentro de la BD

		String passConvertido = new String(password);

		try{			
			String qInsertarUsuario = "INSERT INTO usuarios (idusuario, usuario, password)" + "VALUES (?, ?, ?)";
            
			PreparedStatement execQuery = conStatus.prepareStatement(qInsertarUsuario);
			execQuery.setString(1, null);
			execQuery.setString(2, usuario);
			execQuery.setString(3, passConvertido);
			execQuery.executeUpdate();
			
			//Mostrar que se completo la tarea y cerrar ventana
			JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
			frameAgg.dispose();

			//Actualizar tabla de la ventana Cuentas
			// ...
        }catch(Exception aggError){
			JOptionPane.showMessageDialog(this, "Error al registrar al usuario. \n" + aggError);
        }
	}

	private void eliminarUsuario(int ID){
		try{
			String qEliminar = "DELETE FROM usuarios WHERE idusuario = ?";
			PreparedStatement execQuery = null;

			int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");

			if(resp == 0){
				execQuery = conStatus.prepareStatement(qEliminar);
				execQuery.setInt(1, ID); 
				execQuery.executeUpdate();

				JOptionPane.showMessageDialog(this, "Eliminado con éxito!");
			}else{

			}

			frameEliminar.dispose();

			//Actualizar tabla de la ventana Cuentas
			// ...
		}catch(Exception elimError){
			JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.\n" + elimError, "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
