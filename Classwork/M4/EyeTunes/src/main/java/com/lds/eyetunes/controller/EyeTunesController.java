/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.eyetunes.controller;

import com.lds.eyetunes.dao.EyeTunesDao;
import com.lds.eyetunes.dao.EyeTunesDaoException;
import com.lds.eyetunes.dto.Song;
import com.lds.eyetunes.ui.EyeTunesView;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lydia
 */
public class EyeTunesController {

    EyeTunesView view;
    EyeTunesDao dao;

    public EyeTunesController(EyeTunesView view, EyeTunesDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() throws EyeTunesDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        listSongs();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        addSong();
                        break;
                    case 4:
                        removeSong();
                        break;
                    case 5:
                        edit();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        displayUnknownCommand();
                }
            }
        } catch (EyeTunesDaoException e) {
            view.displayError(e.getMessage());
        }
        displayExit();
    }

    private int getMenuSelection() {
        return view.printMenuGetSelection();
    }

//    private void listSongs() throws EyeTunesDaoException {
//        view.displayAllSongsBanner();
//        List<Song> songs = dao.listSongs();
//        view.displayAllSongs(songs);
//    }
    
    private void listSongs() throws EyeTunesDaoException {
        view.displayAllSongsBanner();
        Map<String, List<Song>> songs = dao.listSongs();
        view.displayAllSongs(songs);
    }

    private void searchSongs() throws EyeTunesDaoException {
        String title = view.getSong();
        if (dao.checkSongExists(title)) {
            Song song = dao.getSong(title);
            view.displaySong(song);
        } else {
            view.songDoesNotExist();
        }
    }
    
    private void searchArtist() throws EyeTunesDaoException {
        String artist = view.getArtist();
        List<Song> songs = dao.getSongsByArtist(artist);
        view.displayAllSongs(songs);
    }

    private void searchAlbum() throws EyeTunesDaoException {
        String album = view.getAlbum();
        List<Song> songs = dao.getSongsByAlbum(album);
        view.displayAllSongs(songs);
    }
    
    private void searchGenre() throws EyeTunesDaoException {
        String genre = view.getGenre();
        Map<String, List<Song>> songs = dao.getSongsByGenre(genre);
        view.displayAllSongs(songs);
    }

    private void searchAge() throws EyeTunesDaoException {
        int years = view.getAge();
        Map<String, List<Song>> ageList = dao.getSongsOlderThan(years);
        view.displayAllSongs(ageList);
    }
    
    private void search() throws EyeTunesDaoException {
        int menuChoice = view.printSearchMenuGetSelection();
        switch (menuChoice) {
            case 1:
                searchArtist();
                break;
            case 2:
                searchAlbum();
                break;
            case 3:
                searchSongs();
                break;
            case 4:
                searchGenre();
                break;
            case 5:
                searchAge();
                break;
            default:
        }
    }

    private void addSong() throws EyeTunesDaoException {
        view.displayAddSongBanner();
        Song song = view.getNewSongInfo();
        dao.addSong(song.getTitle(), song);
        view.displayAddSuccessBanner();
    }

    private void removeSong() throws EyeTunesDaoException {
        view.displayRemoveSongBanner();
        String title = view.getSong();
        if (dao.checkSongExists(title)) {
            dao.removeSong(title);
            view.displayRemoveSuccessBanner();
        } else {
            view.songDoesNotExist();
        }
    }

     private void edit() throws EyeTunesDaoException {
        String songTitle = view.getSong();
        if (dao.checkSongExists(songTitle)) {
            Song songToEdit = dao.getSong(songTitle);
            view.displaySong(songToEdit);
            int menuChoice = view.printEditMenuGetSelection();
            switch (menuChoice) {
                case 1:
                    editArtist(songToEdit);
                    break;
                case 2:
                    editAlbum(songToEdit);
                    break;
                case 3:
                    editReleaseDate(songToEdit);
                    break;
                case 4:
                    editGenre(songToEdit);
                    break;
                case 5:
                    editPrice(songToEdit);
                    break;
                case 6:
                    break;
            }
            dao.saveEdits(songToEdit);
        } else {
            view.songDoesNotExist();
        }
    }
     
    private void editArtist(Song songToEdit) throws EyeTunesDaoException {
        String edit = view.getEdit();
        songToEdit.setArtistName(edit);
        view.displayEditSuccessBanner();
    }

    private void editAlbum(Song songToEdit) {
        String edit = view.getEdit();
        songToEdit.setAlbumTitle(edit);
        view.displayEditSuccessBanner();
    }

    private void editReleaseDate(Song songToEdit) throws EyeTunesDaoException {
        String edit = view.getEditedDate();
        songToEdit.setReleaseDate(edit);
        view.displayEditSuccessBanner();
    }

    private void editGenre(Song songToEdit) {
        String edit = view.getEdit();
        songToEdit.setGenre(edit);
        view.displayEditSuccessBanner();
    }

    private void editPrice(Song songToEdit) {
        String edit = view.getEdit();
        songToEdit.setSongPrice(edit);
        view.displayEditSuccessBanner();
    }

    private void displayUnknownCommand() {
        view.displayUnknownCommand();
    }

    private void displayExit() {
        view.displayExitBanner();
    }
}
