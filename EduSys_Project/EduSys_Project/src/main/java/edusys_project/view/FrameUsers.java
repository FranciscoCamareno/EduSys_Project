/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.tables.UsersTableController;
import java.awt.event.ActionListener;

/**
 *
 * @author valer
 */
public class FrameUsers extends javax.swing.JFrame {

    /**
     * Creates new form Table
     * @param controller
     */
    public FrameUsers(UsersTableController controller) {
        initComponents();
        listen(controller);
    }

    
    
    
    public void listen(ActionListener controller){
        editUsersBtn.addActionListener(controller);
        BackBtn.addActionListener(controller);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTableUsers1 = new edusys_project.view.PanelTableUsers();
        BackBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        editUsersBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTableUsers1.setOpaque(false);
        getContentPane().add(panelTableUsers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 830, 490));

        BackBtn.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setText("Back");
        BackBtn.setBorderPainted(false);
        BackBtn.setContentAreaFilled(false);
        BackBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Userstxt.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        editUsersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EditIcon.png"))); // NOI18N
        editUsersBtn.setActionCommand("editUsers");
        editUsersBtn.setBorderPainted(false);
        editUsersBtn.setContentAreaFilled(false);
        getContentPane().add(editUsersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoBlancoSobreTurquesa.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 880, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoGrandeTurquesa.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton editUsersBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private edusys_project.view.PanelTableUsers panelTableUsers1;
    // End of variables declaration//GEN-END:variables
}
