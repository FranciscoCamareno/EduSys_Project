/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edusys_project.view;

import edusys_project.tablesController.*;
import java.awt.event.ActionListener;

/**
 *
 * @author valer
 */
public class FrameCourses extends javax.swing.JFrame {

    /**
     * Creates new form FrameCourses
     * @param controller
     */
    public FrameCourses(CoursesTableController controller) {
        initComponents();
        listen(controller);
    }

    
    public SideBarButtonsPanel getPanelSBB() {
        return sideBarButtonsPanel1;
    }
    
    public void listen(ActionListener controller){
        editCoursesBtn.addActionListener(controller);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTableCourse1 = new edusys_project.view.PanelTableCourse();
        jLabel3 = new javax.swing.JLabel();
        modalityLabel = new javax.swing.JLabel();
        lessonHoursLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        inDeptHoursLabel = new javax.swing.JLabel();
        creditsLabel = new javax.swing.JLabel();
        sideBarButtonsPanel1 = new edusys_project.view.SideBarButtonsPanel();
        nameLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        editCoursesBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTableCourse1.setOpaque(false);
        getContentPane().add(panelTableCourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 650, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/COURSEStxt.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));
        getContentPane().add(modalityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 90, 20));
        getContentPane().add(lessonHoursLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 90, 20));
        getContentPane().add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 570, 90, 20));
        getContentPane().add(inDeptHoursLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 80, 20));

        creditsLabel.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        getContentPane().add(creditsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 90, 20));
        getContentPane().add(sideBarButtonsPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 100, -1, -1));

        nameLabel.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        nameLabel.setText("Course's Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel4.setText("Amount of credits");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel6.setText("Lesson Hours");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel7.setText("In dept work hours");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 470, -1, 20));

        jLabel5.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel5.setText("Modality");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        jLabel8.setText("Description");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, -1, -1));

        editCoursesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EditIcon.png"))); // NOI18N
        editCoursesBtn.setActionCommand("editCourses");
        editCoursesBtn.setBorderPainted(false);
        editCoursesBtn.setContentAreaFilled(false);
        getContentPane().add(editCoursesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoBlancoSobreTurquesa.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoGrandeTurquesa.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton editCoursesBtn;
    private javax.swing.JLabel inDeptHoursLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lessonHoursLabel;
    private javax.swing.JLabel modalityLabel;
    private javax.swing.JLabel nameLabel;
    private edusys_project.view.PanelTableCourse panelTableCourse1;
    private edusys_project.view.SideBarButtonsPanel sideBarButtonsPanel1;
    // End of variables declaration//GEN-END:variables
}
