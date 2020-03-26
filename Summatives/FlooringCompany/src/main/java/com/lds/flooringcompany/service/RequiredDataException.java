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
public class RequiredDataException extends Exception{
    
    public RequiredDataException(String message) {
        super(message);
    }
    
    public RequiredDataException(String message, Throwable cause){
        super(message, cause);
    }
}
