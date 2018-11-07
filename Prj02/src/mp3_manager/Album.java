package mp3_manager;

import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Song> albumSongs = new ArrayList<>();


    //constructor
    public Album(String nameAlbum) {
        if (nameAlbum == null || nameAlbum.equals("")) {
            this.albumName = "Unknown album";
        } else {
        this.albumName = nameAlbum;
        }
    }

    //getters
    public String getAlbumName() {
        return albumName;
    }
    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }



    public void setSong (String songName, String songDuration, String songPath){
        Song song = new Song(songName, songDuration,songPath);
        this.albumSongs.add(song);
    }
}

