/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.controller.tables.*;
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
    
    CoursesTableController coursesController;
//    FrameCourses frameCourses;
    
    CareersTableController carrersController;
//    FrameCarrers frameCarrers;
    
    StudyPlanTableController studyPlanTableController;
//    FrameStudyPlan frameStudyPlan;
    
    UsersTableController usersController;

    public MainMenuController() {
//        frameCourses = coursesController.frameCourses;
        
//        frameCarrers = carrersController.frameCarrers;
        
//        frameStudyPlan = studyPlanController.frameStudyPlan;

   
   
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
                coursesController = new CoursesTableController();
//                frameCourses.setLocationRelativeTo(null);
//                frameCourses.setVisible(true);
                frameMainMenu.setVisible(false);
                break;
            case "AdminCarreras":
                  carrersController = new CareersTableController();
//                frameCarrers.setLocationRelativeTo(null);
//                frameCarrers.setVisible(true);
                frameMainMenu.setVisible(false);
                break;
            case "AdminPlanEstudios":
                 studyPlanTableController = new StudyPlanTableController();
//                frameStudyPlan.setLocationRelativeTo(null);
//                frameStudyPlan.setVisible(true);
                frameMainMenu.setVisible(false);
                break;
            case "AdminUsuarios":
                usersController = new UsersTableController();
               
                break;
            case "Exit":
                frameMainMenu.showMessage("Cerrando el programa");
                System.exit(0);
                break;
        }
    }

}
