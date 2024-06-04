/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusys_project.view;

/**
 *
 * @author Usuario
 */
public class PanelBtnOptions extends javax.swing.JPanel {

    /**
     * Creates new form PanelBtnOptions
     */
    public PanelBtnOptions() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_Log-in.png"))); // NOI18N
        btnLogin.setActionCommand("login");
        btnLogin.setContentAreaFilled(false);

        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnRegister.png"))); // NOI18N
        btnRegister.setActionCommand("register");
        btnRegister.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogin)
            .addComponent(btnRegister)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addComponent(btnRegister))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    // End of variables declaration//GEN-END:variables
}