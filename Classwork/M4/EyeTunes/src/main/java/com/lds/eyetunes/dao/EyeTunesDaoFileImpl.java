/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.eyetunes.dao;

import com.lds.eyetunes.dto.Song;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author lydia
 */
public class EyeTunesDaoFileImpl implements EyeTunesDao {

    public static final String DELIMITER = "::";
    public static final String ARTIST_FILE = "artist.txt";

    public ArrayList<String> fileNames = new ArrayList<>();

    private Map<String, Song> songs = new HashMap<>();

    @Override
    public Song addSong(String title, Song song) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        Song newSong = songs.put(title.toUpperCase(), song);
        checkArtist(title);
        writeSongs();
        //writeArtists();
        return newSong;
    }

    @Override
    public Song removeSong(String title) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        Song removedSong = songs.remove(title.toUpperCase());
        writeSongs();
        //writeArtists();
        return removedSong;
    }

    @Override
    public Song saveEdits(Song song) throws EyeTunesDaoException {
        Song editedSong = song;
        checkArtist(editedSong.getTitle());
        writeSongs();
        //writeArtists();
        return editedSong;
    }

//    @Override
//    public List<Song> listSongs() throws EyeTunesDaoException {
//        loadArtists();
//        loadAllSongs();
//        return new ArrayList<Song>(songs.values());
//    }
    
    @Override
    public Map<String, List<Song>> listSongs() throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        return songs.values()
                .stream()
                .collect(Collectors.groupingBy(Song::getArtistName));
    }

    @Override
    public Song getSong(String title) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        return songs.get(title.toUpperCase());
    }

//    @Override
//    public Map<String, List<Song>> getSongsByArtist(String artist) throws EyeTunesDaoException {
//        return songs.values()
//                .stream()
//                .filter(s -> s.getArtistName().equalsIgnoreCase(artist))
//                .collect(Collectors.groupingBy(Song::getArtistName));
//    }
    
    @Override
    public List<Song> getSongsByArtist(String artist) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        return songs.values()
                .stream()
                .filter(s -> s.getArtistName().equalsIgnoreCase(artist))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> getSongsByAlbum(String album) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        return songs.values()
                .stream()
                .filter(s -> s.getAlbumTitle().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Song> getSongsByGenre(String genre) throws EyeTunesDaoException {
//        loadArtists();
//        loadAllSongs();
//        return songs.values()
//                .stream()
//                .filter(s -> s.getGenre().equalsIgnoreCase(genre))
//                .collect(Collectors.toList());
//    }
    
    @Override
    public Map<String, List<Song>> getSongsByGenre(String genre) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        return songs.values()
                .stream()
                .filter(s -> s.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.groupingBy(Song::getArtistName));
    }

    @Override
    public Map<String, List<Song>> getSongsOlderThan(int years) throws EyeTunesDaoException {
        loadArtists();
        loadAllSongs();
        return songs.values()
                .stream()
                .filter(s -> s.getSongAge() > years)
                .collect(Collectors.groupingBy(Song::getArtistName));
    }

    @Override
    public boolean checkSongExists(String songTitle) throws EyeTunesDaoException {
        boolean songExists = false;
        if (songs.containsKey(songTitle.toUpperCase())) {
            songExists = true;
        }
        return songExists;
    }
    
    public void checkArtist(String title) throws EyeTunesDaoException {
        Song aSong = songs.get(title.toUpperCase());
        String artist = aSong.getArtistName();
        for (String currentArtist : fileNames) {
            if (artist.equalsIgnoreCase(currentArtist)) {
                break;
            }
        }
        createNewFile(artist);
    }
    
    public void createNewFile(String artist) throws EyeTunesDaoException {
        File file = new File(artist + ".txt");
        fileNames.add(artist);

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("artist.txt", true));
        } catch (IOException e) {
            throw new EyeTunesDaoException(
                    "Could not save artist data.", e);
        }

        out.println(artist);
        out.flush();
        out.close();
    }

    private Song unmarshallSong(String songAsText, String fileName) {
        String[] songTokens = songAsText.split(DELIMITER);
        String title = songTokens[0];
        Song songFromFile = new Song(title);

        songFromFile.setArtistName(fileName);
        songFromFile.setGenre(songTokens[1]);
        songFromFile.setSongPrice(songTokens[2]);
        songFromFile.setReleaseDate(songTokens[3]);
        songFromFile.setAlbumTitle(songTokens[4]);

        return songFromFile;
    }

    private void loadArtists() throws EyeTunesDaoException {
        Scanner s;

        try {
            s = new Scanner(new BufferedReader(new FileReader("artist.txt")));
        } catch (FileNotFoundException e) {
            throw new EyeTunesDaoException(
                    "-_- Could not load artists into memory.", e);
        }

        while (s.hasNextLine()) {
            fileNames.add(s.nextLine());
        }

        s.close();
    }

//THIS METHOD LOADS ALL SONGS FROM ALL FILES
    private void loadAllSongs() throws EyeTunesDaoException {
        Scanner s;

        for (String currentFile : fileNames) {
            try {
                s = new Scanner(new BufferedReader(new FileReader(currentFile + ".txt")));
            } catch (FileNotFoundException e) {
                throw new EyeTunesDaoException(
                        "-_- Could not load songs into memory.", e);
            }

            String currentLine;
            Song currentSong;

            while (s.hasNextLine()) {
                currentLine = s.nextLine();
                currentSong = unmarshallSong(currentLine, currentFile);
                songs.put(currentSong.getTitle().toUpperCase(), currentSong);
            }
            s.close();
        }
    }

    private String marshallSong(Song aSong) {

        String songAsText = aSong.getTitle() + DELIMITER;
        songAsText += aSong.getGenre() + DELIMITER;
        //songAsText += aSong.getArtistName() + DELIMITER;
        songAsText += aSong.getSongPrice() + DELIMITER;
        songAsText += aSong.getReleaseDate() + DELIMITER;
        songAsText += aSong.getAlbumTitle();
        return songAsText;
    }

//    private void writeArtists() throws EyeTunesDaoException {
//        PrintWriter out;
//
//        try {
//            out = new PrintWriter(new FileWriter("artist.txt"));
//        } catch (IOException e) {
//            throw new EyeTunesDaoException(
//                    "Could not save artist data.", e);
//        }
//
//        for (String artist : fileNames) {
//            out.println(artist);
//            out.flush();
//        }
//        out.close();
//    }

    private void writeSongs() throws EyeTunesDaoException {
        PrintWriter out;

        for (String currentFile : fileNames) {
            try {
                out = new PrintWriter(new FileWriter(currentFile + ".txt"));
            } catch (IOException e) {
                throw new EyeTunesDaoException(
                        "Could not save song data.", e);
            }

            String songAsText;
            //List<Song> songList = this.getSongsByArtist(currentFile);
            List<Song> songList = songs.values()
                    .stream()
                    .filter(s -> s.getArtistName().equalsIgnoreCase(currentFile))
                    .collect(Collectors.toList());
            for (Song currentSong : songList) {
                songAsText = marshallSong(currentSong);
                out.println(songAsText);
                out.flush();
            }
            out.close();
        }
    }
}
