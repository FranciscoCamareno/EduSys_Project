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
    private FrameCareers frameCareers;
    private FrameStudyPlan frameStudyPlan;
    private FrameCourses frameCourses;
    private FrameUsers frameUsers; 
    private UsersTableController usersTableController;
    private CareersTableController careersTableController;
    private StudyPlanTableController studyPlanTableController;
    private CoursesTableController coursesTableController;

    public MainMenuController() {
//        frameCourses = coursesController.frameCourses;

//        frameCarrers = carrersController.frameCarrers;
//        frameStudyPlan = studyPlanController.frameStudyPlan;
        frameMainMenu = new Frame_MainMenu(this);
        frameMainMenu.setLocationRelativeTo(null);
        frameMainMenu.listen(this);

        // Inicializar frames y controladores
        usersTableController = new UsersTableController();
        frameUsers = usersTableController.getFrameUsers();

        careersTableController = new CareersTableController();
        frameCareers = careersTableController.getFrameCareers();

        studyPlanTableController = new StudyPlanTableController();
        frameStudyPlan = studyPlanTableController.getFrameStudyPlan();

        coursesTableController = new CoursesTableController();
        frameCourses = coursesTableController.getFrameCourses();
        // Obtener panel de botones y registrar ActionListeners
        panelButtonsMenu = frameMainMenu.getPanel_Buttons_Menu1();
        panelButtonsMenu.listen(this);
        frameMainMenu.setVisible(true);
    }

    public Frame_MainMenu getFrameMainMenu() {
        return frameMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AdminCursos":
                coursesTableController = new CoursesTableController();
                frameCourses.setLocationRelativeTo(null);
                frameCourses.setVisible(true);
                break;
            case "AdminCarreras":
                careersTableController = new CareersTableController();
                frameCareers.setLocationRelativeTo(null);
                frameCareers.setVisible(true);
                break;
            case "AdminPlanEstudios":
                studyPlanTableController = new StudyPlanTableController();
                frameStudyPlan.setLocationRelativeTo(null);
                frameStudyPlan.setVisible(true);
                break;
            case "AdminUsuarios":
                usersTableController = new UsersTableController();
                frameUsers.setVisible(true);
                break;
            case "ExitBtn":
                frameMainMenu.showMessage("Cerrando el programa");
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        new MainMenuController();
    }
}
