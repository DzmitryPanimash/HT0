package mp3_manager;

import java.util.ArrayList;

public class Artist {
    private String artistName;
    private ArrayList<Album> artistAlbums = new ArrayList();

    //constructor
    public Artist(String artistName) {
        if (artistName == null || artistName.equals("")) {
            this.artistName = "Unknown artist";
        } else{
        this.artistName = artistName;
        }
    }

    //getters
    public String getArtistName() {
        return artistName;
    }
    public ArrayList<Album> getArtistAlbums() {
        return artistAlbums;
    }


    public void setAlbum(String albumName, String songName, String songDuration, String songPath) {

        if (hasSuchAlbum(albumName)) {
            getAlbum(albumName).setSong(songName, songDuration, songPath);

        } else{
            Album album = new Album(albumName);
            artistAlbums.add(album);
            album.setSong(songName, songDuration, songPath);

    }
    }


    public boolean hasSuchAlbum(String albumName) {

        for (Album i : artistAlbums)
            if (i.getAlbumName().equalsIgnoreCase(albumName)) {
                return true;
        }
        return false;
    }


    public Album getAlbum(String albumName) {

        for (Album album : artistAlbums) {
            if (album.getAlbumName().equalsIgnoreCase(albumName)) {
                return album;
            }
        }
        return null;
    }



}

