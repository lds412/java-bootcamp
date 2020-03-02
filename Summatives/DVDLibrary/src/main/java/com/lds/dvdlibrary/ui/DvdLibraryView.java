/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary.ui;

import com.lds.dvdlibrary.dto.Dvd;
import java.util.List;

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
        io.print("\t4. List All DVDs");
        io.print("\t5. View Specifc DVD");
        io.print("\t6. Exit");

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
            } else{
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
        String date = io.readString("\tPlease enter Release Date: ");
        dvd.setReleaseDate(date);
    }

    public void editRating(Dvd dvd) {
        String rating = io.readString("\tPlease enter MPAA Rating: ");
        dvd.setMpaaRating(rating);
    }

    public void editDirector(Dvd dvd) {
        String director = io.readString("\tPlease enter Director: ");
        dvd.setDirector(director);
    }

    public void editStudio(Dvd dvd) {
        String studio = io.readString("\tPlease enter Studio: ");
        dvd.setStudio(studio);
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
        io.readString("\n\tDVD edited. Press enter to continue. ");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        io.print("\nList DVDs:");
        for (Dvd currentDvd : dvdList) {
            io.print("\t" + currentDvd.getTitle());
        }
        io.readString("\n\tPress enter to continue. ");
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
        boolean valid = false;
        while (!valid) {
            String ans = io.readString("\tReally Delete? (y/n): ");
            if (ans.equals("y")) {
                return true;
            } else if (ans.equals("n")) {
                return false;
            } else {
                displayUnknownCommandBanner();
            }
        }
        return false; //Just to make IDE happy
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
