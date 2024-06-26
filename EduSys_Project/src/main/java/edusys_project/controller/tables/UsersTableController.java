package edusys_project.controller.tables;

import edusys_project.controller.*;
import edusys_project.controller.JPA.*;
import edusys_project.model.*;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsersTableController implements ActionListener {

    private FrameUsers frameUsers;
    private UsersController usersController;
    private FrameUsersManagement usersManagement;
    private UsersJpaController usersJpaController;
    private PanelTableUsers panelTableUsers;

    public UsersTableController() {
        frameUsers = new FrameUsers(this);
        frameUsers.setLocationRelativeTo(null);
        usersController = new UsersController();
        usersManagement = usersController.getFrameUsersManagement();
//        frameUsers.setVisible(true);
    }
    
    public FrameUsers getFrameUsers() {
        return frameUsers;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("editUsers")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            usersManagement.setVisible(true);
        }
        if (e.getActionCommand().equals("Back")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            frameUsers.dispose();
        }
    }

//    public static void main(String[] args) {
//        new UsersTableController();
//    }
}
