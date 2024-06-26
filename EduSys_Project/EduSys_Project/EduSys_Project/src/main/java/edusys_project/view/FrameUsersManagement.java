/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.UsersController;

/**
 *
 * @author valer
 */
public class FrameUsersManagement extends javax.swing.JFrame {

    /**
     * Creates new form FrameCoursesManagement
     */
    public FrameUsersManagement() {
        initComponents();
    }
    
    public PanelCRUD getPanelCRUD(){
        return panelCRUD;
    }
    
    public PanelUsersManagement getPanelUsersManagement(){
        return panelUsersManagement;
    }
    
    public void listen(UsersController controller){
        panelCRUD.listen(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsersManagement = new edusys_project.view.PanelUsersManagement();
        panelCRUD = new edusys_project.view.PanelCRUD();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelUsersManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -20, -1, -1));

        panelCRUD.setOpaque(false);
        getContentPane().add(panelCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 640, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoUsersManagement.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private edusys_project.view.PanelCRUD panelCRUD;
    private edusys_project.view.PanelUsersManagement panelUsersManagement;
    // End of variables declaration//GEN-END:variables
}
