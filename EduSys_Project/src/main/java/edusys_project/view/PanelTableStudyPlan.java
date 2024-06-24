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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class PanelTableStudyPlan extends javax.swing.JPanel {

    private final StudyPlanJpaController controller;
    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form Table
     */
    public PanelTableStudyPlan() {
        initComponents();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
        controller = new StudyPlanJpaController(emf);

        showTable();
    }

    public void showTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Descripcion");
        model.addColumn("Fecha de Aprobacion");
        model.addColumn("Fecha de vigencia");

        jTable.setModel(model);

        try {
            List<StudyPlan> studyPlanList = controller.consultList();
            for (StudyPlan studyPlan : studyPlanList) {
                Object[] rowData = {
                    studyPlan.getIdStudyPlan(),
                    studyPlan.getDescription(),
                    studyPlan.getApprovalDate(),
                    studyPlan.getEffectiveDate()
                };
                model.addRow(rowData);
            }
            sorter = new TableRowSorter<>(model);
            jTable.setRowSorter(sorter);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + ex.getMessage());
            ex.printStackTrace(); // Imprime el stack trace para debugging
        }
    }
    
    public void setComboFilter(String[] labels) {
        usersCmb.setModel(new DefaultComboBoxModel<>(labels));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        usersCmb = new javax.swing.JComboBox<>();
        filterTxt = new javax.swing.JTextField();

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

        filterTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(usersCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterTxt))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTxtKeyReleased
        try {
            int columnIndex = usersCmb.getSelectedIndex() - 1; // Ajustar para que coincida con el índice de las columnas
            if (columnIndex >= 0) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterTxt.getText(), columnIndex));
            } else {
                sorter.setRowFilter(null); // Sin filtro
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stack trace para debugging
        }
    }//GEN-LAST:event_filterTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filterTxt;
    private javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    private javax.swing.JComboBox<String> usersCmb;
    // End of variables declaration//GEN-END:variables
}
