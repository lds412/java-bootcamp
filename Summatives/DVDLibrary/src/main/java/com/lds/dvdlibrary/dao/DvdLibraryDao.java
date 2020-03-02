/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary.dao;

import com.lds.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author lydia
 */
public interface DvdLibraryDao {

    /**
     * Adds the given DVD to the library and associates it with the given title.
     * If there is already a DVD associated with the given title it will return
     * that DVD object, otherwise it will return null.
     *
     * @param title by which a DVD is identified
     * @param dvd DVD to be added to the library
     * @return the DVD object previously associated with the given title if it
     * exists, null otherwise
     * @throws com.lds.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;

    /**
     * Removes from the library the DVD associated with the given title. Returns
     * the DVD object that is being removed or null if there is no DVD
     * associated with the given title.
     *
     * @param title title of DVD to be removed from library
     * @return DVD object that was removed or null if no DVD was associated with
     * the given title
     * @throws com.lds.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd removeDvd(String title) throws DvdLibraryDaoException;
    
    /**
     * Saves any edits made. Returns the DVD object that is being edited 
     * or null if there is no DVD associated with the given title.
     *
     * @param title title of DVD to be edited
     * @return DVD object that was edited or null if no DVD was associated with
     * the given title
     * @throws com.lds.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd saveEdits(String title) throws DvdLibraryDaoException;
    
    /**
     * Returns a String array containing all the DVDs in the library.
     *
     * @return String array containing all the DVDs in the library
     * @throws com.lds.dvdlibrary.dao.DvdLibraryDaoException
     */
    List<Dvd> listDvds() throws DvdLibraryDaoException;
    
    /**
     * Returns the DVD object associated with the given title. Returns null 
     * if no such DVD exists.
     *
     * @param title title associated with DVD to retrieve
     * @return the DVD object associated with the given title, null if
     * no such DVD exists
     * @throws com.lds.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd displayDvd(String title) throws DvdLibraryDaoException;
}
