package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InicioApp extends javax.swing.JFrame {
	//Conexión con BD mediado con un Singleton
	Connection conn = ConexionBD.getInstance().getConnection();

	String[] productoSeleccionado;
	int[] cantidades;

	JFrame ventanaMain;

	protected void mostrarPeliculasLista(){
		try{
			String qBuscarPeliculas = "SELECT * FROM peliculas";

			PreparedStatement execQuery = conn.prepareStatement(qBuscarPeliculas);
			ResultSet resQuery = execQuery.executeQuery();

			DefaultListModel listaPeliculas = new DefaultListModel();

			while (resQuery.next()) {
				String pelicula = resQuery.getString("nombre");

				//Agregar elemento
				listaPeliculas.addElement(pelicula);
			}

			lstPeliculas.setModel(listaPeliculas);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}

	protected void mostrarProductosLista(){
		try{
			String qBuscarProductos = "SELECT * FROM productos";

			PreparedStatement execQuery = conn.prepareStatement(qBuscarProductos);
			ResultSet resQuery = execQuery.executeQuery();

			DefaultListModel listaProductos = new DefaultListModel();

			while(resQuery.next()){
				String producto = resQuery.getString("nombre");

				//Agregar elemento
				listaProductos.addElement(producto);
			}

			lstProductos.setModel(listaProductos);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public InicioApp() {
		initComponents();
		mostrarPeliculasLista();
		mostrarProductosLista();
		sumaTotalPago();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jSeparator5 = new javax.swing.JSeparator();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		jScrollPane4 = new javax.swing.JScrollPane();
		lstProductos = new javax.swing.JList<>();
		jScrollPane5 = new javax.swing.JScrollPane();
		lstPeliculas = new javax.swing.JList<>();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		btnProducto = new javax.swing.JButton();
		btnPelicula = new javax.swing.JButton();
		jSeparator3 = new javax.swing.JSeparator();
		jScrollPane3 = new javax.swing.JScrollPane();
		txTotal = new javax.swing.JTextPane();
		jLabel6 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblTotal = new javax.swing.JTable();
		btnLimpiar = new javax.swing.JButton();
		btnCompra = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		mnuRentas = new javax.swing.JMenu();
		mnuInventario = new javax.swing.JMenu();
		mnuReportes = new javax.swing.JMenu();
		mnuCuentas = new javax.swing.JMenu();
		mnuSalir = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Menu");
		setName("MainMenu"); // NOI18N
		setResizable(false);

		jLabel1.setText("Sistema punto de venta y administración de inventario");

		jLabel2.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
		jLabel2.setText("MULTIVIDEO");

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

		lstProductos.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane4.setViewportView(lstProductos);

		lstPeliculas.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane5.setViewportView(lstPeliculas);

		jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jLabel4.setText("Productos");

		jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jLabel5.setText("Peliculas");

		btnProducto.setText("Seleccionar producto");
		btnProducto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnProductoActionPerformed(evt);
			}
		});

		btnPelicula.setText("Seleccionar pelicula");
		btnPelicula.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPeliculaActionPerformed(evt);
			}
		});

		txTotal.setEditable(false);
		txTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		txTotal.setAlignmentX(1.0F);
		txTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		txTotal.setFocusable(false);
		jScrollPane3.setViewportView(txTotal);

		jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
		jLabel6.setText("TOTAL:");

		tblTotal.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Producto", "Cantidad", "TOTAL"
				}
		) {
			Class[] types = new Class [] {
					java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
			};
			boolean[] canEdit = new boolean [] {
					false, false, false
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		tblTotal.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(tblTotal);

		btnLimpiar.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
		btnLimpiar.setText("LIMPIAR");
		btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLimpiarActionPerformed(evt);
			}
		});

		btnCompra.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		btnCompra.setText("COMPRA");
		btnCompra.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCompraActionPerformed(evt);
			}
		});

		mnuRentas.setText("Rentas");
		mnuRentas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mnuRentasMouseClicked(evt);
			}
		});
		mnuRentas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuRentasActionPerformed(evt);
			}
		});
		jMenuBar1.add(mnuRentas);

		mnuInventario.setText("Inventario");
		mnuInventario.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mnuInventarioMouseClicked(evt);
			}
		});
		mnuInventario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuInventarioActionPerformed(evt);
			}
		});
		jMenuBar1.add(mnuInventario);

		mnuReportes.setText("Reportes");
		mnuReportes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mnuReportesMouseClicked(evt);
			}
		});
		mnuReportes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuReportesActionPerformed(evt);
			}
		});
		jMenuBar1.add(mnuReportes);

		mnuCuentas.setText("Cuentas");
		mnuCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mnuCuentasMouseClicked(evt);
			}
		});
		mnuCuentas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuCuentasActionPerformed(evt);
			}
		});
		jMenuBar1.add(mnuCuentas);

		mnuSalir.setText("Salir");
		mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mnuSalirMouseClicked(evt);
			}
		});
		mnuSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnuSalirActionPerformed(evt);
			}
		});
		jMenuBar1.add(mnuSalir);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(0, 20, Short.MAX_VALUE)
								.addComponent(jLabel1)
								.addGap(145, 145, 145))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addGap(25, 25, 25)
																		.addComponent(jLabel6))
																.addGroup(layout.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnLimpiar))
												.addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator3)
												.addGroup(layout.createSequentialGroup()
														.addContainerGap()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(jScrollPane4)
																						.addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
																				.addGroup(layout.createSequentialGroup()
																						.addGap(80, 80, 80)
																						.addComponent(jLabel4)))
																		.addGap(15, 15, 15)
																		.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
																						.addComponent(btnPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																						.addComponent(jLabel5)
																						.addGap(80, 80, 80))))
																.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))))
										.addGroup(layout.createSequentialGroup()
												.addGap(198, 198, 198)
												.addComponent(jLabel2)))
								.addContainerGap(25, Short.MAX_VALUE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(0, 275, Short.MAX_VALUE)
										.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 276, Short.MAX_VALUE)))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(13, 13, 13)
								.addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel1)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(18, 18, 18)
												.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel5)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(layout.createSequentialGroup()
																.addGap(20, 20, 20)
																.addComponent(jLabel4)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(btnProducto)
														.addComponent(btnPelicula))
												.addGap(18, 18, 18))
										.addGroup(layout.createSequentialGroup()
												.addGap(38, 38, 38)
												.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(7, 7, 7)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 6, Short.MAX_VALUE))
										.addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(16, Short.MAX_VALUE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(0, 280, Short.MAX_VALUE)
										.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 280, Short.MAX_VALUE)))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
		Producto productoAcc = new Producto();

		//Seleccionar producto
		String peliculaSeleccionada = lstProductos.getSelectedValue();

		//Pedir la cantidad a desear
		try{
			String cantidadOpcion = JOptionPane.showInputDialog(null, "Cantidad a llevar: ");
			int cantidadProducto = Integer.parseInt(cantidadOpcion);

			//Mandar a llamar el método para buscar si hay disponibilidad del producto
			if (productoAcc.checarDisponibilidad(peliculaSeleccionada, cantidadProducto) == 0){
				productoAcc.mostrarCompra(peliculaSeleccionada, cantidadProducto, this);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ingrese números", "Error", JOptionPane.ERROR_MESSAGE);
		}

		sumaTotalPago();
	}//GEN-LAST:event_btnProductoActionPerformed

	private void btnPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeliculaActionPerformed
		Pelicula peliculaAcc = new Pelicula();

		//Seleccionar pelicula
		String peliculaSeleccionada = lstPeliculas.getSelectedValue();

		//Pedir la cantidad a desear
		try {
			String cantidadOpcion = JOptionPane.showInputDialog(null, "Cantidad a llevar: ");
			int cantidadPelicula = Integer.parseInt(cantidadOpcion);

			//Mandar a llamar el método para buscar si hay disponibilidad del producto
			if(peliculaAcc.checarDisponibilidad(peliculaSeleccionada, cantidadPelicula) == 0){
				peliculaAcc.mostrarCompra(peliculaSeleccionada, cantidadPelicula, this);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese números", "Error", JOptionPane.ERROR_MESSAGE);
		}

		sumaTotalPago();
	}//GEN-LAST:event_btnPeliculaActionPerformed

	private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
		// Al dar click, salir de la app;
		this.dispose();
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}//GEN-LAST:event_mnuSalirActionPerformed

	private void mnuRentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRentasActionPerformed
		// Ejecutar la ventana correspondiente
		new PeliculasRentadas().setVisible(true);
		this.setVisible(false);
		System.out.println("test");
	}//GEN-LAST:event_mnuRentasActionPerformed

	private void mnuInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInventarioActionPerformed
		// Ejecutar la ventana correspondiente
		new StockVentana().setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_mnuInventarioActionPerformed

	private void mnuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReportesActionPerformed
		// Ejecutar la ventana correspondiente
		new Reportes().setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_mnuReportesActionPerformed

	private void mnuCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCuentasActionPerformed
		// Ejecutar la ventana correspondiente
		new CuentasVentana().setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_mnuCuentasActionPerformed

	private void mnuRentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuRentasMouseClicked
		// Ejecutar la ventana correspondiente
		new PeliculasRentadas().setVisible(true);
		this.setVisible(false);
		System.out.println("test");
	}//GEN-LAST:event_mnuRentasMouseClicked

	private void mnuInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuInventarioMouseClicked
		// Ejecutar la ventana correspondiente
		new StockVentana().setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_mnuInventarioMouseClicked

	private void mnuReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuReportesMouseClicked
		// Ejecutar la ventana correspondiente
		new Reportes().setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_mnuReportesMouseClicked

	private void mnuCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCuentasMouseClicked
		// Ejecutar la ventana correspondiente
		new CuentasVentana().setVisible(true);
		this.setVisible(false);
	}//GEN-LAST:event_mnuCuentasMouseClicked

	private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
		// Al dar click, salir de la app;
		this.dispose();
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}//GEN-LAST:event_mnuSalirMouseClicked

	private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
		Compra registroCompra = new Compra();

		//Preguntar por el dinero a cambio
		String obDineroString = JOptionPane.showInputDialog(null, "Total: ");
		float obDineroTotal = Float.parseFloat(obDineroString);

		//Comprobar que el dinero dado sea mayor o equivalente al total
		float compraTotal = Float.parseFloat(txTotal.getText());
		float restaTotal = obDineroTotal - compraTotal;

		if(restaTotal >= 0){
			//System.out.println(tblTotal.getValueAt(0, 0));

			//Obtener todos los productos de la tabla
			for(int fila = 0; fila < tblTotal.getRowCount(); fila++){
				//Sacar campo y guardarlo en un array
				System.out.println(tblTotal.getValueAt(fila, 0));

//                productoSeleccionado[fila] = String.valueOf(tblTotal.getValueAt(fila, 0).toString());
//                cantidades[fila] = Integer.parseInt(tblTotal.getValueAt(fila, 1).toString());
			}

			//Llamar método y hacer continuar con la compra
			registroCompra.crearCompra(productoSeleccionado, cantidades, compraTotal, obDineroTotal);
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor al total marcado", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}//GEN-LAST:event_btnCompraActionPerformed

	private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
		//Limpiar tabla Total
		DefaultTableModel tablaTotalLimpia = (DefaultTableModel) tblTotal.getModel();
		tablaTotalLimpia.setRowCount(0);

		sumaTotalPago();
	}//GEN-LAST:event_btnLimpiarActionPerformed

	//Método para sumar total en el TextField correspondiente
	protected void sumaTotalPago(){
		float total = 0;

		for(int i = 0; i < tblTotal.getRowCount(); i++){
			total = total + Float.parseFloat(tblTotal.getValueAt(i, 2).toString());
		}

		txTotal.setText(Float.toString(total));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCompra;
	private javax.swing.JButton btnLimpiar;
	private javax.swing.JButton btnPelicula;
	private javax.swing.JButton btnProducto;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JList<String> lstPeliculas;
	private javax.swing.JList<String> lstProductos;
	private javax.swing.JMenu mnuCuentas;
	private javax.swing.JMenu mnuInventario;
	private javax.swing.JMenu mnuRentas;
	private javax.swing.JMenu mnuReportes;
	private javax.swing.JMenu mnuSalir;
	protected javax.swing.JTable tblTotal;
	private javax.swing.JTextPane txTotal;
	// End of variables declaration//GEN-END:variables
}
