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

    private final CourseJpaController controller;

    /**
     * Creates new form Table
     */
    public PanelTableCourse() {
        initComponents();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
        controller = new CourseJpaController(emf);

        showTable();
    }

    public void showTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Creditos Totales");
        model.addColumn("Modalidad");
        model.addColumn("Horas de lesiones");
        model.addColumn("Horas Trabajo en casa");
        model.addColumn("Descripcion");

        jTable.setModel(model);

        try {
            List<Course> coursesList = controller.consultList();
            for (Course course : coursesList) {
                Object[] rowData = {
                    course.getName(),
                    course.getAmountCredits(),
                    course.getModality(),
                    course.getLessonHours(),
                    course.getIndepWorkHour(),
                    course.getDescription()
                };
                model.addRow(rowData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + ex.getMessage());
            ex.printStackTrace(); // Imprime el stack trace para debugging
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        usersCmb = new javax.swing.JComboBox<>();
        filterTxt = new javax.swing.JTextField();
        carrersFilterCmb = new javax.swing.JComboBox<>();

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

        usersCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an option", "Column one", "Column two" }));

        carrersFilterCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a carrer" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(carrersFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usersCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 115, Short.MAX_VALUE))
            .addComponent(jScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterTxt)
                    .addComponent(carrersFilterCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> carrersFilterCmb;
    private javax.swing.JTextField filterTxt;
    private javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    private javax.swing.JComboBox<String> usersCmb;
    // End of variables declaration//GEN-END:variables
}
