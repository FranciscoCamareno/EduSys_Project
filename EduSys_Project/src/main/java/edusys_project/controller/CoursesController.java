/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.controller.JPA.CourseJpaController;
import edusys_project.model.Course;
import edusys_project.view.FrameCoursesManagement;
import edusys_project.view.PanelCRUD;
import edusys_project.view.PanelCoursesManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class CoursesController implements ActionListener {
   private PanelCoursesManagement panelCoursesManagement;  
   private FrameCoursesManagement frameCoursesManagement;
   private PanelCRUD panelCRUD;
   private CourseJpaController courseJpaController;
   private Course course;
    
    public CoursesController(){
       frameCoursesManagement = new FrameCoursesManagement();
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
       courseJpaController = new CourseJpaController(emf);
       panelCRUD = frameCoursesManagement.getPanelCRUD();                     
       panelCoursesManagement = frameCoursesManagement.getPanelCoursesManagement();
       frameCoursesManagement.listen(this);
       frameCoursesManagement.setLocationRelativeTo(null);
    }
    
    public FrameCoursesManagement getFrameCoursesManagement() {
        return frameCoursesManagement;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            case "Add":
                String name = panelCoursesManagement.getTxtCourseName();
                int amountCredits = Integer.parseInt(panelCoursesManagement.getTxtCredits());
                String description = panelCoursesManagement.getTxtDescription();
                int lessonHours = Integer.parseInt(panelCoursesManagement.getTxtLessonHours());
                int indepWorkHour = Integer.parseInt(panelCoursesManagement.getTxtInDeptWorkHours());
                String modality = panelCoursesManagement.getTxtModality();
                
                if (name.isEmpty() || description.isEmpty() || modality.isEmpty()) {
                    System.out.println("Rellene los campos para el registro");
                } else {

                    try {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
//                        Integer id = 1;
//                        Profile profile;
//                        ProfileJpaController profileJpa = new ProfileJpaController(emf);
//                        profileJpa.create(profile = new Profile(id, "Student", null));
                        course = new Course(name, amountCredits, description, indepWorkHour, lessonHours, modality);
                        courseJpaController.create(course);
                    } catch (Exception ex) {
                        Logger.getLogger(CoursesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            break;
            
            case "Consult":
                
            break;
            
            case "Edit":
                
            case "Delete":
                
            break;
            
            case "Back":
                frameCoursesManagement.dispose();
                
            break;
                
        }
    }
    
//    public static void main(String[] args) {
//        new CoursesController();
//    }
    
}
