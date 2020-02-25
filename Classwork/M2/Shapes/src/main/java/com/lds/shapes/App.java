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
public class App {
    public static void main(String[] args) {
        Square s = new Square();
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        Circle c = new Circle();
        
        s.setColor("red");
        r.setColor("orange");
        t.setColor("yellow");
        c.setColor("green");
        
        s.setSideLength(5);
        r.setLength(4);
        r.setWidth(7);
        c.setRadius(3);
        
        System.out.println("The square is "+s.getColor());
        System.out.println("The circle has an area of "+c.getArea());
        System.out.println("The rectangle has a perimeter of "+r.getPerimeter());
    }
}
