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
public class CoursesController implements ActionListener{

    FrameCourses frameCourses;
    SideBarButtonsPanel sideBarButtonsPanel;

    public CoursesController() {
        
        frameCourses = new FrameCourses();
        sideBarButtonsPanel = frameCourses.getSideBarButtonsPanel1();
        frameCourses.listen(this);
        sideBarButtonsPanel.listen(this);
    }

    public FrameCourses getFrameCourses() {
        return frameCourses;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case "editCoursesBtn":
               frameCourses.showMessage("edit");
               break;
           case "Carrers":
               frameCourses.showMessage("carrers");
               break;
           case "Courses":
               frameCourses.showMessage("courses");
               break;
           case "Study Plans":
               frameCourses.showMessage("plans");
               break;
           case "Users":
               frameCourses.showMessage("users");
               break;
       }
    }
    
}
