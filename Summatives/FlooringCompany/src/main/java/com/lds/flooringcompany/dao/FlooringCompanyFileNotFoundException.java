/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.dao;

/**
 *
 * @author lydia
 */
public class FlooringCompanyFileNotFoundException extends Exception {
    
    public FlooringCompanyFileNotFoundException (String message) {
        super(message);
    }
    
    public FlooringCompanyFileNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
