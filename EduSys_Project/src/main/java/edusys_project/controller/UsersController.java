/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.controller.JPA.*;
import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.model.*;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fcama
 */
public class UsersController implements ActionListener {

    private PanelCRUD panelCRUD;
    private PanelUsersManagement panelUM;
    private FrameUsersManagement frameUM;
    private Users users;
    private UsersJpaController usersJpaController;

    public UsersController() {
        frameUM = new FrameUsersManagement();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
        usersJpaController = new UsersJpaController(emf);
        panelCRUD = frameUM.getPanelCRUD();
        panelUM = frameUM.getPanelUsersManagement();
        frameUM.listen(this);
        frameUM.setVisible(true);
        frameUM.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregar":

                int idUser = Integer.parseInt(panelUM.getTxtIdUser());
                String userName = panelUM.getTxtUserName();
                String name = panelUM.getTxtName();
                String lastName = panelUM.getTxtLastName();
                String eMail = panelUM.getTxtEmail();
                String phoneNumber = panelUM.getTxtPhoneNumber();
                String password = panelUM.getTxtPassword();

                if (userName.isEmpty() || name.isEmpty() || password.isEmpty() || lastName.isEmpty() || eMail.isEmpty()) {
                    System.out.println("Rellene los campos para el registro");
                } else {

                    try {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
//                        ModuleJpaController moduleJpa = new ModuleJpaController(emf);
//                        Modulo modulo;
//                        modulo = moduleJpa.findModule(1);
                        Integer id = 4;
                        Profile profile;
                        ProfileJpaController profileJpa = new ProfileJpaController(emf);
                        profileJpa.create(profile = new Profile(id, "Student", null));
                        users = new Users(idUser, name, password, userName, eMail, phoneNumber, lastName, profile);
                        usersJpaController.create(users);
                    } catch (Exception ex) {
                        Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
            case "Consultar":
                //muestra el JTable con los usuarios registrados
                break;
            case "Modificar":
                int idUserNew = Integer.parseInt(panelUM.getTxtIdUser());
                String userNameNew = panelUM.getTxtUserName();
                String nameNew = panelUM.getTxtName();
                String lastNameNew = panelUM.getTxtLastName();
                String eMailNew = panelUM.getTxtEmail();
                String phoneNumberNew = panelUM.getTxtPhoneNumber();
                String passwordNew = panelUM.getTxtPassword();

                if (userNameNew.isEmpty() || nameNew.isEmpty() || passwordNew.isEmpty() || lastNameNew.isEmpty() || eMailNew.isEmpty()) {
                    System.out.println("Rellene los campos para el registro");
                } else {

                    try {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");

                        Integer id = 1;
                        Profile profile;
                        ProfileJpaController profileJpa = new ProfileJpaController(emf);
                        profileJpa.create(profile = new Profile(id, "Student", null));
                        users = new Users(idUserNew, nameNew, passwordNew, userNameNew, eMailNew, 
                                phoneNumberNew, lastNameNew, profile);
                        usersJpaController.edit(users);
                    } catch (Exception ex) {
                        Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                
                break;
            case "Eliminar":
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
                ProfileJpaController profileJpa = new ProfileJpaController(emf);
                UsersJpaController userJpa = new UsersJpaController(emf);
                int idProfile = Integer.parseInt(panelUM.getTxtIdUser());

            {
                try {
                    profileJpa.destroy(idProfile);
                    userJpa.destroy(idProfile);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                break;

            case "Back":
                frameUM.dispose();
                break;
        }

    }

    public static void main(String[] args) throws Exception {
        new UsersController();

    }

}
