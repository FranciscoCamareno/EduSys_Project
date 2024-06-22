/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author valer
 */
public class SignInController implements ActionListener {

    FrameSign_In frameSignIn;
    PanelTxtSignIn panelTxtSignIn;
    PanelBtnSingIn panelBtnSignIn;//SignIn esta mal escrito, corregir despues que se despi el frame
    Panel_Nav panelNav;
    
    MainMenuController mainMenuController;
    Frame_MainMenu frameMainMenu;

    public SignInController() {
        frameSignIn = new FrameSign_In();
        panelTxtSignIn = frameSignIn.getPanelTxtSingIn1();
        panelBtnSignIn = frameSignIn.getPanelBtnSingIn1();
        panelNav = frameSignIn.getPanel_Nav1();
        panelBtnSignIn.listen(this);
        panelNav.listen(this);

        mainMenuController = new MainMenuController();
        frameMainMenu = mainMenuController.getFrameMainMenu();
    }

    public FrameSign_In getFrameSignIn() {
        return frameSignIn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnExit":
                frameSignIn.showMessage("Cerrando el programa");
                System.exit(0);
                break;
            case "login":

                String username = panelTxtSignIn.getJtUsername();
                String password = panelTxtSignIn.getJtPassword();

                if (!"admin".equals(username)) {
                    frameSignIn.showMessage("Usuario no autorizado para realizar esta acción");
                } else if (!"123".equals(password)) {
                    frameSignIn.showMessage("Contraseña incorrecta");
                } else {
                    frameSignIn.showMessage("Acceso concedido");
                        frameMainMenu.setVisible(true);
                }

                break;
            case "back":
                System.out.println("f");
                break;
        }
    }

}
