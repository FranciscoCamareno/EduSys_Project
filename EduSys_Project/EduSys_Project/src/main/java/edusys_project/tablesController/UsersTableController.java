package edusys_project.tablesController;

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
        panelTableUsers = new PanelTableUsers();
        usersManagement = usersController.getFrameUsersManagement();
        // Inicializar usersJpaController
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
        usersJpaController = new UsersJpaController(emf);
        frameUsers.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("editUsers")) {
            System.out.println("edusys_project.tablesController.UsersTableController.actionPerformed()");
            usersManagement.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UsersTableController();
    }
}
