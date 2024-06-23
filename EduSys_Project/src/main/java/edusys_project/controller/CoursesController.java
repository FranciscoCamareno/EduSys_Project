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
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            case "Add":
                
            break;
            
            case "Consult":
                
            break;
            
            case "Edit":
                
            case "Delete":
                
            break;
            
            case "Back":
                
            break;    
        }
    }
    
}
