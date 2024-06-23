/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.controller.JPA.*;
import edusys_project.tablesController.*;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveba
 */
public class MenuController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    private Frame_MainMenu frame_MainMenu;
//    private Panel_Buttons_Menu buttons_Menu;
//    private Panel_Nav panelNav;
//    private FrameUsers frameUsers;
//    private FrameCareers frameCareers;
//    private FrameStudyPlan frameStudyPlan;
//    private FrameCourses frameCourses;
//    private UsersTableController usersTableController;
//    private CareersTableController careersTableController;
//    private StudyPlanTableController studyPlanTableController;
//    private CoursesTableController coursesTableController;
//    
//
//    public MenuController() {
//        frame_MainMenu = new Frame_MainMenu();
//        frame_MainMenu.setLocationRelativeTo(null);
//
//        // Inicializar frames y controladores
//        usersTableController = new UsersTableController();
//        frameUsers = usersTableController.getFrameUsers();
//        
//        careersTableController = new CareersTableController();
//        frameCareers = careersTableController.getFrameCareers();
//        
//        studyPlanTableController = new StudyPlanTableController();
//        frameStudyPlan = studyPlanTableController.getFrameStudyPlan();
//        
//        coursesTableController = new CoursesTableController();
//        frameCourses = coursesTableController.getFrameCourses();
//
//        // Obtener panel de botones y registrar ActionListeners
//        buttons_Menu = frame_MainMenu.getPanel_Buttons_Menu();
//        buttons_Menu.listen(this);
//        frame_MainMenu.setVisible(true);
//    }
//    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("CourseAdmin")) {
//            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
//            frameCourses.setVisible(true);
//        }
//        if (e.getActionCommand().equals("CareersAdmin")) {
//            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
//            frameCareers.setVisible(true);
//        }
//        if (e.getActionCommand().equals("StudyPlanAdmin")) {
//            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
//            frameStudyPlan.setVisible(true);
//        }
//        if (e.getActionCommand().equals("UserAdmin")) {
//            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
//            frameUsers.setVisible(true);
//        }
//    }
//
//    public static void main(String[] args) {
//        new MenuController();
//    }
}
