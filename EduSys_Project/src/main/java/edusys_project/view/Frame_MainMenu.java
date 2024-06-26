/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edusys_project.view;

import edusys_project.controller.MainMenuController;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author fcama
 */
public class Frame_MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Frame_MainMenu
     */
    public Frame_MainMenu(MainMenuController controller) {
        initComponents();
        listen(controller);
    }

    public Panel_Buttons_Menu getPanel_Buttons_Menu1() {
        return panel_Buttons_Menu1;
    }
    
    public void listen(ActionListener controller){
        btn_Exit.addActionListener(controller);
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_Buttons_Menu1 = new edusys_project.view.Panel_Buttons_Menu();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit_bottom.png"))); // NOI18N
        btn_Exit.setActionCommand("ExitBtn");
        btn_Exit.setBorder(null);
        btn_Exit.setBorderPainted(false);
        btn_Exit.setContentAreaFilled(false);
        getContentPane().add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EduSys.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/navImagenRedondeado.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_Buttons_Menu1.setOpaque(false);
        getContentPane().add(panel_Buttons_Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoCelesteGrande.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private edusys_project.view.Panel_Buttons_Menu panel_Buttons_Menu1;
    // End of variables declaration//GEN-END:variables
}
