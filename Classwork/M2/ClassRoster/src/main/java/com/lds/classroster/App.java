/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.classroster;

import com.lds.classroster.controller.ClassRosterController;
import com.lds.classroster.dao.ClassRosterAuditDao;
import com.lds.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.lds.classroster.dao.ClassRosterDao;
import com.lds.classroster.dao.ClassRosterDaoFileImpl;
import com.lds.classroster.service.ClassRosterServiceLayer;
import com.lds.classroster.service.ClassRosterServiceLayerImpl;
import com.lds.classroster.ui.ClassRosterView;
import com.lds.classroster.ui.UserIO;
import com.lds.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author lydia
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
    }
}
