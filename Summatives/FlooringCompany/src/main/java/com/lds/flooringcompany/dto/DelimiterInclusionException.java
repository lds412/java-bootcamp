/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.flooringcompany.dto;

/**
 *
 * @author lydia
 */
public class DelimiterInclusionException extends Exception {
    
    public DelimiterInclusionException (String message) {
        super(message);
    }
    
    public DelimiterInclusionException(String message, Throwable cause){
        super(message, cause);
    }
}
