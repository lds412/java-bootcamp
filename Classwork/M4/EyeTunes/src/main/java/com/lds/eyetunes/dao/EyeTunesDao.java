/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.eyetunes.dao;

import com.lds.eyetunes.dto.Song;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lydia
 */
public interface EyeTunesDao {
    
    Song addSong(String title, Song song) throws EyeTunesDaoException;
    
    Song removeSong(String title) throws EyeTunesDaoException;
    
    Song saveEdits(Song song) throws EyeTunesDaoException;
    
    Map<String, List<Song>> listSongs() throws EyeTunesDaoException;
    
    Song getSong(String title) throws EyeTunesDaoException;
    
    boolean checkSongExists(String songTitle) throws EyeTunesDaoException;
    
    List<Song> getSongsByArtist(String artist) throws EyeTunesDaoException;
    
    List<Song> getSongsByAlbum(String album) throws EyeTunesDaoException;
    
    Map<String, List<Song>> getSongsByGenre(String genre) throws EyeTunesDaoException;
    
    Map<String, List<Song>> getSongsOlderThan(int years) throws EyeTunesDaoException;
}
