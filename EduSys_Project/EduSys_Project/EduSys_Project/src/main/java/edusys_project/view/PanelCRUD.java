/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.*;

/**
 *
 * @author Usuario
 */
public class PanelCRUD extends javax.swing.JPanel {

    /**
     * Creates new form PanelCRUD
     */
    public PanelCRUD() {
        initComponents();
    }
    public void listen (UsersController controller){
        btnAdd.addActionListener(controller);
        btnConsult.addActionListener(controller);
        btnEdit.addActionListener(controller);
        btnDelete.addActionListener(controller);
        btnBack.addActionListener(controller);
    }
    
    public void listen (CareersController controller){
        btnAdd.addActionListener(controller);
        btnConsult.addActionListener(controller);
        btnEdit.addActionListener(controller);
        btnDelete.addActionListener(controller);
        btnBack.addActionListener(controller);
    }
    
//    public void listen (CoursesController controller){
//        btnAdd.addActionListener(controller);
//        btnConsult.addActionListener(controller);
//        btnEdit.addActionListener(controller);
//        btnDelete.addActionListener(controller);
//        btnBack.addActionListener(controller);
//    }
//    
//    public void listen (StudyPlansController controller){
//        btnAdd.addActionListener(controller);
//        btnConsult.addActionListener(controller);
//        btnEdit.addActionListener(controller);
//        btnDelete.addActionListener(controller);
//        btnBack.addActionListener(controller);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnConsult = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnAdd.setActionCommand("agregar");
        btnAdd.setContentAreaFilled(false);

        btnConsult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Consult.png"))); // NOI18N
        btnConsult.setActionCommand("Consultar");
        btnConsult.setContentAreaFilled(false);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnEdit.setToolTipText("");
        btnEdit.setActionCommand("Modificar");
        btnEdit.setContentAreaFilled(false);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnDelete.setToolTipText("");
        btnDelete.setActionCommand("Eliminar");
        btnDelete.setContentAreaFilled(false);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BackParaMantenimiento.png"))); // NOI18N
        btnBack.setActionCommand("Back");
        btnBack.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnConsult)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnBack))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAdd)
                .addComponent(btnConsult)
                .addComponent(btnEdit)
                .addComponent(btnDelete))
            .addComponent(btnBack)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    // End of variables declaration//GEN-END:variables
}
