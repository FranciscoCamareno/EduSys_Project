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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PanelTableUsers extends javax.swing.JPanel {

    private final UsersJpaController controller;

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
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Nombre de usuario");
        model.addColumn("Correo");
        model.addColumn("Numero de Telefono");
        model.addColumn("Contraseña");
        
        jTable.setModel(model);

        try {
            List<Users> usersList = controller.consultList();
            for (Users user : usersList) {
                Object[] rowData = {
                    user.getIdUsers(),
                    user.getName(),
                    user.getLastName(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getPassword()
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

        jTable.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jTable.setForeground(new java.awt.Color(0, 204, 204));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Usuario", "Correo", "Numero"
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
