/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import com.lds.userio.IO;

/**
 *
 * @author lydia
 */
public class StudentQuizGrades {

    public static void main(String[] args) {

        HashMap<String, ArrayList<Integer>> grades = new HashMap<>();

        IO io = new IO();
        while (true) {

            boolean quit = false;

            io.print("What would you like to do?\n");
            io.print("Add a student - \"add\"");
            io.print("Remove a student - \"remove\"");
            io.print("View list of students - \"list\"");
            io.print("View scores for a particular student - \"scores\"");
            io.print("View average score for a particular student - \"average\"");
            io.print("Exit program - \"exit\"");

            String command = io.readString("\nEnter here: ");

            switch (command) {
                case "add":
                    addStudent(grades, io);
                    break;
                case "remove":
                    removeStudent(grades, io);
                    break;
                case "list":
                    viewStudents(grades);
                    break;
                case "scores":
                    viewScores(grades, io);
                    break;
                case "average":
                    averageScore(grades, io);
                    break;
                case "exit":
                    quit = true;
                    break;
                default:
                    System.out.println("\nThat was not a valid operation. Try again.\n");
            }

            if (quit) {
                break;
            }

        }
        io.print("\nThank you. Goodbye!");
    }

    //View a list of students in the system
    public static void viewStudents(HashMap grades) {
        if (grades.isEmpty()) {
            System.out.println("\nThere are currently no students to list.");
        } else {
            Set<String> students = grades.keySet();
            for (String s : students) {
                System.out.println(s);
            }
        }
        System.out.println("");
    }

    //Add a student to the system
    public static void addStudent(HashMap grades, IO io) {
        String name = io.readString("\nPlease enter a name: ");
        int numScores = io.readInt("\nHow many scores would you like to add? ");
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < numScores; i++) {
            int score = io.readInt("\nPlease enter a score: ", 0, 100);
            scores.add(score);
        }
        grades.put(name, scores);
        System.out.println("");
        System.out.println(name + " added.\n");
    }

    //Remove a student from the system
    //This currently does not check to make sure the student exists before removing
    public static void removeStudent(HashMap grades, IO io) {
        if (grades.isEmpty()) {
            System.out.println("\nThere are currently no students to remove.");
        } else {
            String name = io.readString("\nPlease enter a name: ");
            grades.remove(name);
            System.out.println(name + " removed.\n");
        }
        System.out.println("");
    }

    //View a list of quiz scores for a given student
    public static void viewScores(HashMap<String, ArrayList<Integer>> grades, IO io) {
        boolean exists = false;
        String name = io.readString("\nPlease enter a name: ");
        Set<String> students = grades.keySet();
        for (String s : students) {
            if (s.equals(name)) {
                exists = true;
                ArrayList<Integer> scores = grades.get(name);
                for (int i : scores) {
                    System.out.println(i);
                }
                break;
            }
        }
        if(!exists){
            System.out.println("\nThere is no student listed with that name.");
        }
        System.out.println("");
    }

    //View the average quiz score for a given student
    public static void averageScore(HashMap<String, ArrayList<Integer>> grades, IO io) {
        double sum = 0;
        double num = 0;
        boolean exists = false;
        String name = io.readString("\nPlease enter a name: ");
        Set<String> students = grades.keySet();
        for (String s : students) {
            if (s.equals(name)) {
                exists = true;
                for (int i : grades.get(name)) {
                    sum += i;
                    num++;
                }
                System.out.println(sum / num);
                break;
            }
        }
        if (!exists) {
            System.out.println("\nThere is no student listed with that name.");
        }
        System.out.println("");
    }
}
