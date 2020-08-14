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

        jLabel1.setText("Administración del inventario");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(104, 104, 104)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(80, 80, 80))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 284, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 285, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 241, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 185, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JList<String> lstPeliculas;
    private javax.swing.JList<String> lstProductos;
    private javax.swing.JMenu mnuCuentas;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JMenu mnuRentas;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenu mnuSalir;
    // End of variables declaration//GEN-END:variables
}
