/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.shapes;

/**
 *
 * @author lydia
 */
public class Square extends Shape {

    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
    
    @Override
    public double getArea(){
        return sideLength*sideLength;
    }

    @Override
    public double getPerimeter(){
        return sideLength*4;
    }

}
