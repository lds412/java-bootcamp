/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.howmanydaysuntilfriday;

import java.util.Scanner;

/**
 *
 * @author lydia
 */
public class App {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter a day of the week: ");
        String weekday = s.nextLine();
        DaysOfTheWeek dayEnum = convertToEnum(weekday);

        switch (dayEnum) {
            case SUNDAY:
                System.out.println("5 days until Friday");
                break;
            case MONDAY:
                System.out.println("4 days until Friday");
                break;
            case TUESDAY:
                System.out.println("3 days until Friday");
                break;
            case WEDNESDAY:
                System.out.println("2 days until Friday");
                break;
            case THURSDAY:
                System.out.println("1 days until Friday");
                break;
            case FRIDAY:
                System.out.println("0 days until Friday");
                break;
            case SATURDAY:
                System.out.println("6 days until Friday");
                break;
            default:
                System.out.println("You may have misspelled that day, "
                        + "or you may need to capitalize the first letter");
        }

    }

    public static DaysOfTheWeek convertToEnum(String weekday) {
        switch (weekday) {
            case "Sunday":
                return DaysOfTheWeek.SUNDAY;
            case "Monday":
                return DaysOfTheWeek.MONDAY;
            case "Tuesday":
                return DaysOfTheWeek.TUESDAY;
            case "Wesnesday":
                return DaysOfTheWeek.WEDNESDAY;
            case "Thursday":
                return DaysOfTheWeek.THURSDAY;
            case "Friday":
                return DaysOfTheWeek.FRIDAY;
            case "Saturday":
                return DaysOfTheWeek.SATURDAY;
            default:
                return DaysOfTheWeek.MISSPELLED;
        }
    }
}
