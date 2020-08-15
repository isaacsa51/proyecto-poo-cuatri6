package com.multivideo.proyecto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Reportes extends javax.swing.JFrame {

    ReportesMod modelo = new ReportesMod(this);

    public Reportes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_reportes = new javax.swing.JTable();
        btn_dia = new javax.swing.JButton();
        btn_mes = new javax.swing.JButton();
        btn_año = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Regresar al menú principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Reportes");

        tbl_reportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Compra", "ID Renta", "Pelicula", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_reportes);

        btn_dia.setText("Día");
        btn_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_diaActionPerformed(evt);
            }
        });

        btn_mes.setText("Mes");
        btn_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mesActionPerformed(evt);
            }
        });

        btn_año.setText("Año");
        btn_año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_dia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_mes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_año, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(303, 303, 303))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btn_dia)
                        .addGap(18, 18, 18)
                        .addComponent(btn_mes)
                        .addGap(18, 18, 18)
                        .addComponent(btn_año))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new InicioApp().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mesActionPerformed
        // TODO add your handling code here:
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número del mes que quiere ver: "));
        int año = Integer.parseInt(JOptionPane.showInputDialog(null, "Año: "));
        String fecha = String.valueOf(año) + "-" + String.valueOf(mes) + "-" + "01";

        modelo.mostrar("mes", fecha);
    }//GEN-LAST:event_btn_mesActionPerformed

    private void btn_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diaActionPerformed
        // TODO add your handling code here:
        int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Día: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Número del mes: "));
        int año = Integer.parseInt(JOptionPane.showInputDialog(null, "Año: "));
        String fecha = String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia);

        modelo.mostrar("dia", fecha);
    }//GEN-LAST:event_btn_diaActionPerformed

    private void btn_añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añoActionPerformed
        // TODO add your handling code here:
        String año = JOptionPane.showInputDialog(null, "Año: ");
        String fecha = año;

        modelo.mostrar("año", fecha);
    }//GEN-LAST:event_btn_añoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_año;
    private javax.swing.JButton btn_dia;
    private javax.swing.JButton btn_mes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tbl_reportes;
    // End of variables declaration//GEN-END:variables
}
