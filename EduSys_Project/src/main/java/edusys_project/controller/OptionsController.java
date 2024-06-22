/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.view.FrameOptions;
import edusys_project.view.FrameSign_In;
import edusys_project.view.PanelBtnOptions;
import edusys_project.view.Panel_Nav;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author fcama
 */
public class OptionsController implements ActionListener {
    
    FrameOptions frameOptions;
    FrameSign_In frameSignIn;
    PanelBtnOptions panelBtnOptions;
    Panel_Nav panelNav;
    
    public OptionsController() {
        frameOptions = new FrameOptions();
        panelBtnOptions = frameOptions.getPanelBtnOptions1();
        panelNav = frameOptions.getPanel_Nav1();
        frameOptions.setLocationRelativeTo(panelNav);
        frameOptions.setVisible(true);
        panelBtnOptions.listen(this);
        panelNav.listen(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                System.out.println("login sirve");
                break;
            case "btnExit":
                JOptionPane.showMessageDialog(null, "Cerrando el Programa");
                System.exit(0);
                break;
            
        }
    }
    
    public static void main(String[] args) {
        new OptionsController();
    }
}
