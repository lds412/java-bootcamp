/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.dvdlibrary.dao;

import com.lds.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author lydia
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public static final String DVD_FILE = "dvds.txt";
    public static final String DELIMITER = "::";

    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        loadDvds();
        Dvd newDvd = dvds.put(title.toUpperCase(), dvd);
        writeDvds();
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadDvds();
        Dvd removedDvd = dvds.remove(title.toUpperCase());
        writeDvds();
        return removedDvd;
    }

    @Override
    public Dvd saveEdits(String title) throws DvdLibraryDaoException {
        //loadDvds();
        //Dvd editedDvd = dvds.get(title);
        writeDvds();
        return dvds.get(title.toUpperCase());
    }

    @Override
    public List<Dvd> listDvds() throws DvdLibraryDaoException {
        loadDvds();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd displayDvd(String title) throws DvdLibraryDaoException {
        loadDvds();
        return dvds.get(title.toUpperCase());
    }

    @Override
    public List<Dvd> getDvdsYoungerThan(int ageInYears) throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .filter(d -> d.getDvdAge() < ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getDvdsByDirector(String director) throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.groupingBy(Dvd::getMpaaRating));
    }

    @Override
    public List<Dvd> getDvdsByStudio(String studio) throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageDvdAge() throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .mapToLong(Dvd::getDvdAge)
                .average()
                .getAsDouble();
    }

    @Override
    public Map<Long, List<Dvd>> getAllDvdsGroupedByAge() throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .collect(Collectors.groupingBy(Dvd::getDvdAge));
    }

    @Override
    public Optional<Dvd> getNewestDvd() throws DvdLibraryDaoException {
        loadDvds();
        //Map<Long, List<Dvd>> mapByAge = getAllDvdsGroupByAge();
        //Set<Long> ages = mapByAge.keySet();
        //Long minAge = ages.stream();
        //return mapByAge.get(minAge);
        return dvds.values()
                .stream()
                .min(Comparator.comparing(Dvd::getDvdAge));
    }

    @Override
    public Optional<Dvd> getOldestDvd() throws DvdLibraryDaoException {
        loadDvds();
        return dvds.values()
                .stream()
                .max(Comparator.comparing(Dvd::getDvdAge));
    }

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        Dvd dvdFromFile = new Dvd(title);

        LocalDate ld = LocalDate.parse(dvdTokens[1]);
        dvdFromFile.setReleaseDate(ld);
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        dvdFromFile.setDirector(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserNotes(dvdTokens[5]);

        return dvdFromFile;
    }

    private void loadDvds() throws DvdLibraryDaoException {
        Scanner s;

        try {
            s = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load DVD library into memory.", e);
        }

        String currentLine;
        Dvd currentDvd;

        while (s.hasNextLine()) {
            // get the next line in the file
            currentLine = s.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the title as the map key for our dvd object.
            // Put currentDvd into the map using title as the key
            dvds.put(currentDvd.getTitle().toUpperCase(), currentDvd);
        }
        // close scanner
        s.close();
    }

    private String marshallDvd(Dvd aDvd) {

        String dvdAsText = aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDirector() + DELIMITER;
        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getUserNotes();
        return dvdAsText;
    }

    /**
     * Writes all DVDs in library out to a DVD_FILE. See loadDvds for file
     * format.
     *
     * @throws DvdLibraryDaoException if an error occurs writing to the file
     */
    private void writeDvds() throws DvdLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = this.listDvds();
        for (Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
