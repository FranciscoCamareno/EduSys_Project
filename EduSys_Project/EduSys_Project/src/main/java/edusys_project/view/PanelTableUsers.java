/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.JPA.UsersJpaController;
import edusys_project.model.Users;
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
public class PanelTableUsers extends javax.swing.JPanel {

    private final UsersJpaController controller;
    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form Table
     */
    public PanelTableUsers() {
        initComponents();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
        controller = new UsersJpaController(emf);

        showTable();
    }

    public void showTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre de usuario");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Correo");
        model.addColumn("Numero de Telefono");
        model.addColumn("Contraseña");

        jTable.setModel(model);

        try {
            List<Users> usersList = controller.consultList();
            for (Users user : usersList) {
                Object[] rowData = {
                    user.getIdUsers(),
                    user.getUserName(),
                    user.getName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getPassword()
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

        filterTxt = new javax.swing.JTextField();
        usersCmb = new javax.swing.JComboBox<>();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        filterTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTxtKeyReleased(evt);
            }
        });

        usersCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an option", "Column one", "Column two" }));

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
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
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
//        try {
//            if (usersCmb.getSelectedItem().equals("Column One")) {
//                sorter.setRowFilter(RowFilter.regexFilter("(!?)" + this.filterTxt.getText(), 0));
//            } else if (usersCmb.getSelectedItem().equals("Column Two")) {
//                sorter.setRowFilter(RowFilter.regexFilter("(!?)" + this.filterTxt.getText(), 1));
//            } else {
//                sorter.setRowFilter(RowFilter.regexFilter("(!?)" + this.filterTxt.getText(), 2));
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_filterTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filterTxt;
    private javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    private javax.swing.JComboBox<String> usersCmb;
    // End of variables declaration//GEN-END:variables
}
