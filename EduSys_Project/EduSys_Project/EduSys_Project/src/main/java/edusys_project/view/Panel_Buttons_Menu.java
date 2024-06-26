/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.MenuController;

/**
 *
 * @author fcama
 */
public class Panel_Buttons_Menu extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Buttons_Menu
     */
    public Panel_Buttons_Menu() {
        initComponents();
    }

    public void listen (MenuController controller){
        btn_Admin_Career.addActionListener(controller);
        btn_Admin_Course.addActionListener(controller);
        btn_Admin_StudyPlan.addActionListener(controller);
        btn_Admin_Users.addActionListener(controller);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Admin_Course = new javax.swing.JButton();
        btn_Admin_Career = new javax.swing.JButton();
        btn_Admin_StudyPlan = new javax.swing.JButton();
        btn_Admin_Users = new javax.swing.JButton();

        btn_Admin_Course.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_admin_cursos.png"))); // NOI18N
        btn_Admin_Course.setActionCommand("CourseAdmin");
        btn_Admin_Course.setContentAreaFilled(false);

        btn_Admin_Career.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_admin_carreras.png"))); // NOI18N
        btn_Admin_Career.setActionCommand("CareersAdmin");
        btn_Admin_Career.setContentAreaFilled(false);

        btn_Admin_StudyPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_admin_planestudios.png"))); // NOI18N
        btn_Admin_StudyPlan.setActionCommand("StudyPlanAdmin");
        btn_Admin_StudyPlan.setContentAreaFilled(false);

        btn_Admin_Users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_admin_usuarios.png"))); // NOI18N
        btn_Admin_Users.setActionCommand("UserAdmin");
        btn_Admin_Users.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Admin_Course)
                    .addComponent(btn_Admin_Career)
                    .addComponent(btn_Admin_StudyPlan)
                    .addComponent(btn_Admin_Users)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Admin_Course)
                .addGap(49, 49, 49)
                .addComponent(btn_Admin_Career)
                .addGap(51, 51, 51)
                .addComponent(btn_Admin_StudyPlan)
                .addGap(51, 51, 51)
                .addComponent(btn_Admin_Users)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Admin_Career;
    private javax.swing.JButton btn_Admin_Course;
    private javax.swing.JButton btn_Admin_StudyPlan;
    private javax.swing.JButton btn_Admin_Users;
    // End of variables declaration//GEN-END:variables
}
