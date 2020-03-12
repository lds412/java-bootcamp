/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.eyetunes.ui;

import com.lds.eyetunes.dto.Song;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lydia
 */
public class EyeTunesView {

    private UserIO io;

    public EyeTunesView(UserIO io) {
        this.io = io;
    }

    public int printMenuGetSelection() {
        io.print("-----  eyeTunes  -----");
        io.print("");
        io.print("1. List All Songs");
        io.print("2. Search For Songs");
        io.print("3. Add New Song");
        io.print("4. Remove Song");
        io.print("5. Edit Existing Song");
        io.print("6. Exit eyeTunes");
        io.print("");
        int choice = io.readInt("Please Make A Selection From The Above Menu", 1, 6);
        io.readString("");
        return choice;
    }

    public int printSearchMenuGetSelection() {
        io.print("-----  Search Menu  -----");
        io.print("");
        io.print("1. Search By Artist");
        io.print("2. Search By Album");
        io.print("3. Search By Song Title");
        io.print("4. Search By Genre");
        io.print("5. Search By Age");
        io.print("6. Exit Search Menu");
        io.print("");
        int choice = io.readInt("Please Make A Selection From The Above Menu", 1, 6);
        io.readString("");
        return choice;
    }

    public int printEditMenuGetSelection() {
        io.print("-----  Edit Menu  -----");
        io.print("");
        io.print("1. Edit Artist Name");
        io.print("2. Edit Album Title");
        io.print("3. Edit Release Date");
        io.print("4. Edit Genre");
        io.print("5. Edit Price");
        io.print("6. Exit Search Menu");
        io.print("");
        int choice = io.readInt("Please Make A Selection From The Above Menu", 1, 6);
        io.readString("");
        return choice;
    }

    public String getArtist() {
        return io.readString("Enter The Artist You Would Like: ");
    }

    public String getAlbum() {
        return io.readString("Enter The Album You Would Like: ");
    }

    public String getSong() {
        return io.readString("Enter The Song You Would Like: ");
    }

    public String getGenre() {
        return io.readString("Enter The Genre You Would Like: ");
    }
    
    public int getAge() {
        return io.readInt("Enter The Minimum Age Of Songs You Would Like: ");
    }
    
    public String getEdit() {
        return io.readString("Enter The New Information: ");
    }

    public String getEditedDate(){
        return io.readDate("Please Enter Release Date (Must be in MM/DD/YYYY format)");
    }
    
    public void songDoesNotExist(){
        io.print("This Song Does Not Exist");
    }
    
    //Get song info, create new song object
    public Song getNewSongInfo() {
        String title = io.readString("Please Enter Song Title");
        String releaseDate = io.readDate("Please Enter Release Date (Must be in MM/DD/YYY format)");
        String albumTitle = io.readString("Please Enter Album Title: ");
        String artistName = io.readString("Please Enter Artist Name");
        String genre = io.readString("Please Enter Genre: ");
        String price = io.readString("Please Enter Song Price: ");
        Song newSong = new Song(title);
        newSong.setReleaseDate(releaseDate);
        newSong.setAlbumTitle(albumTitle);
        newSong.setArtistName(artistName);
        newSong.setGenre(genre);
        newSong.setSongPrice(price);
        return newSong;
    }

    public void displayAllSongs(List<Song> songs) {
        io.print("");
        for (Song currentSong : songs){
            io.print(currentSong.getTitle()+" - "+
                    currentSong.getArtistName());
        }
        io.print("");
    }

    public void displayAllSongs(Map<String, List<Song>> songs) {
        Set<String> artists = songs.keySet();
        artists.stream().forEach(artist -> 
            {  io.print("===========================");
            io.print("Artist: " + artist);
            songs.get(artist)
            .stream()
            .forEach(s -> io.print(s.getTitle()));
            });
        io.print("");
    }
    
    public void displayAlbum(String albumTitle) {
        io.print("Not Yet Implemented");
        io.print("");
    }

    public void displayArtist(String artistName) {
        io.print("Not Yet Implemented");
        io.print("");
    }

    public void displaySong(Song song) {
        io.print("\n"+song.getTitle()+" - "+song.getArtistName());
        io.print(song.getAlbumTitle()+", "+song.getReleaseDate());
        io.print(song.getGenre()+", $"+song.getSongPrice()+"\n");
    }

    public void displayAllSongsBanner() {
        io.print("-----  All Songs  -----");
    }

    public void displayAddSongBanner() {
        io.print("-----  Add Song  -----");
        io.print("");
    }

    public void displayRemoveSongBanner() {
        io.print("-----  Remove Song  -----");
        io.print("");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Song Successfully Removed From Collection. Please Hit Enter To Continue.");
    }

    public void displayAddSuccessBanner() {
        io.readString("Song Successfully Added To Collection. Please Hit Enter To Continue.");
    }

    public void displayEditSuccessBanner() {
        io.readString("Song Successfully Edited. Please Hit Enter To Continue.");
    }

    public void displayExitBanner() {
        io.print("Thank You For Using eyeTunes. Exiting.....");
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command. Returning To Main Menu...");
    }

    public void returnToMenu() {
        io.print("Returning To Main Menu...");
    }

    public void displayError(String errorMsg) {
        io.print("--ERROR--");
        io.print(errorMsg);
    }
}
