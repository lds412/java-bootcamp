/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany;

import com.lds.flooringcompany.controller.FlooringCompanyController;
import com.lds.flooringcompany.service.DateDiscrepencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lydia
 */
public class App {

    //THROWS EXCEPTION???????????
    public static void main(String[] args) throws DateDiscrepencyException {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringCompanyController controller
                = ctx.getBean("controller", FlooringCompanyController.class);
        controller.run();
    }
}
