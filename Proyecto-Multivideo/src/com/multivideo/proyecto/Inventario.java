
package com.multivideo.proyecto;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Inventario extends JDialog{
	// Instanciar BD
	ConexionBD bdcon = new ConexionBD();
	Connection conStatus = bdcon.connBD;
	
	//Ventanas
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
		frameAggPro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameAggPro.dispose();
			}
		});
	}

	protected void ventanaModProducto(){
		
		Container c; 
		JLabel tituloVentana; 
		JLabel lblProducto; 
		JTextField tfPrecio;
		JLabel lblCantidad; 
		JTextField tfCantidad; 
		JLabel lblPrecio; 
		JComboBox lstProductos; 
		JButton btnModificar; 
		JButton btnLimpiar;
		JButton btnSalir;

		String years[] = { "1995", "1996", "1997", "1998", 
							"1999", "2000", "2001", "2002", 
							"2003", "2004", "2005", "2006", 
							"2007", "2008", "2009", "2010", 
							"2011", "2012", "2013", "2014", 
							"2015", "2016", "2017", "2018", 
							"2019" }; 
			
			
		setTitle("Modificar Producto(s)");
		setBounds(300, 90, 600, 400); 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		//Titulo ventana
		tituloVentana = new JLabel("Modificar Producto"); 
		tituloVentana.setFont(new Font("Arial", Font.BOLD, 18)); 
		tituloVentana.setSize(300, 30); 
		tituloVentana.setLocation(225, 30); 
		c.add(tituloVentana); 

		//Lista para los productos
		lblProducto = new JLabel("Producto: "); 
		lblProducto.setFont(new Font("Arial", Font.PLAIN, 14)); 
		lblProducto.setSize(100, 20); 
		lblProducto.setLocation(100, 100); 
		c.add(lblProducto);  

		lstProductos = new JComboBox(years); 
		lstProductos.setFont(new Font("Arial", Font.PLAIN, 14)); 
		lstProductos.setSize(300, 25); 
		lstProductos.setLocation(200, 100); 
		c.add(lstProductos);

		//Text Field para cantidad
		lblCantidad = new JLabel("Cantidad: "); 
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14)); 
		lblCantidad.setSize(190, 20); 
		lblCantidad.setLocation(100, 140); 
		c.add(lblCantidad); 

		tfCantidad = new JTextField(); 
		tfCantidad.setFont(new Font("Arial", Font.PLAIN, 14)); 
		tfCantidad.setSize(300, 25); 
		tfCantidad.setLocation(200, 140); 
		c.add(tfCantidad);  

		//TextField para precio
		lblPrecio = new JLabel("Precio: "); 
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 14)); 
		lblPrecio.setSize(190, 20); 
		lblPrecio.setLocation(100, 180); 
		c.add(lblPrecio); 

		tfPrecio = new JTextField(); 
		tfPrecio.setFont(new Font("Arial", Font.PLAIN, 14)); 
		tfPrecio.setSize(300, 25); 
		tfPrecio.setLocation(200, 180); 
		c.add(tfPrecio);  

		//Botones
		btnModificar = new JButton("Modificar"); 
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 15)); 
		btnModificar.setSize(200, 25); 
		btnModificar.setLocation(100, 220); 
		c.add(btnModificar); 

		btnLimpiar = new JButton("Limpiar"); 
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15)); 
		btnLimpiar.setSize(200, 25); 
		btnLimpiar.setLocation(301, 220); 
		c.add(btnLimpiar);

		btnSalir = new JButton("Regresar la menú principal");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15)); 
		btnSalir.setSize(400, 25); 
		btnSalir.setLocation(100, 260); 
		c.add(btnSalir);

		setVisible(true);        
    }

	protected void ventanaElimProducto(){
		
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
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Cerrar ventana
				frameAggPel.dispose();
			}
		});
	}

	protected void ventanaModPelicula(){

	}

	protected void ventanaElimPelicula(){
		
	}

}
