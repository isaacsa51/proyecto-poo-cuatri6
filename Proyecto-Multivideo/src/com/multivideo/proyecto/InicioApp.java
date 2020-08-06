package com.multivideo.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InicioApp extends javax.swing.JFrame {

    // Instanciar clase ConexionBD
    ConexionBD bdcon = new ConexionBD();
    Connection conStatus = bdcon.connBD;

    //Instanciar clase Pelicula
    Pelicula peliculaAcc = new Pelicula();

    JFrame ventanaMain;

    // protected void mostrarPeliculasLista(){
    //     try{
    //         String qBuscarPeliculas = "SELECT * FROM peliculas";

    //         PreparedStatement execQuery = conStatus.prepareStatement(qBuscarPeliculas);
    //         ResultSet resQuery = execQuery.executeQuery();

    //         DefaultListModel listaPeliculas = new DefaultListModel();
            
    //         while (resQuery.next()) {
    //             String pelicula = resQuery.getString("nombre");

    //             //Agregar elemento
    //             listaPeliculas.addElement(pelicula);
    //         }

    //         lstPeliculas.setModel(listaPeliculas);
    //     }catch(Exception e){
    //         JOptionPane.showMessageDialog(null, e);
    //     }finally{
    //         if(bdcon != null)
    //             bdcon.desconectarBD();
    //     }
    // }

    // protected void mostrarProductosLista(){
    //     try{
    //         String qBuscarProductos = "SELECT * FROM productos";

    //         PreparedStatement execQuery = conStatus.prepareStatement(qBuscarProductos);
    //         ResultSet resQuery = execQuery.executeQuery();

    //         DefaultListModel listaProductos = new DefaultListModel();

    //         while(resQuery.next()){
    //             String producto = resQuery.getString("nombre");

    //             //Agregar elemento
    //             listaProductos.addElement(producto);
    //         }

    //         lstProductos.setModel(listaProductos);
    //     }catch(Exception e){
    //         JOptionPane.showMessageDialog(null, e);
    //     }finally{
    //         if(bdcon != null)
    //             bdcon.desconectarBD();
    //     }
    // }

    public InicioApp() {
        initComponents();
        peliculaAcc.mostrarPeliculasLista();
        peliculaAcc.mostrarProductosLista();
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

        txTotal.setEditable(false);
        jScrollPane3.setViewportView(txTotal);

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel6.setText("TOTAL:");

        tblTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio"
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
        jScrollPane1.setViewportView(tblTotal);

        btnLimpiar.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        btnLimpiar.setText("LIMPIAR");

        btnCompra.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnCompra.setText("COMPRA");

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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(98, 98, 98)
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                .addComponent(btnPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(191, 191, 191))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 270, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 270, Short.MAX_VALUE)))
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
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 279, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 280, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        //Seleccionar producto
        String productoSeleccionado = lstProductos.getSelectedValue();

        //Pedir la cantidad a desear
        String cantidadOpcion = JOptionPane.showInputDialog(null, "Cantidad deseada: "); 
        int cantidadProducto = Integer.parseInt(cantidadOpcion);
        
        //Mandar a llamar el método para buscar si hay disponibilidad del producto
        //peliculaAcc.checarDisponibilidad(productoSeleccionado, cantidadProducto); 

        JOptionPane.showMessageDialog(null, productoSeleccionado);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        // Al dar click, salir de la app;
        this.dispose();
        bdcon.desconectarBD();
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
        bdcon.desconectarBD();
        System.exit(0);
    }//GEN-LAST:event_mnuSalirMouseClicked

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
    protected javax.swing.JList<String> lstPeliculas;
    protected javax.swing.JList<String> lstProductos;
    private javax.swing.JMenu mnuCuentas;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JMenu mnuRentas;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JTable tblTotal;
    private javax.swing.JTextPane txTotal;
    // End of variables declaration//GEN-END:variables
}
