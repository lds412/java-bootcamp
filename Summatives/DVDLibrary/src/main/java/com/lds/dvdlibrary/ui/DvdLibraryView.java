/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary.ui;

import com.lds.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lydia
 */
public class DvdLibraryView {

    UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public String printMenuAndGetSelection() {
        io.print("\t==========");
        io.print("Main Menu:");
        io.print("\t1. Add DVD");
        io.print("\t2. Delete DVD");
        io.print("\t3. Edit DVD");
        io.print("\t4. List all DVDs");
        io.print("\t5. View specifc DVD");
        io.print("\t6. List all DVDs released within the last some years");
        io.print("\t7. List all DVDs with a given MPAA rating");
        io.print("\t8. List all DVDs with a given director");
        io.print("\t9. List all DVDs with a given studio");
        io.print("\t10. View average age of movies in collection");
        io.print("\t11. View newest movie in collection");
        io.print("\t12. View oldest movie in collection");
        io.print("\t13. Exit");

        return io.readString("Please select from the above choices: ");
    }

    public Dvd getNewDvdInfo() {
        io.print("\nAdd DVD:");
        String title = io.readString("\tPlease enter Title: ");
        boolean valid = false;
        while (!valid) {
            if (title.equals("N/A")) {
                io.print("\t Please enter a value.");
                title = io.readString("\tTitle: ");
            } else {
                valid = true;
            }
        }
        Dvd currentDvd = new Dvd(title);
        editDate(currentDvd);
        editRating(currentDvd);
        editDirector(currentDvd);
        editStudio(currentDvd);
        editNotes(currentDvd);
        return currentDvd;
    }

    public void editTitle(Dvd dvd) {
        String title = io.readString("\tPlease enter Title: ");
        dvd.setTitle(title);
    }

    public void editDate(Dvd dvd) {
        boolean valid = true;
        do {
            io.print("\tPlease enter Release Date: ");
            String year = io.readString("\tYear (yyyy): ");
            String month = io.readString("\tMonth (mm): ");
            String day = io.readString("\tDay (dd): ");
            String date = year + "-" + month + "-" + day;
            try {
                LocalDate ld = LocalDate.parse(date);
                dvd.setReleaseDate(ld);
                valid = true;
            } catch (DateTimeParseException e) {
                io.print("\nThat is not a valid date.\n");
                valid = false;
            }
        } while (!valid);
    }

    public int askForYears() {
        return io.readInt("How many years back do you want to go? ");
    }
    
    public void printAvgAge(double age){
        io.print("Average age of movies in collection: "+ age);
    }
    
    public void editRating(Dvd dvd) {
        String rating = askForRating();
        dvd.setMpaaRating(rating);
    }

    public String askForRating() {
        return io.readString("\tPlease enter MPAA Rating: ");
    }
    
    public void editDirector(Dvd dvd) {
        String director = askForDirector();
        dvd.setDirector(director);
    }

    public String askForDirector() {
        return io.readString("\tPlease enter Director: ");
    }
    
    public void editStudio(Dvd dvd) {
        String studio = askForStudio();
        dvd.setStudio(studio);
    }

    public String askForStudio() {
        return io.readString("\tPlease enter Studio: ");
    }
    
    public void editNotes(Dvd dvd) {
        String userNotes = io.readString("\tPlease enter any additional "
                + "information (e.g., \"Good family movie\"): ");
        dvd.setUserNotes(userNotes);
    }

    public void displayAddSuccessful() {
        io.readString("\n\tDVD added. Press enter to continue. ");
    }

    public void displayEditSuccessful() {
        io.readString("\tDVD edited. Press enter to continue. ");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        io.print("\nList DVDs:");
        for (Dvd currentDvd : dvdList) {
            io.print("\t" + currentDvd.getTitle()+", age: "+currentDvd.getDvdAge());
        }
        io.readString("\n\tPress enter to continue. ");
    }

    public void printDvdsByDirector(Map<String, List<Dvd>> dvdMap){
        Set<String> ratings = dvdMap.keySet();
        ratings.stream()
                .forEach(mpaa -> {System.out.println("====================");
                System.out.println("Rating: "+mpaa);
                dvdMap.get(mpaa).stream().forEach(m -> System.out.println(m.getTitle()));
                });
    }
    
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("\n\t" + dvd.getTitle() + ", " + dvd.getReleaseDate()
                    + ", " + dvd.getMpaaRating());
            io.print("\t" + dvd.getDirector() + ", " + dvd.getStudio());
            io.print("\t" + dvd.getUserNotes() + "\n");
        } else {
            io.print("\n\tNo such DVD in library.\n");
        }
    }

    public void displayContinueMessage() {
        io.readString("\tPress enter to continue. ");
    }

    public String editDvdByTitle() {
        io.print("\nEdit DVD:");
        return io.readString("\tPlease enter title of DVD to edit: ");
    }

    public String chooseEdit() {
        io.print("Editable information:");
        io.print("\t1. Title");
        io.print("\t2. Release Date");
        io.print("\t3. MPAA Rating");
        io.print("\t4. Director");
        io.print("\t5. Studio");
        io.print("\t6. Additional Information");
        return io.readString("Please select from the above choices "
                + "or press 0 to cancel: ");
    }

    public void editCanceled() {
        io.readString("Edit Canceled. Press enter to continue. ");
    }

    public String findDvdByTitle() {
        io.print("\nView DVD:");
        return io.readString("\tPlease enter title of DVD to view: ");
    }

    public String removeDvdByTitle() {
        io.print("\nDelete DVD:");
        return io.readString("\tPlease enter title of DVD to delete: ");
    }

    public boolean reallyDelete() {
        do {
            String ans = io.readString("\tReally Delete? (y/n): ");
            if (ans.equals("y")) {
                return true;
            } else if (ans.equals("n")) {
                return false;
            } else {
                displayUnknownCommandBanner();
            }
        } while(true);
    }

    public void deleteAborted() {
        io.readString("\n\tDelete Aborted. Press enter to continue. ");
    }

    public void displayRemoveSuccessful() {
        io.readString("\n\tDVD removed. Press enter to continue. ");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayExitBanner() {
        io.print("\nGood Bye!!!");
    }
}
