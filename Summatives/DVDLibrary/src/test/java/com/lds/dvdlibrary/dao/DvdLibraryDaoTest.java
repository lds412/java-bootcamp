/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary.dao;

import com.lds.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lydia
 */
public class DvdLibraryDaoTest {

    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    private LocalDate ld = LocalDate.parse("2001-01-01");

    public DvdLibraryDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        List<Dvd> dvdList = dao.listDvds();
        for (Dvd dvd : dvdList) {
            dao.removeDvd(dvd.getTitle());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddGetDvd() throws Exception {
        setUp(); //BeforeEach not working
        Dvd dvd = new Dvd("Something");
        dvd.setReleaseDate(ld);
        dvd.setDirector("Someone");
        dvd.setMpaaRating("R");
        dvd.setStudio("Somewhere");
        dvd.setUserNotes("It's something");

        dao.addDvd(dvd.getTitle(), dvd);

        Dvd fromDao = dao.displayDvd(dvd.getTitle());

        assertEquals(dvd, fromDao);
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveDvd() throws Exception {
        setUp(); //BeforeEach not working
        Dvd dvd1 = new Dvd("Something");
        dvd1.setReleaseDate(ld);
        dvd1.setDirector("Someone");
        dvd1.setMpaaRating("R");
        dvd1.setStudio("Somewhere");
        dvd1.setUserNotes("It's something");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("SomethingElse");
        dvd2.setReleaseDate(ld);
        dvd2.setDirector("SomeoneElse");
        dvd2.setMpaaRating("PG");
        dvd2.setStudio("SomewhereElse");
        dvd2.setUserNotes("It's something else");

        dao.addDvd(dvd2.getTitle(), dvd2);

        dao.removeDvd(dvd1.getTitle());
        assertEquals(1, dao.listDvds().size());
        assertNull(dao.displayDvd(dvd1.getTitle()));

        dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.listDvds().size());
        assertNull(dao.displayDvd(dvd2.getTitle()));
    }

    /**
     * Test of saveEdits method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveEdits() throws Exception {
        setUp(); //BeforeEach not working
        Dvd dvd = new Dvd("Something");
        dvd.setReleaseDate(ld);
        dvd.setDirector("Someone");
        dvd.setMpaaRating("R");
        dvd.setStudio("Somewhere");
        dvd.setUserNotes("It's something");

        dao.addDvd(dvd.getTitle(), dvd);
        
        Dvd fromDao = dao.displayDvd(dvd.getTitle());
        fromDao.setMpaaRating("PG-13");
        dao.saveEdits(fromDao.getTitle());
        
        Dvd fromDao2 = dao.displayDvd(fromDao.getTitle());
        
        assertEquals("PG-13", fromDao2.getMpaaRating());
        
    }

    /**
     * Test of listDvds method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testListDvds() throws Exception {
        setUp(); //BeforeEach not working
        Dvd dvd1 = new Dvd("Something");
        dvd1.setReleaseDate(ld);
        dvd1.setDirector("Someone");
        dvd1.setMpaaRating("R");
        dvd1.setStudio("Somewhere");
        dvd1.setUserNotes("It's something");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("SomethingElse");
        dvd2.setReleaseDate(ld);
        dvd2.setDirector("SomeoneElse");
        dvd2.setMpaaRating("PG");
        dvd2.setStudio("SomewhereElse");
        dvd2.setUserNotes("It's something else");

        dao.addDvd(dvd2.getTitle(), dvd2);

        assertEquals(2, dao.listDvds().size());
    }
}
