/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.JPA.*;
import edusys_project.model.*;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PanelTableCourse extends javax.swing.JPanel {

//    private final CourseJpaController controller;

    /**
     * Creates new form Table
     */
    public PanelTableCourse() {
        initComponents();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
//        controller = new CourseJpaController(emf);
//
//        showTable();
    }

//    public void showTable() {
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Codigo");
//        model.addColumn("Nombre");
//        model.addColumn("Descripcion");
//        model.addColumn("Perfil Profesional");
//        model.addColumn("Mercado Laboral");
//
//        jTable.setModel(model);
//
//        try {
//            List<Careers> careersList = controller.consultList();
//            for (Careers carrer : careersList) {
//                Object[] rowData = {
//                    carrer.getCode(),
//                    carrer.getName(),
//                    carrer.getDescription(),
//                    carrer.getProfProfile(),
//                    carrer.getWorkingMarket()
//                };
//                model.addRow(rowData);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + ex.getMessage());
//            ex.printStackTrace(); // Imprime el stack trace para debugging
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jTable.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jTable.setForeground(new java.awt.Color(0, 204, 204));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombres"
            }
        ));
        jScrollPane.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
