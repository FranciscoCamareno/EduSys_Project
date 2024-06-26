/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class PanelCareersManagementAndMaintenance extends javax.swing.JPanel {

    /**
     * Creates new form PanelStudyPlanManagementMaintenance
     */
    public PanelCareersManagementAndMaintenance() {
        initComponents();
    }

    public String getTxtIdCareers() {
        return txtIdCareers.getText();
    }

    public void setTxtIdCareers(JTextField txtIdCareers) {
        this.txtIdCareers = txtIdCareers;
    }
    
    public String getTxtName() {
        return txtName.getText();
    }

    public void setTxtName(String txtName) {
        this.txtName.setText(txtName);
    }

    public String getTxtDescription() {
        return txtDescription.getText();
    }

    public void setTxtDescription(String txtDescription) {
        this.txtDescription.setText(txtDescription);
    }

    public String getTxtProfessionalProfile() {
        return txtProfessionalProfile.getText();
    }

    public void setTxtProfessionalProfile(String txtProfessionalProfile) {
        this.txtProfessionalProfile.setText(txtProfessionalProfile);
    }

    public String getTxtWorkingMarket() {
        return txtWorkingMarket.getText();
    }

    public void setTxtWorkingMarket(String txtWorkingMarket) {
        this.txtWorkingMarket.setText(txtWorkingMarket);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        txtIdCareers = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtProfessionalProfile = new javax.swing.JTextField();
        txtWorkingMarket = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setBorder(null);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 250, 30));

        txtIdCareers.setBorder(null);
        add(txtIdCareers, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 90, 20));

        txtDescription.setBorder(null);
        add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 230, 50));

        txtProfessionalProfile.setBorder(null);
        add(txtProfessionalProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 250, 50));

        txtWorkingMarket.setBorder(null);
        add(txtWorkingMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 250, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txtGrande_1.png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 423, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TituloCarreras.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 6, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Name_.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Id careers_.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 93, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Professional profile_.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 293, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Description_.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 202, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Working market_.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 396, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txtPequeño.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 83, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TextArea.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 157, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txtGrande_1.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 223, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txtGrande_1.png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 324, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtIdCareers;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtProfessionalProfile;
    private javax.swing.JTextField txtWorkingMarket;
    // End of variables declaration//GEN-END:variables
}
