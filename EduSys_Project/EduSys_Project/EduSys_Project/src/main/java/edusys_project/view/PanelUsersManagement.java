/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import javax.swing.JTextField;

/**
 *
 * @author valer
 */
public class PanelUsersManagement extends javax.swing.JPanel {

    /**
     * Creates new form PanelCoursesManagement
     */
    public PanelUsersManagement() {
        initComponents();
    }

    public String getTxtEmail() {
        return txtEmail.getText();
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    public String getTxtIdUser() {
        return txtIdUser.getText();
    }

    public void setTxtIdUser(JTextField txtIdUser) {
        this.txtIdUser = txtIdUser;
    }

    public String getTxtLastName() {
        return txtLastName.getText();
    }

    public void setTxtLastName(String txtLastName) {
        this.txtLastName.setText(txtLastName);
    }

    public String getTxtName() {
        return txtName.getText();
    }

    public void setTxtName(String txtName) {
        this.txtName.setText(txtName);
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword.setText(txtPassword);
    }

    public String getTxtPhoneNumber() {
        return txtPhoneNumber.getText();
    }

    public void setTxtPhoneNumber(String txtPhoneNumber) {
        this.txtPhoneNumber.setText(txtPhoneNumber);
    }

    public String getTxtUserName() {
        return txtUserName.getText();
    }

    public void setTxtUserName(String txtUserName) {
        this.txtUserName.setText(txtUserName);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtIdUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Users Management and Maintenance");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 22, -1, 69));

        txtEmail.setBorder(null);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 330, 30));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("ID User:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtUserName.setBorder(null);
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 330, 30));

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 289, -1, -1));

        txtPhoneNumber.setBorder(null);
        add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 320, 30));

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Email:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 437, -1, -1));

        txtLastName.setBorder(null);
        txtLastName.setOpaque(true);
        add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 330, 20));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("User-Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Password:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        txtName.setBorder(null);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 330, 30));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 582, 320, 30));
        add(txtIdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 132, 100, 30));

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Last name:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 364, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 289, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 364, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 437, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SmallTextSpace.png"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 120, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, -1));

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Phone number:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 508, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 508, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
