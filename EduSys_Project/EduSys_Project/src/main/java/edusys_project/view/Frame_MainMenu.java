/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.MenuController;

/**
 *
 * @author fcama
 */
public class Frame_MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Frame_MainMenu
     */
    public Frame_MainMenu() {
        initComponents();
    }

    public Panel_Buttons_Menu getPanel_Buttons_Menu() {
        return panel_Buttons_Menu;
    }

    public Panel_Nav_Menu getPanel_Nav_Menu() {
        return panel_Nav_Menu;
    }
    
    public void listen(MenuController controller){
        panel_Buttons_Menu.listen(controller);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Nav_Menu = new edusys_project.view.Panel_Nav_Menu();
        panel_Buttons_Menu = new edusys_project.view.Panel_Buttons_Menu();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel_Nav_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_Buttons_Menu.setOpaque(false);
        getContentPane().add(panel_Buttons_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_base.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private edusys_project.view.Panel_Buttons_Menu panel_Buttons_Menu;
    private edusys_project.view.Panel_Nav_Menu panel_Nav_Menu;
    // End of variables declaration//GEN-END:variables
}
