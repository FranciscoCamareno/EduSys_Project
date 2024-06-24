/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import com.google.protobuf.TextFormat.ParseException;
import edusys_project.controller.JPA.StudyPlanJpaController;
import edusys_project.controller.JPA.exceptions.IllegalOrphanException;
import edusys_project.controller.JPA.exceptions.NonexistentEntityException;
import edusys_project.model.Careers;
import edusys_project.model.StudyPlan;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author valer
 */
public class StudyPlanManagementController implements ActionListener {

    FrameStudyPlanManagementMaintenance frameSPM;
    PanelCRUD panelCRUD;
    PanelStudyPlanManagementAndMaintenance panelSPM;
    StudyPlan studyPlan;
    StudyPlanJpaController studyPlanJpaController;
    Careers carrers;

    public StudyPlanManagementController() {

        frameSPM = new FrameStudyPlanManagementMaintenance();
        panelCRUD = frameSPM.getPanelCRUD1();
        panelSPM = frameSPM.getPanelStudyPlanManagementAndMaintenance1();
        studyPlanJpaController = new StudyPlanJpaController();
        panelCRUD.listen(this);
        frameSPM.setLocationRelativeTo(null);
        frameSPM.setVisible(true);
        studyPlan = null;
        carrers = null;
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregar":
                System.out.println("yei");

                String idStudy_Plan = panelSPM.getIdStudyNameTxt();
                int idStudy_PlanInt = Integer.parseInt(idStudy_Plan);
                String description = panelSPM.getDescriptionStudyPlanTxt();
                //String amount_credits = panelSPM.get
                String effective_date = panelSPM.getEffectiveDateTxt();
                String approval_date = panelSPM.getApprovalDateTxt();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date effectiveDate = null;
                try {
                    effectiveDate = dateFormat.parse(effective_date);
                } catch (java.text.ParseException ex) {
                    frameSPM.showMessage("Fecha no válida. Por favor, ingrese la fecha en el formato dd-MM-yyyy.");
                    Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Date approvalDate = null;
                try {
                    approvalDate = dateFormat.parse(approval_date);
                } catch (java.text.ParseException ex) {
                    frameSPM.showMessage("Fecha no válida. Por favor, ingrese la fecha en el formato dd-MM-yyyy.");
                    Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (idStudy_Plan.isEmpty() || description.isEmpty() || effective_date.isEmpty() || approval_date.isEmpty()) {
                    frameSPM.showMessage("Por favor ingrese la informacion en todos los espacios para agregar un Plan de Estudio");
                } else {

                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
                    studyPlan = new StudyPlan(idStudy_PlanInt, description, effectiveDate, approvalDate);
                    try {
                        studyPlanJpaController.create(studyPlan);
                        panelSPM.setIdStudyNameTxt("");
                        panelSPM.setDescriptionStudyPlanTxt("");
                        panelSPM.setApprovalDateTxt("");
                        panelSPM.setEffectiveDateTxt("");
                        frameSPM.showMessage("The Study Plan was successfully added to the database");
                    } catch (Exception ex) {
                        Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                break;
            case "Consultar":
                String idStudyPlan = panelSPM.getIdStudyNameTxt();
                frameSPM.showMessage("ID de plan de estudio ingresado: " + idStudyPlan);
                int idStudyPlanInt = Integer.parseInt(idStudyPlan);

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EduSysPersistence");
                studyPlanJpaController.findStudyPlan(idStudyPlanInt);
//                panelSPM.setDescriptionStudyPlanTxt(studyPlan.getDescription());
                if (studyPlan != null) {
                    frameSPM.showMessage("prueba");
                    panelSPM.setDescriptionStudyPlanTxt(studyPlan.getDescription());
                } else {
                    frameSPM.showMessage("El plan de estudio no se encuentra registrado");
                }

                break;
            case "Modificar":
                String newStudyPlanId = panelSPM.getIdStudyNameTxt();
                int newStudyPlanIdInt = Integer.parseInt(newStudyPlanId);
                String newDescription = panelSPM.getDescriptionStudyPlanTxt();
                String newEffectiveDateString = panelSPM.getEffectiveDateTxt();
                String newApprovalDateString = panelSPM.getApprovalDateTxt();

                SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yyyy");

                Date newEffectiveDate = null;
                 {
                    try {
                        newEffectiveDate = newDateFormat.parse(newEffectiveDateString);
                    } catch (java.text.ParseException ex) {
                        Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                Date newApprovalDate = null;
                 {
                    try {
                        newApprovalDate = newDateFormat.parse(newApprovalDateString);
                    } catch (java.text.ParseException ex) {
                        Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                carrers = new Careers("", "", "", "", "");
                studyPlan = new StudyPlan(newStudyPlanIdInt, newDescription, newEffectiveDate, newApprovalDate);
            {
                try {
                    studyPlanJpaController.editar(studyPlan);
                    frameSPM.showMessage("El plan de estudio fue modificado exitosamente");
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "Eliminar":
                String studyPlanId = panelSPM.getIdStudyNameTxt();

                int studyPlanIdInt = Integer.parseInt(studyPlanId);
                 {
                    try {
                        studyPlanJpaController.destroy(studyPlanIdInt);
                        frameSPM.showMessage("El plan de estudios fue eliminado correctamente");
                        panelSPM.setIdStudyNameTxt("");
                    } catch (IllegalOrphanException ex) {
                        Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(StudyPlanManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case "Back":
                System.exit(0);
                break;
        }
    }

//    public static void main(String[] args) {
//        new StudyPlanManagementController();
//    }
}
