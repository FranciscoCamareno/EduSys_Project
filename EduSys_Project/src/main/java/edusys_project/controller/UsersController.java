/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.controller.JPA.*;
import edusys_project.model.*;
import edusys_project.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fcama
 */
public class UsersController implements ActionListener{

    private PanelCRUD panelCRUD;
    private PanelUsersManagement panelUM;
    private FrameUsersManagement frameUM;
    private Users users;
    private UsersJpaController usersJpaController;
    
    public UsersController() {
        frameUM = new FrameUsersManagement();
        panelCRUD = frameUM.getPanelCRUD();
        panelUM = frameUM.getPanelUsersManagement();
        frameUM.listen(this);
        frameUM.setVisible(true);
        frameUM.setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {


    }
    
    
    
}
