/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.tables;

import edusys_project.controller.*;
import edusys_project.controller.JPA.CourseJpaController;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveba
 */
public class CoursesTableController implements ActionListener{

    private FrameCourses frameCourses;
    private CoursesController coursesController;
    private FrameCoursesManagement coursesManagement;
    private CourseJpaController coursesJpaController;
    private PanelTableCourse panelTableCourse;
    private SideBarButtonsPanel panelSBB;

    public CoursesTableController() {
        frameCourses = new FrameCourses(this);
        frameCourses.setLocationRelativeTo(null);
        coursesController = new CoursesController();
        panelSBB = frameCourses.getPanelSBB();
        coursesManagement = coursesController.getFrameCoursesManagement();
        panelSBB.listen(this);
        frameCourses.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("editCourses")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            coursesManagement.setVisible(true);
        }
        if (e.getActionCommand().equals("Careers")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            
        }
        if (e.getActionCommand().equals("Courses")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            
        }
        if (e.getActionCommand().equals("Study Plans")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            
        }
        if (e.getActionCommand().equals("Users")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            
        }
    }

//    public static void main(String[] args) {
//        new CoursesTableController();
//    }
}
