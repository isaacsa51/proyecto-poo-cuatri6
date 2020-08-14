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

	JFrame ventanaMain;

	public void mostrarProductos() {
        try {
            String queryProductos = "SELECT * FROM productos";

            PreparedStatement execQuery = conn.prepareStatement(queryProductos);
            ResultSet resQuery = execQuery.executeQuery();

            DefaultTableModel tablaProductos = (DefaultTableModel) tblProductos.getModel();
            tablaProductos.setRowCount(0);

            while (resQuery.next()) {
                Object productos[] = { resQuery.getString("idproducto"), resQuery.getString("nombre"),resQuery.getString("cantidad"), resQuery.getFloat("precio")};

                // Poner información sacada en cada columna de la tabla
                tablaProductos.addRow(productos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void mostrarPeliculas() {
        try{
			String queryPelicula = "SELECT * FROM peliculas";

			PreparedStatement execQuery = conn.prepareStatement(queryPelicula);
			ResultSet resQuery = execQuery.executeQuery();

			DefaultTableModel tablaPeliculas = (DefaultTableModel) tblPeliculas.getModel();
			tablaPeliculas.setRowCount(0);

			while (resQuery.next()){
				Object pelicula[] = {
						resQuery.getString("idpelicula"),
						resQuery.getString("nombre"),
                                                resQuery.getString("genero"),
						resQuery.getString("precio"),
						resQuery.getInt("cantidad")
				};

				//Agregar información a tabla
				tablaPeliculas.addRow(pelicula);
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
    }

	public InicioApp() {
		initComponents();
                mostrarPeliculas();
		mostrarProductos();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblProductos);
        tblProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pelicula", "Nombre", "Genero", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeliculas.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tblPeliculas);
        tblPeliculas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel3.setText("Peliculas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel4.setText("Productos");

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
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)))
                .addGap(384, 384, 384))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 460, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 460, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 202, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 149, Short.MAX_VALUE)))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JMenu mnuCuentas;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JMenu mnuRentas;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
