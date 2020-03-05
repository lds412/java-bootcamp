/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary.controller;

import com.lds.dvdlibrary.dao.DvdLibraryDaoException;
import com.lds.dvdlibrary.ui.DvdLibraryView;
import com.lds.dvdlibrary.dao.DvdLibraryDao;
import com.lds.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author lydia
 */
public class DvdLibraryController {

    DvdLibraryView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        String menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case "1":
                        addDvd();
                        break;
                    case "2":
                        removeDvd();
                        break;
                    case "3":
                        editDvd();
                        break;
                    case "4":
                        listDvds();
                        break;
                    case "5":
                        displayDvd();
                        break;
                    case "6":
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private String getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvd() throws DvdLibraryDaoException {
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayAddSuccessful();
    }

    private void removeDvd() throws DvdLibraryDaoException {
        String title = view.removeDvdByTitle();
        Dvd dvd = dao.displayDvd(title);
        view.displayDvd(dvd);
        if (dvd == null) {
            view.displayContinueMessage();
        } else {
            if (view.reallyDelete()) {
                dao.removeDvd(title);
                view.displayRemoveSuccessful();
            } else {
                view.deleteAborted();
            }
        }
    }

    private void editDvd() throws DvdLibraryDaoException {
        String title = view.editDvdByTitle();
        Dvd dvd = dao.displayDvd(title);
        view.displayDvd(dvd);
        if (dvd == null) {
            view.displayContinueMessage();
        } else {
            String chosenEdit = view.chooseEdit();
            switch (chosenEdit) {
                case "0":
                    view.editCanceled();
                    //dao.saveEdits(title);
                    break;
                case "1":
                    view.editTitle(dvd);
                    view.displayDvd(dvd);
                    view.displayEditSuccessful();
                    dao.saveEdits(title);
                    break;
                case "2":
                    view.editDate(dvd);
                    view.displayDvd(dvd);
                    view.displayEditSuccessful();
                    dao.saveEdits(title);
                    break;
                case "3":
                    view.editRating(dvd);
                    view.displayDvd(dvd);
                    view.displayEditSuccessful();
                    dao.saveEdits(title);
                    break;
                case "4":
                    view.editDirector(dvd);
                    view.displayDvd(dvd);
                    view.displayEditSuccessful();
                    dao.saveEdits(title);
                    break;
                case "5":
                    view.editStudio(dvd);
                    view.displayDvd(dvd);
                    view.displayEditSuccessful();
                    dao.saveEdits(title);
                    break;
                case "6":
                    view.editNotes(dvd);
                    view.displayDvd(dvd);
                    view.displayEditSuccessful();
                    dao.saveEdits(title);
                    break;
                default:
                    unknownCommand();
            }
        }
    }

    private void listDvds() throws DvdLibraryDaoException {
        List<Dvd> dvdList = dao.listDvds();
        view.displayDvdList(dvdList);
    }

    private void displayDvd() throws DvdLibraryDaoException {
        String title = view.findDvdByTitle();
        Dvd dvd = dao.displayDvd(title);
        view.displayDvd(dvd);
        view.displayContinueMessage();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
