/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.service;

/**
 *
 * @author lydia
 */
public class InvalidChoiceException extends Exception {
    
    public InvalidChoiceException(String message) {
        super(message);
    }
    
    public InvalidChoiceException(String message, Throwable cause){
        super(message, cause);
    }
}
