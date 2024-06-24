/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
public class StudyPlanController implements ActionListener {

    FrameStudyPlan frameStudyPlan;
    SideBarButtonsPanel sideBarButtonsPanel;

    public StudyPlanController() {
        
        frameStudyPlan = new FrameStudyPlan();
        sideBarButtonsPanel = frameStudyPlan.getSideBarButtonsPanel1();
        frameStudyPlan.listen(this);
        sideBarButtonsPanel.listen(this);
        
    }

    public FrameStudyPlan getFrameStudyPlan() {
        return frameStudyPlan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
           case "editCoursesBtn":
               frameStudyPlan.showMessage("edit");
               break;
           case "Carrers":
               frameStudyPlan.showMessage("carrers");
               break;
           case "Courses":
               frameStudyPlan.showMessage("courses");
               
               //frameStudyPlan.setVisible(false);
               break;
           case "Study Plans":
               frameStudyPlan.showMessage("plans");
               break;
           case "Users":
               frameStudyPlan.showMessage("users");
               break;
           case "downloadBtn":
               
               ImageIcon icon = new ImageIcon("src/main/resources/img/downloading.gif");
               JOptionPane.showMessageDialog(frameStudyPlan, null, "Descarga en proceso", JOptionPane.INFORMATION_MESSAGE, icon);
               break;
       }
    }

}
