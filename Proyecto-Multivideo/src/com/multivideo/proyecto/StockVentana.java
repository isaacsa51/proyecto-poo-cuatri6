package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StockVentana extends javax.swing.JFrame {
    //Conexión con BD mediado con un Singleton
    Connection conn = ConexionBD.getInstance().getConnection();

    // Instanciar clase Inventario
    Inventario invAcciones = new Inventario();

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
        try {
            String queryPeliculas = "SELECT * FROM peliculas";

            PreparedStatement execQuery = conn.prepareStatement(queryPeliculas);
            ResultSet resQuery = execQuery.executeQuery();

            DefaultTableModel tablaPeliculas = (DefaultTableModel) tblPeliculas.getModel();
            tablaPeliculas.setRowCount(0);

            while (resQuery.next()) {
                Object peliculas[] = { resQuery.getString("idpelicula"), resQuery.getString("nombre"),resQuery.getString("genero"), resQuery.getFloat("precio"), resQuery.getInt("stock")};

                // Poner información sacada en cada columna de la tabla
                tablaPeliculas.addRow(peliculas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    //Mostrar productos y peliculas dentro de sus tablas al ejecutar la ventana
    public StockVentana() {
        initComponents();
        mostrarProductos();
        mostrarPeliculas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnEliProductos = new javax.swing.JButton();
        btnAggProductos = new javax.swing.JButton();
        btnModProductos = new javax.swing.JButton();
        btnAggPeliculas = new javax.swing.JButton();
        btnModPeliculas = new javax.swing.JButton();
        btnEliPeliculas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel1.setText("Productos");

        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Genero", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(tblPeliculas);
        tblPeliculas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
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
        tblProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblProductos);
        tblProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel2.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        jLabel2.setText("Peliculas");

        btnEliProductos.setText("Eliminar");
        btnEliProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliProductosActionPerformed(evt);
            }
        });

        btnAggProductos.setText("Agregar");
        btnAggProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggProductosActionPerformed(evt);
            }
        });

        btnModProductos.setText("Modificar");
        btnModProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProductosActionPerformed(evt);
            }
        });

        btnAggPeliculas.setText("Agregar");
        btnAggPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggPeliculasActionPerformed(evt);
            }
        });

        btnModPeliculas.setText("Modificar");
        btnModPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModPeliculasActionPerformed(evt);
            }
        });

        btnEliPeliculas.setText("Eliminar");
        btnEliPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliPeliculasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Stock/Conteo de productos");

        btnRegresar.setText("Regresar al menú principal");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegresar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAggProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnModProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliProductos)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAggPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnModPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEliPeliculas))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAggProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModProductos)
                    .addComponent(btnEliProductos)
                    .addComponent(btnAggPeliculas)
                    .addComponent(btnModPeliculas)
                    .addComponent(btnEliPeliculas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAggPeliculas, btnAggProductos, btnEliPeliculas, btnEliProductos, btnModPeliculas, btnModProductos});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //Regresar
        new InicioApp().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAggProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggProductosActionPerformed
        //Mostrar ventana de agregar
        invAcciones.ventanaAggProducto();
    }//GEN-LAST:event_btnAggProductosActionPerformed

    private void btnModProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProductosActionPerformed
        //Mostrar ventana de modificar
        invAcciones.ventanaModProducto();
    }//GEN-LAST:event_btnModProductosActionPerformed

    private void btnEliProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliProductosActionPerformed
        //Mostrar ventana de eliminar
        invAcciones.ventanaElimProducto();
    }//GEN-LAST:event_btnEliProductosActionPerformed

    private void btnAggPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggPeliculasActionPerformed
        //Mostrar ventana de agregar
        invAcciones.ventanaAggPelicula();
    }//GEN-LAST:event_btnAggPeliculasActionPerformed

    private void btnModPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModPeliculasActionPerformed
        //Mostrar ventana de modificar
        invAcciones.ventanaModPelicula();
    }//GEN-LAST:event_btnModPeliculasActionPerformed

    private void btnEliPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliPeliculasActionPerformed
        //Mostrar ventana de eliminar
        invAcciones.ventanaElimPelicula();
    }//GEN-LAST:event_btnEliPeliculasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggPeliculas;
    private javax.swing.JButton btnAggProductos;
    private javax.swing.JButton btnEliPeliculas;
    private javax.swing.JButton btnEliProductos;
    private javax.swing.JButton btnModPeliculas;
    private javax.swing.JButton btnModProductos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
