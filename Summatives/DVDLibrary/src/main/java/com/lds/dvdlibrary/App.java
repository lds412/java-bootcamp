/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary;

import com.lds.dvdlibrary.controller.DvdLibraryController;
import com.lds.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.lds.dvdlibrary.ui.DvdLibraryView;
import com.lds.dvdlibrary.ui.UserIO;
import com.lds.dvdlibrary.ui.UserIOConsoleImpl;
import com.lds.dvdlibrary.dao.DvdLibraryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lydia
 */
public class App {

    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();
//        DvdLibraryView myView = new DvdLibraryView(myIo);
//        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
//        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
//        controller.run();

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller
                = ctx.getBean("controller", DvdLibraryController.class);
        controller.run();
    }
}
