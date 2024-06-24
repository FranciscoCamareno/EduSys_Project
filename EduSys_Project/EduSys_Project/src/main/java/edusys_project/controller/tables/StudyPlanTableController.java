/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.tables;

import edusys_project.controller.JPA.StudyPlanJpaController;
import edusys_project.controller.*;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author eveba
 */
public class StudyPlanTableController implements ActionListener {

    private FrameStudyPlan frameStudyPlan;
    private StudyPlanManagementController studyPlanController;
    private FrameStudyPlanManagementMaintenance studyPlanManagement;
    private StudyPlanJpaController studyPlanJpaController;
    private PanelTableStudyPlan panelTableStudyPlan;
    private SideBarButtonsPanel panelSBB;

    public StudyPlanTableController() {
        frameStudyPlan = new FrameStudyPlan(this);
        frameStudyPlan.setLocationRelativeTo(null);
        studyPlanController = new StudyPlanManagementController();
        panelSBB = frameStudyPlan.getPanelSBB();
        studyPlanManagement = studyPlanController.getFrameStudyPlanManagement();
        panelSBB.listen(this);
        frameStudyPlan.setVisible(true);
    }

    public FrameStudyPlan getFrameStudyPlan() {
        return frameStudyPlan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("editStudyPlanBtn")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            studyPlanManagement.setVisible(true);
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

    public static void main(String[] args) {
        new StudyPlanTableController();
    }
}
