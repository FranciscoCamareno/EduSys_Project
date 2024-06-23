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
public class PanelCoursesManagement extends javax.swing.JPanel {

    /**
     * Creates new form PanelCoursesManagement
     */
    public PanelCoursesManagement() {
        initComponents();
    }
    
    public String getTxtCourseName() {
        return txtCourseName.getText();
    }

    public void setTxtCourseName(JTextField txtCourseName) {
        this.txtCourseName = txtCourseName;
    }
    
    public String getTxtCredits() {
        return txtCredits.getText();
    }

    public void setTxtCredits(JTextField txtCredits) {
        this.txtCredits = txtCredits;
    }
    
    public String getTxtDescription() {
        return txtDescription.getText();
    }

    public void setTxtDescription(JTextField txtDescription) {
        this.txtDescription = txtDescription;
    }
    
    public String getTxtInDeptWorkHours() {
        return txtInDeptWorkHours.getText();
    }

    public void setTxtInDeptWorkHours(JTextField txtInDeptWorkHours) {
        this.txtInDeptWorkHours = txtInDeptWorkHours;
    }
    
    public String getTxtLessonHours() {
        return txtLessonHours.getText();
    }

    public void setTxtLessonHours(JTextField txtLessonHours) {
        this.txtLessonHours = txtLessonHours;
    }
    
    public String getTxtModality() {
        return txtModality.getText();
    }

    public void setTxtModality(JTextField txtModality) {
        this.txtModality = txtModality;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        txtCredits = new javax.swing.JTextField();
        txtModality = new javax.swing.JTextField();
        txtLessonHours = new javax.swing.JTextField();
        txtInDeptWorkHours = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Inter ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Courses Management and Maintenance");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 22, -1, -1));

        txtCourseName.setBorder(null);
        add(txtCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 132, 310, 20));

        txtCredits.setBorder(null);
        add(txtCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 202, 90, 30));

        txtModality.setBorder(null);
        txtModality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModalityActionPerformed(evt);
            }
        });
        add(txtModality, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 282, 90, 20));

        txtLessonHours.setBorder(null);
        add(txtLessonHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 90, 30));

        txtInDeptWorkHours.setBorder(null);
        add(txtInDeptWorkHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 90, 30));

        txtDescription.setBorder(null);
        add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 320, 70));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Course Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 89, -1, -1));

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Amount of credits:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 202, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Modality:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 281, -1, -1));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("In dept work hours:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 428, -1, -1));

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Description:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 502, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Lesson hours:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 355, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LargeTextSpace.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 127, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SmallTextSpace.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 274, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SmallTextSpace.png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 202, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SmallTextSpace.png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 348, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VeryLargeTextSpace.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 534, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SmallTextSpace.png"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 428, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtModalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModalityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtInDeptWorkHours;
    private javax.swing.JTextField txtLessonHours;
    private javax.swing.JTextField txtModality;
    // End of variables declaration//GEN-END:variables
}
