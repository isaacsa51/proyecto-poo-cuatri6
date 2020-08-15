
package com.multivideo.proyecto;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Inventario extends JDialog{
	//Conexión con BD mediado con un Singleton
	Connection conn = ConexionBD.getInstance().getConnection();
	
	//Ventanas en sección Stock
	JFrame frameAggPro = new JFrame();
	JFrame frameModPro = new JFrame();
	JFrame frameElimPro = new JFrame();

	JFrame frameAggPel = new JFrame();
	JFrame frameModPel = new JFrame();
	JFrame frameElimPel = new JFrame();

	protected void ventanaAggProducto(){
		// Definir propiedades de la ventana y su tipo de layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAggPro.pack();
		frameAggPro.setSize(600,300);
		frameAggPro.setResizable(false);
		frameAggPro.setLocationRelativeTo(null);
		frameAggPro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAggPro.setVisible(true);
	
		// Titulo de la ventana
		frameAggPro.setTitle("Agregar producto");
		JPanel panelInventario = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());


		// Más propiedades
		panelInventario.setLayout(new BoxLayout(panelInventario, BoxLayout.Y_AXIS));
		JPanel panelAggPro = new JPanel();

		panelInventario.add(panelAggPro);
		panelInventario.add(panel);
		frameAggPro.add(panelInventario);

		// Insertar label a la ventana para indicar al usuario que ventana abrió
		JLabel lblTitulo = new JLabel("AGREGAR NUEVOS PRODUCTOS");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18)); 
		panelAggPro.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Poner valores iniciales en 0,0
		grid.gridx = 0;
		grid.gridy = 0;

		//Campos a agregar
		JLabel lblID  = new JLabel("ID del producto: ");
		panel.add(lblID, grid);
		grid.gridx = 1;
		grid.gridy = 0;
		JTextField tfID = new JTextField(20);
		panel.add(tfID, grid);
		grid.gridx = 0; 
		grid.gridy = 0;

		JLabel lblNombre = new JLabel("Nombre del producto: ");
		grid.gridx = 0;
		grid.gridy = 1;
		panel.add(lblNombre, grid);
		JTextField tfNombre = new JTextField(20);
		grid.gridx = 1; 
		grid.gridy = 1;
		panel.add(tfNombre, grid);

		JLabel lblCantidad = new JLabel("Cantidad a ingresar del producto: ");
		grid.gridx = 0;
		grid.gridy = 2;
		panel.add(lblCantidad, grid);
		JTextField tfCantidad = new JTextField(20);
		grid.gridx = 1; 
		grid.gridy = 2;
		panel.add(tfCantidad, grid);

		JLabel lblPrecio = new JLabel("Precio del producto: ");
		grid.gridx = 0;
		grid.gridy = 3;
		panel.add(lblPrecio, grid);
		JTextField tfPrecio = new JTextField(20);
		grid.gridx = 1; 
		grid.gridy = 3;
		panel.add(tfPrecio, grid);

		//Botones
		JButton btnAgregar = new JButton("Agregar");
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 4;
		panel.add(btnAgregar, grid);


		JButton btnCancelar = new JButton("Cancelar");
		grid.gridx = 1;
		grid.gridy = 4;
		panel.add(btnCancelar, grid);

		// Acciones de los botones
		btnAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Checar que los campos no esten vacios
				if(tfID.getText().isEmpty() || tfNombre.getText().isEmpty() || tfPrecio.getText().isEmpty() || tfCantidad.getText().isEmpty()){
					//Tirar error al estar algún campo vacio
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos pedidos", "Error al agregar el producto", JOptionPane.ERROR_MESSAGE);
					frameAggPro.setVisible(false);
					ventanaAggProducto();
				}else{
					//Obtener valores de los TextFields
					String idProducto = tfID.getText();
					String nombre = tfNombre.getText();
					float precio = Float.parseFloat(tfPrecio.getText());
					int cantidad = Integer.parseInt(tfCantidad.getText());

					//Mandar a llamar el método y pasar parametros
					aggProducto(idProducto, nombre, precio, cantidad);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameAggPro.dispose();
			}
		});
	}

	protected void ventanaModProducto(){
		// Definir propiedades de la ventana y su tipo de layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameModPro.pack();
		frameModPro.setSize(600,300);
		frameModPro.setResizable(false);
		frameModPro.setLocationRelativeTo(null);
		frameModPro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameModPro.setVisible(true);
	
		// Titulo de la ventana
		frameModPro.setTitle("Modificar producto");
		JPanel panelInventario = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		// Más propiedades
		panelInventario.setLayout(new BoxLayout(panelInventario, BoxLayout.Y_AXIS));
		JPanel panelModPro = new JPanel();

		panelInventario.add(panelModPro);
		panelInventario.add(panel);
		frameModPro.add(panelInventario);

		// Insertar label a la ventana para indicar al usuario que ventana abrió
		JLabel lblTitulo = new JLabel("MODIFICAR PRODUCTO");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18)); 
		panelModPro.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Poner valores iniciales en 0,0
		grid.gridx = 0;
		grid.gridy = 0;

		//Campos a agregar
		JLabel lblNombre  = new JLabel("Nombre del producto: ");
		panel.add(lblNombre, grid);
		grid.gridx = 1;
		grid.gridy = 0;

		JComboBox lstProductos = new JComboBox(); 
		panel.add(lstProductos, grid);
		grid.gridx = 0;
		grid.gridy = 0;

		//Obtener información de la BD
		try{
			String queryProductos = "SELECT * FROM productos";
			Statement stmt = conn.createStatement();
			ResultSet resultQuery = stmt.executeQuery(queryProductos);

			while(resultQuery.next()){
				String producto = resultQuery.getString("nombre");
				lstProductos.addItem(producto);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

		JLabel lblCantidad = new JLabel("Cantidad a ingresar del producto: ");
		grid.gridx = 0; //0
		grid.gridy = 1; //2
		panel.add(lblCantidad, grid);
		JTextField tfCantidad = new JTextField(20);
		grid.gridx = 1; //1
		grid.gridy = 1; //2
		panel.add(tfCantidad, grid);

		JLabel lblPrecio = new JLabel("Precio del producto: ");
		grid.gridx = 0; //0
		grid.gridy = 2; //3
		panel.add(lblPrecio, grid);
		JTextField tfPrecio = new JTextField(20);
		grid.gridx = 1; //1
		grid.gridy = 2; //3
		panel.add(tfPrecio, grid);

		//Botones
		JButton btnModificar = new JButton("Modificar");
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0; //0
		grid.gridy = 3; //4
		panel.add(btnModificar, grid);

		JButton btnCancelar = new JButton("Cancelar");
		grid.gridx = 1; //1
		grid.gridy = 3; //4
		panel.add(btnCancelar, grid);

		// Acciones de los botones
		btnModificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Checar si hay campos vacios
				if(tfCantidad.getText().isEmpty() || tfPrecio.getText().isEmpty()){
					//Tirar error al estar algún campo vacio
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos pedidos", "Error al modificar el producto", JOptionPane.ERROR_MESSAGE);
					frameModPro.setVisible(false);
					ventanaModProducto();
				}else{
					//Obtener valores de los TextFields
					Object producto = lstProductos.getSelectedItem();
					int cantidad = Integer.parseInt(tfCantidad.getText());
					float precio = Float.parseFloat(tfPrecio.getText());

					//Mandar a llamar el método y pasar parametros
					modProducto(producto, cantidad, precio);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameModPro.dispose();
			}
		});    
    }

	protected void ventanaElimProducto(){
		// Definir propiedades de la ventana y su tipo de layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameElimPro.pack();
		frameElimPro.setSize(400,200);
		frameElimPro.setResizable(false);
		frameElimPro.setLocationRelativeTo(null);
		frameElimPro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameElimPro.setVisible(true);
	
		// Titulo de la ventana
		frameElimPro.setTitle("Eliminar producto");
		JPanel panelInventario = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		// Más propiedades
		panelInventario.setLayout(new BoxLayout(panelInventario, BoxLayout.Y_AXIS));
		JPanel panelEliPro = new JPanel();

		panelInventario.add(panelEliPro);
		panelInventario.add(panel);
		frameElimPro.add(panelInventario);

		// Insertar label a la ventana para indicar al usuario que ventana abrió
		JLabel lblTitulo = new JLabel("ELIMINAR PRODUCTO");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18)); 
		panelEliPro.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Poner valores iniciales en 0,0
		grid.gridx = 0;
		grid.gridy = 0;

		//Campos a agregar
		JLabel lblNombre  = new JLabel("Nombre del producto: ");
		panel.add(lblNombre, grid);
		grid.gridx = 1;
		grid.gridy = 0;

		JComboBox lstProductos = new JComboBox(); 
		panel.add(lstProductos, grid);
		grid.gridx = 0;
		grid.gridy = 0;

		//Obtener información de la BD
		try{
			String queryProductos = "SELECT * FROM productos";
			Statement stmt = conn.createStatement();
			ResultSet resultQuery = stmt.executeQuery(queryProductos);

			while(resultQuery.next()){
				String producto = resultQuery.getString("nombre");
				lstProductos.addItem(producto);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

		//Botones
		JButton btnEliminar = new JButton("Eliminar");
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0; //0
		grid.gridy = 1; //4
		panel.add(btnEliminar, grid);

		JButton btnCancelar = new JButton("Cancelar");
		grid.gridx = 1; //1
		grid.gridy = 1; //4
		panel.add(btnCancelar, grid);

		// Acciones de los botones
		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Llamar el metodo
				Object producto = lstProductos.getSelectedItem();
				elimProducto(producto);
			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameElimPro.dispose();
			}
		});  
	}
	
	protected void ventanaAggPelicula(){
		// Definir propiedades de la ventana y su tipo de layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAggPel.pack();
		frameAggPel.setSize(600,300);
		frameAggPel.setResizable(false);
		frameAggPel.setLocationRelativeTo(null);
		frameAggPel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAggPel.setVisible(true);
	
		// Titulo de la ventana
		frameAggPel.setTitle("Agregar Pelicula(s)");
		JPanel panelInventario = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		// Más propiedades
		panelInventario.setLayout(new BoxLayout(panelInventario, BoxLayout.Y_AXIS));
		JPanel panelAggPel = new JPanel();

		panelInventario.add(panelAggPel);
		panelInventario.add(panel);
		frameAggPel.add(panelInventario);

		// Insertar label a la ventana para indicar al usuario que ventana abrió
		JLabel lblTitulo = new JLabel("AGREGAR NUEVAS PELICULAS");
		panelAggPel.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Poner valores iniciales en 0,0
		grid.gridx = 0;
		grid.gridy = 0;

		//Campos a agregar
		JLabel lblID  = new JLabel("ID de la pelicula: ");
		panel.add(lblID, grid);
		grid.gridx = 1;
		grid.gridy = 0;
		JTextField tfID = new JTextField(20);
		panel.add(tfID, grid);
		grid.gridx = 0; 
		grid.gridy = 0;

		JLabel lblNombre = new JLabel("Nombre de la pelicula: ");
		grid.gridx = 0;
		grid.gridy = 1;
		panel.add(lblNombre, grid);
		JTextField tfNombre = new JTextField(20);
		grid.gridx = 1; 
		grid.gridy = 1;
		panel.add(tfNombre, grid);

		JLabel lblGenero = new JLabel("Genero de la pelicula: ");
		grid.gridx = 0;
		grid.gridy = 2;
		panel.add(lblGenero, grid);
		JTextField tfGenero = new JTextField(20);
		grid.gridx = 1;
		grid.gridy = 2;
		panel.add(tfGenero, grid);

		JLabel lblCantidad = new JLabel("Cantidad a ingresar de la pelicula: ");
		grid.gridx = 0;
		grid.gridy = 3;
		panel.add(lblCantidad, grid);
		JTextField tfCantidad = new JTextField(20);
		grid.gridx = 1; 
		grid.gridy = 3;
		panel.add(tfCantidad, grid);

		JLabel lblPrecio = new JLabel("Precio del pelicula: ");
		grid.gridx = 0;
		grid.gridy = 4;
		panel.add(lblPrecio, grid);
		JTextField tfPrecio = new JTextField(20);
		grid.gridx = 1; 
		grid.gridy = 4;
		panel.add(tfPrecio, grid);

		//Botones
		JButton btnAgregar = new JButton("Agregar");
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 5;
		panel.add(btnAgregar, grid);


		JButton btnCancelar = new JButton("Cancelar");
		grid.gridx = 1;
		grid.gridy = 5;
		panel.add(btnCancelar, grid);

		// Acciones de los botones
		btnAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Checar que los campos no esten vacios
				if(tfID.getText().isEmpty() || tfNombre.getText().isEmpty() || tfGenero.getText().isEmpty() || tfPrecio.getText().isEmpty() || tfCantidad.getText().isEmpty()){
					//Tirar error al estar algún campo vacio
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos pedidos", "Error al agregar la pelicula", JOptionPane.ERROR_MESSAGE);
					frameAggPel.setVisible(false);
					ventanaAggPelicula();
				}else{
					//Obtener valores de los TextFields
					String idProducto = tfID.getText();
					String nombre = tfNombre.getText();
					String genero = tfGenero.getText();
					float precio = Float.parseFloat(tfPrecio.getText());
					int cantidad = Integer.parseInt(tfCantidad.getText());

					//Mandar a llamar el método y pasar parametros
					aggPelicula(idProducto, nombre, genero, cantidad, precio);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameAggPel.dispose();
			}
		});
	}

	protected void ventanaModPelicula(){
		// Definir propiedades de la ventana y su tipo de layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameModPel.pack();
		frameModPel.setSize(600,300);
		frameModPel.setResizable(false);
		frameModPel.setLocationRelativeTo(null);
		frameModPel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameModPel.setVisible(true);
	
		// Titulo de la ventana
		frameModPel.setTitle("Modificar pelicula");
		JPanel panelInventario = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		// Más propiedades
		panelInventario.setLayout(new BoxLayout(panelInventario, BoxLayout.Y_AXIS));
		JPanel panelModPro = new JPanel();

		panelInventario.add(panelModPro);
		panelInventario.add(panel);
		frameModPel.add(panelInventario);

		// Insertar label a la ventana para indicar al usuario que ventana abrió
		JLabel lblTitulo = new JLabel("MODIFICAR PELICULA");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18)); 
		panelModPro.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Poner valores iniciales en 0,0
		grid.gridx = 0;
		grid.gridy = 0;

		//Campos a agregar
		JLabel lblNombre  = new JLabel("Nombre de la pelicula: ");
		panel.add(lblNombre, grid);
		grid.gridx = 1;
		grid.gridy = 0;

		JComboBox lstPeliculas = new JComboBox(); 
		panel.add(lstPeliculas, grid);
		grid.gridx = 0;
		grid.gridy = 0;

		//Obtener información de la BD
		try{
			String queryPeliculas = "SELECT * FROM peliculas";
			Statement stmt = conn.createStatement();
			ResultSet resultQuery = stmt.executeQuery(queryPeliculas);

			while(resultQuery.next()){
				String pelicula = resultQuery.getString("nombre");
				lstPeliculas.addItem(pelicula);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

		JLabel lblGenero = new JLabel("Genero: ");
		grid.gridx = 0; //0
		grid.gridy = 1; //2
		panel.add(lblGenero, grid);
		JTextField tfGenero = new JTextField(20);
		grid.gridx = 1; //1
		grid.gridy = 1; //2
		panel.add(tfGenero, grid);

		JLabel lblPrecio = new JLabel("Precio del producto: ");
		grid.gridx = 0; //0
		grid.gridy = 2; //3
		panel.add(lblPrecio, grid);
		JTextField tfPrecio = new JTextField(20);
		grid.gridx = 1; //1
		grid.gridy = 2; //3
		panel.add(tfPrecio, grid);

		JLabel lblCantidad = new JLabel("Cantidad total de la pelicula: ");
		grid.gridx = 0; //0
		grid.gridy = 3; //2
		panel.add(lblCantidad, grid);
		JTextField tfCantidad = new JTextField(20);
		grid.gridx = 1; //1
		grid.gridy = 3; //2
		panel.add(tfCantidad, grid);

		//Botones
		JButton btnModificar = new JButton("Modificar");
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0; //0
		grid.gridy = 4; //4
		panel.add(btnModificar, grid);

		JButton btnCancelar = new JButton("Cancelar");
		grid.gridx = 1; //1
		grid.gridy = 4; //4
		panel.add(btnCancelar, grid);

		// Acciones de los botones
		btnModificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Checar si hay campos vacios
				if(tfGenero.getText().isEmpty() || tfCantidad.getText().isEmpty() || tfPrecio.getText().isEmpty()){
					//Tirar error al estar algún campo vacio
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos pedidos", "Error al modificar la pelicula", JOptionPane.ERROR_MESSAGE);
					frameModPel.setVisible(false);
					ventanaModPelicula();
				}else{
					//Obtener valores de los TextFields
					Object pelicula = lstPeliculas.getSelectedItem();
					String genero = tfGenero.getText();
					int cantidad = Integer.parseInt(tfCantidad.getText());
					float precio = Float.parseFloat(tfPrecio.getText());

					//Mandar a llamar el método y pasar parametros
					modPelicula(pelicula, genero, cantidad, precio);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameModPel.dispose();
			}
		});
	}

	protected void ventanaElimPelicula(){
		// Definir propiedades de la ventana y su tipo de layout
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameElimPro.pack();
		frameElimPro.setSize(400,200);
		frameElimPro.setResizable(false);
		frameElimPro.setLocationRelativeTo(null);
		frameElimPro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameElimPro.setVisible(true);
	
		// Titulo de la ventana
		frameElimPro.setTitle("Eliminar pelicula");
		JPanel panelInventario = new JPanel();
		JPanel panel = new JPanel(new GridBagLayout());

		// Más propiedades
		panelInventario.setLayout(new BoxLayout(panelInventario, BoxLayout.Y_AXIS));
		JPanel panelEliPro = new JPanel();

		panelInventario.add(panelEliPro);
		panelInventario.add(panel);
		frameElimPro.add(panelInventario);

		// Insertar label a la ventana para indicar al usuario que ventana abrió
		JLabel lblTitulo = new JLabel("ELIMINAR PELICULA");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18)); 
		panelEliPro.add(lblTitulo);

		// Constraints for the layout
		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(5, 5, 5, 5);
		grid.anchor = GridBagConstraints.WEST;

		// Poner valores iniciales en 0,0
		grid.gridx = 0;
		grid.gridy = 0;

		//Campos a agregar
		JLabel lblNombre  = new JLabel("Nombre de la pelicula: ");
		panel.add(lblNombre, grid);
		grid.gridx = 1;
		grid.gridy = 0;

		JComboBox lstPeliculas = new JComboBox(); 
		panel.add(lstPeliculas, grid);
		grid.gridx = 0;
		grid.gridy = 0;

		//Obtener información de la BD
		try{
			String queryPeliculas = "SELECT * FROM peliculas";
			Statement stmt = conn.createStatement();
			ResultSet resultQuery = stmt.executeQuery(queryPeliculas);

			while(resultQuery.next()){
				String producto = resultQuery.getString("nombre");
				lstPeliculas.addItem(producto);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

		//Botones
		JButton btnEliminar = new JButton("Eliminar");
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0; //0
		grid.gridy = 1; //4
		panel.add(btnEliminar, grid);

		JButton btnCancelar = new JButton("Cancelar");
		grid.gridx = 1; //1
		grid.gridy = 1; //4
		panel.add(btnCancelar, grid);

		// Acciones de los botones
		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Llamar el metodo
				Object pelicula = lstPeliculas.getSelectedItem();
				elimPelicula(pelicula);
			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameElimPro.dispose();
			}
		});  
	}

	private void aggProducto(String ID, String nombre, float precio, int cantidad){

		//Checar si el ID ya existe
		try{
			String queryCheckID = "SELECT * FROM productos WHERE idproducto = '" + ID + "'";
			Statement stmt = conn.createStatement();
			ResultSet resultQuery = stmt.executeQuery(queryCheckID);

			if(resultQuery.next()){
				//ID del producto ya existente
				JOptionPane.showMessageDialog(this, "El ID del producto a agregar ya existe.", "ID ya existente", JOptionPane.WARNING_MESSAGE);
			}else{
				//Agregar producto
				try {
					String aggProducto_proc = "{CALL Insertar_Productos(?, ?, ?, ?)}";

					CallableStatement cs = null;

					cs = conn.prepareCall(aggProducto_proc);
					cs.setString(1, ID);
					cs.setString(2, nombre);
					cs.setFloat(3, precio);
					cs.setInt(4, cantidad);

					//Ejecutar procedimiento
					cs.execute();

//					String qInsertarProducto = "INSERT INTO productos (idproducto, nombre, cantidad, precio)" + "VALUES (?, ?, ?, ?)";
//
//					PreparedStatement execQuery = conn.prepareStatement(qInsertarProducto);
//					execQuery.setString(1, ID);
//					execQuery.setString(2, nombre);
//					execQuery.setInt(3, cantidad);
//					execQuery.setFloat(4, precio);
//					execQuery.executeUpdate();

					//Mostrar mensaje y cerrar ventana
					JOptionPane.showMessageDialog(this, "Producto ingresado correctamente");
					frameAggPro.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Error al registrar el producto. \n" + e);
				}
			}
		}catch(Exception aggError){
			JOptionPane.showMessageDialog(this, "Error al agregar el producto. \n" + aggError);
		}
	}

	private void modProducto(Object producto, int cantidadAgg, float precio){
		String productoString = String.valueOf(producto);
		
		//Modificar el producto
		try {
			String queryModificarPro = "UPDATE productos SET cantidad = ? , " + "precio = ? " + "WHERE nombre = ?";

			PreparedStatement execQuery = conn.prepareStatement(queryModificarPro);
			execQuery.setInt(1, cantidadAgg);
			execQuery.setFloat(2, precio);
			execQuery.setString(3, productoString);

			execQuery.executeUpdate();

			//Mostrar mensaje
			JOptionPane.showMessageDialog(null, "Producto modificado con éxito!");
		} catch (SQLException errorMod) {
			JOptionPane.showMessageDialog(null, "Error al modificar el producto. \n" + errorMod, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void elimProducto(Object producto){
		String productoString = String.valueOf(producto);

		try {
			String queryElimProducto = "DELETE FROM productos WHERE nombre = ?";
			PreparedStatement execQuery = null;

			//Confirmar acción
			int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");

			if(resp == 0){
				execQuery = conn.prepareStatement(queryElimProducto);
				execQuery.setString(1, productoString); 
				execQuery.executeUpdate();

				JOptionPane.showMessageDialog(this, "Eliminado con éxito!");
			}else{
				this.dispose();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al querer eliminar el producto seleccioando. \n" + e, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void aggPelicula(String ID, String nombre, String genero, int cantidad, float precio){
		//Checar si el ID ya existe
		try{
			String queryCheckID = "SELECT * FROM peliculas WHERE idpelicula = '" + ID + "'";
			Statement stmt = conn.createStatement();
			ResultSet resultQuery = stmt.executeQuery(queryCheckID);

			if(resultQuery.next()){
				//ID del producto ya existente
				JOptionPane.showMessageDialog(this, "El ID de la pelicula a agregar ya existe.", "ID ya existente", JOptionPane.WARNING_MESSAGE);
			}else{
				//Agregar producto
				try {
					String aggProducto_proc = "{CALL Insertar_Peliculas(?, ?, ?, ?, ?)}";

					CallableStatement cs = null;

					cs = conn.prepareCall(aggProducto_proc);
					cs.setString(1, ID);
					cs.setString(2, nombre);
					cs.setString(3, genero);
					cs.setInt(4, cantidad);
					cs.setFloat(5, precio);

					//Ejecutar procedimiento
					cs.execute();

//					String queryAggPelicula = "INSERT INTO peliculas (idpelicula, nombre, genero, precio, cantidad)" + "VALUES (?, ?, ?, ?, ?)";
//
//					PreparedStatement execQuery = conn.prepareStatement(queryAggPelicula);
//					execQuery.setString(1, ID);
//					execQuery.setString(2, nombre);
//					execQuery.setString(3, genero);
//					execQuery.setFloat(4, precio);
//					execQuery.setInt(5, cantidad);
//					execQuery.executeUpdate();

					//Mostrar mensaje y cerrar ventana
					JOptionPane.showMessageDialog(this, "Pelicula agregada correctamente");
					frameAggPel.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Error al registrar el producto. \n" + e);
				}
			}
		}catch(Exception aggError){
			JOptionPane.showMessageDialog(this, "Error al agregar la pelicula. \n" + aggError);
		}
	}

	private void modPelicula(Object pelicula, String genero, int cantidad, float precio){
		String peliculaString = String.valueOf(pelicula);

		//Modificar la pelicula
		try{
			String queryModificar = "UPDATE peliculas SET genero = ?, " + "cantidad = ?" + ", precio = ?" + "WHERE nombre = ?";

			PreparedStatement execQuery = conn.prepareStatement(queryModificar);
			execQuery.setString(1, genero);
			execQuery.setInt(2, cantidad);
			execQuery.setFloat(3, precio);
			execQuery.setString(4, peliculaString);
			execQuery.executeUpdate();

			//Mostrar mensaje
			JOptionPane.showMessageDialog(null, "Producto modificado con éxito!");
		}catch(SQLException error){
			JOptionPane.showMessageDialog(null, "Error al modificar la pelicula. \n" + error, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void elimPelicula(Object pelicula){
		String peliculaString = String.valueOf(pelicula);

		try {
			String queryEliminar = "DELETE FROM peliculas WHERE nombre = ?";
			PreparedStatement execQuery = null;

			//Confirmar acción
			int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");

			if(resp == 0){
				execQuery = conn.prepareStatement(queryEliminar);
				execQuery.setString(1, peliculaString); 
				execQuery.executeUpdate();

				JOptionPane.showMessageDialog(this, "Eliminado con éxito!");
			}else{
				this.dispose();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "La pelicula no se pued eliminar debido a que al menos uno se encuentra en renta. \n" + e, "Error al eliminar", JOptionPane.ERROR_MESSAGE);
		}
	}
}