/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusys_project.controller;

import edusys_project.view.*;
import edusys_project.view.SideBarButtonsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author valer
 */
public class CarrersController implements ActionListener {

    FrameCarrers frameCarrers;
    SideBarButtonsPanel sideBarButtonsPanel;

    public CarrersController() {

        frameCarrers = new FrameCarrers();
        sideBarButtonsPanel = frameCarrers.getSideBarButtonsPanel1();
        frameCarrers.listen(this);
        sideBarButtonsPanel.listen(this);

    }

    public FrameCarrers getFrameCarrers() {
        return frameCarrers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "editCarrersBtn":
                frameCarrers.showMessage("edit");
                break;
            case "Carrers":
                frameCarrers.showMessage("carrers");
                break;
            case "Courses":
                frameCarrers.showMessage("courses");
                break;
            case "Study Plans":
                frameCarrers.showMessage("plans");
                break;
            case "Users":
                frameCarrers.showMessage("users");
                break;
        }
    }

}
