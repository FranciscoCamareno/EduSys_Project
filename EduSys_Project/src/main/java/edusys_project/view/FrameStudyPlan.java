/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.tables.StudyPlanTableController;
import java.awt.event.ActionListener;

/**
 *
 * @author valer
 */
public class FrameStudyPlan extends javax.swing.JFrame {

    /**
     * Creates new form FrameStudyPlan
     */
    public FrameStudyPlan(StudyPlanTableController controller) {
        initComponents();
        listen(controller);
    }

    public SideBarButtonsPanel getPanelSBB() {
        return sideBarButtonsPanel1;
    }
    
    public void listen(ActionListener controller){
        editStudyPlanBtn.addActionListener(controller);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBarButtonsPanel1 = new edusys_project.view.SideBarButtonsPanel();
        panelTableStudyPlan1 = new edusys_project.view.PanelTableStudyPlan();
        descriptionLabel = new javax.swing.JLabel();
        effectiveDateLabel = new javax.swing.JLabel();
        approvalDateLabel = new javax.swing.JLabel();
        creditsLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        downloadBtn = new javax.swing.JButton();
        editStudyPlanBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(sideBarButtonsPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 100, -1, -1));

        panelTableStudyPlan1.setOpaque(false);
        getContentPane().add(panelTableStudyPlan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 670, 530));
        getContentPane().add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 570, 180));
        getContentPane().add(effectiveDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 100, 20));
        getContentPane().add(approvalDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 100, 20));
        getContentPane().add(creditsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 100, 20));

        jLabel4.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel4.setText("Description");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel5.setText("Effective date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel6.setText("Approval date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel7.setText("Credits");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel8.setText("Course's name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        downloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/downloadBtn.png"))); // NOI18N
        downloadBtn.setBorderPainted(false);
        downloadBtn.setContentAreaFilled(false);
        getContentPane().add(downloadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, -1, -1));

        editStudyPlanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EditIcon.png"))); // NOI18N
        editStudyPlanBtn.setActionCommand("editStudyPlanBtn");
        editStudyPlanBtn.setBorderPainted(false);
        editStudyPlanBtn.setContentAreaFilled(false);
        getContentPane().add(editStudyPlanBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/STUDY PLANStxt.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoBlancoSobreTurquesa.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoGrandeTurquesa.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel approvalDateLabel;
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JButton editStudyPlanBtn;
    private javax.swing.JLabel effectiveDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private edusys_project.view.PanelTableStudyPlan panelTableStudyPlan1;
    private edusys_project.view.SideBarButtonsPanel sideBarButtonsPanel1;
    // End of variables declaration//GEN-END:variables
}
