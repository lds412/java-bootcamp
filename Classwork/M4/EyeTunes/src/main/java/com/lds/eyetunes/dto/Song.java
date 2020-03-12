/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.eyetunes.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author lydia
 */
public class Song {

    private String title;
    private String genre;
    private String artistName;
    private String songPrice;
    private String releaseDate;
    private String albumTitle;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongPrice() {
        return songPrice;
    }

    public void setSongPrice(String bigDecimal) {
        this.songPrice = bigDecimal;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String localDate) {
        this.releaseDate = localDate;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public long getSongAge() {
        LocalDate reld = LocalDate.parse(releaseDate);
        Period p = reld.until(LocalDate.now());
        return p.getYears();
    }
}
