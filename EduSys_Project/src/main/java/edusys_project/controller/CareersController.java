/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.controller.JPA.CareersJpaController;
import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.model.Careers;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveba
 */
public class CareersController implements ActionListener {

    private PanelCRUD panelCRUD;
    private PanelCareersManagementAndMaintenance panelCMM;
    private FrameCareersManagementMaintenance frameCMM;
    private Careers careers;
    private CareersJpaController careersJpaController;

    public CareersController() {
        frameCMM = new FrameCareersManagementMaintenance();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
        careersJpaController = new CareersJpaController(emf);
        panelCRUD = frameCMM.getPanelCRUD();
        panelCMM = frameCMM.getPanelUsersManagement();
        frameCMM.listen(this);
        frameCMM.setVisible(true);
        frameCMM.setLocationRelativeTo(null);
    }

    public FrameCareersManagementMaintenance getFrameCareersManagementMaintenance() {
        return frameCMM;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregar":

                String idCareer = panelCMM.getTxtIdCareers();
                String name = panelCMM.getTxtName();
                String description = panelCMM.getTxtDescription();
                String profProfile = panelCMM.getTxtProfessionalProfile();
                String workingMarket = panelCMM.getTxtWorkingMarket();

                if (idCareer.isEmpty() || name.isEmpty() || description.isEmpty() || profProfile.isEmpty() || workingMarket.isEmpty()) {
                    System.out.println("Rellene los campos para el registro");
                } else {

                    try {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
                        careers = new Careers(idCareer, name, description, profProfile, workingMarket, null);
                        careersJpaController.create(careers);
                    } catch (Exception ex) {
                        Logger.getLogger(CareersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "Search":
                //Que se quede como el buscar
                break;
            case "Modificar":
                String idCareerNew = panelCMM.getTxtIdCareers();
                String nameNew = panelCMM.getTxtName();
                String descriptionNew = panelCMM.getTxtDescription();
                String profProfileNew = panelCMM.getTxtProfessionalProfile();
                String workingMarketNew = panelCMM.getTxtWorkingMarket();

                if (idCareerNew.isEmpty() || nameNew.isEmpty() || descriptionNew.isEmpty() || profProfileNew.isEmpty() || workingMarketNew.isEmpty()) {
                    System.out.println("Rellene los campos para el registro");
                } else {

                    try {
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");

                        careers = new Careers(idCareerNew, nameNew, descriptionNew, profProfileNew, workingMarketNew, null);
                        careersJpaController.edit(careers);
                    } catch (Exception ex) {
                        Logger.getLogger(CareersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
            case "Eliminar":
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
                CareersJpaController careerJpa = new CareersJpaController(emf);
                String idCareers = panelCMM.getTxtIdCareers();

                 {
                    try {
                        careerJpa.destroy(idCareers);
                    } catch (IllegalOrphanException ex) {
                        Logger.getLogger(CareersController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(CareersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case "Back":
                frameCMM.dispose();
                break;
        }
    }
    
//    public static void main(String[] args) {
//        new CareersController();
//    }
}
