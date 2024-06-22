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
public class MainMenuController implements ActionListener {//aqui tienen que iniciarse todos los controladores de los botones

    Frame_MainMenu frameMainMenu;
    Panel_Buttons_Menu panelButtonsMenu;
    Panel_Nav_Menu panelNavMenu;
    
    CoursesController coursesController;
    FrameCourses frameCourses;
    
    CarrersController carrersController;
    FrameCarrers frameCarrers;

    public MainMenuController() {
        coursesController = new CoursesController();
        frameCourses = coursesController.frameCourses;
        
        carrersController = new CarrersController();
        frameCarrers = carrersController.frameCarrers;
        
        frameMainMenu = new Frame_MainMenu();
        panelButtonsMenu = frameMainMenu.getPanel_Buttons_Menu1();
        panelNavMenu = frameMainMenu.getPanel_Nav_Menu1();
        panelButtonsMenu.listen(this);
        panelNavMenu.listen(this);

    }

    public Frame_MainMenu getFrameMainMenu() {
        return frameMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AdminCursos":
                frameCourses.setVisible(true);
                break;
            case "AdminCarreras":
                frameCarrers.setVisible(true);
                break;
            case "AdminPlanEstudios":
                frameMainMenu.showMessage("AdminPlan");
                break;
            case "AdminUsuarios":
                frameMainMenu.showMessage("AdminUsuarios");
                break;
            case "Exit":
                frameMainMenu.showMessage("Cerrando el programa");
                System.exit(0);
                break;
        }
    }

}
