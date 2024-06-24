/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller.tables;

import edusys_project.controller.*;
import edusys_project.controller.JPA.*;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveba
 */
public class CareersTableController implements ActionListener {

    private FrameCareers frameCareers;
    private CareersController carrersController;
    private FrameCareersManagementMaintenance careersManagement;
    private CareersJpaController careersJpaController;
    private PanelTableCareers panelTable;
    private SideBarButtonsPanel panelSBB;

    public CareersTableController() {
        frameCareers = new FrameCareers(this);
        frameCareers.setLocationRelativeTo(null);
        carrersController = new CareersController();
        panelSBB = frameCareers.getPanelSBB();
        careersManagement = carrersController.getFrameCareersManagementMaintenance();
        panelSBB.listen(this);
        frameCareers.setVisible(true);
    }

    public FrameCareers getFrameCareers() {
        return frameCareers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("editCarrers")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            careersManagement.setVisible(true);
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
        new CareersTableController();
    }
}
