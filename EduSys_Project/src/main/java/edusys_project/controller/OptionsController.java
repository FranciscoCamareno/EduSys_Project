/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author fcama
 */
public class OptionsController implements ActionListener {

    SignInController signInController;
    FrameSign_In frameSignIn;//gui

    FrameOptions frameOptions;
    PanelBtnOptions panelBtnOptions;
    Panel_Nav panelNav;

    public OptionsController() {
        frameOptions = new FrameOptions();
        panelBtnOptions = frameOptions.getPanelBtnOptions1();
        panelNav = frameOptions.getPanel_Nav1();
        frameOptions.setLocationRelativeTo(null);
        frameOptions.setVisible(true);
        panelBtnOptions.listen(this);
        panelNav.listen(this);

        signInController = new SignInController();
        frameSignIn = signInController.getFrameSignIn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                System.out.println("login sirve");
                frameSignIn.setLocationRelativeTo(null);
                frameSignIn.setVisible(true);
                frameOptions.dispose();
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
