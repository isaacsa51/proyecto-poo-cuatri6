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

        jButton1.setText("Regresar al menú principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Reportes");

        tbl_reportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipo", "Nombre", "Cliente", "Cantidad", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_dia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_mes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_año, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addContainerGap(344, Short.MAX_VALUE))
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
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(75, 75, 75))
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
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mes: "));
        int año = Integer.parseInt(JOptionPane.showInputDialog(null, "Año: "));
        String fecha = String.valueOf(año) + "-" + String.valueOf(mes) + "-" + "01";
        Date newfecha = null;
        try {
            newfecha = new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo.mostrar("mes", newfecha);
    }//GEN-LAST:event_btn_mesActionPerformed

    private void btn_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diaActionPerformed
        // TODO add your handling code here:
        int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Día: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mes: "));
        int año = Integer.parseInt(JOptionPane.showInputDialog(null, "Año: "));
        String fecha = String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia);
        Date newfecha = null;
        try {
            newfecha = new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo.mostrar("dia", newfecha);
    }//GEN-LAST:event_btn_diaActionPerformed

    private void btn_añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añoActionPerformed
        // TODO add your handling code here:
        int año = Integer.parseInt(JOptionPane.showInputDialog(null, "Año: "));
        String fecha = String.valueOf(año) + "-" + "01" + "-" + "01";
        Date newfecha = null;
        try {
            newfecha = new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo.mostrar("año", newfecha);
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
