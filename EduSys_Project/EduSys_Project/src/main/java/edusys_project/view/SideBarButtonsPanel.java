/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

import edusys_project.tablesController.*;


/**
 *
 * @author valer
 */
public class SideBarButtonsPanel extends javax.swing.JPanel {

    /**
     * Creates new form SideBarButtonsPanel
     */
    public SideBarButtonsPanel() {
        initComponents();
    }

    public void listen (UsersTableController controller){
        carrersBtn.addActionListener(controller);
        coursesBtn.addActionListener(controller);
        studyPlanBtn.addActionListener(controller);
        usersBtn.addActionListener(controller);
    }
    
    public void listen (CareersTableController controller){
        carrersBtn.addActionListener(controller);
        coursesBtn.addActionListener(controller);
        studyPlanBtn.addActionListener(controller);
        usersBtn.addActionListener(controller);
    }
    
    public void listen (CoursesTableController controller){
        carrersBtn.addActionListener(controller);
        coursesBtn.addActionListener(controller);
        studyPlanBtn.addActionListener(controller);
        usersBtn.addActionListener(controller);
    }
    
    public void listen (StudyPlanTableController controller){
        carrersBtn.addActionListener(controller);
        coursesBtn.addActionListener(controller);
        studyPlanBtn.addActionListener(controller);
        usersBtn.addActionListener(controller);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carrersBtn = new javax.swing.JButton();
        coursesBtn = new javax.swing.JButton();
        studyPlanBtn = new javax.swing.JButton();
        usersBtn = new javax.swing.JButton();

        setOpaque(false);

        carrersBtn.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        carrersBtn.setForeground(new java.awt.Color(255, 255, 255));
        carrersBtn.setText("Careers");
        carrersBtn.setActionCommand("Careers");
        carrersBtn.setBorderPainted(false);
        carrersBtn.setContentAreaFilled(false);
        carrersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        coursesBtn.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        coursesBtn.setForeground(new java.awt.Color(255, 255, 255));
        coursesBtn.setText("Courses");
        coursesBtn.setBorderPainted(false);
        coursesBtn.setContentAreaFilled(false);
        coursesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        studyPlanBtn.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        studyPlanBtn.setForeground(new java.awt.Color(255, 255, 255));
        studyPlanBtn.setText("Study Plans");
        studyPlanBtn.setBorderPainted(false);
        studyPlanBtn.setContentAreaFilled(false);
        studyPlanBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        usersBtn.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        usersBtn.setForeground(new java.awt.Color(255, 255, 255));
        usersBtn.setText("Users");
        usersBtn.setBorderPainted(false);
        usersBtn.setContentAreaFilled(false);
        usersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(studyPlanBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coursesBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carrersBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usersBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carrersBtn)
                .addGap(18, 18, 18)
                .addComponent(coursesBtn)
                .addGap(18, 18, 18)
                .addComponent(studyPlanBtn)
                .addGap(18, 18, 18)
                .addComponent(usersBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carrersBtn;
    private javax.swing.JButton coursesBtn;
    private javax.swing.JButton studyPlanBtn;
    private javax.swing.JButton usersBtn;
    // End of variables declaration//GEN-END:variables
}
