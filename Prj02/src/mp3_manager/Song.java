package mp3_manager;

public class Song {
    private String songName;
    private String songDuration;
    private String songPath;

//constructor
    public Song(String songName, String songDuration, String songPath) {
        if (songName == null || songName.equals("")) {
            this.songName = "Unknown song";
        } else
            {
        this.songName = songName;
            }

        this.songDuration = songDuration;
        this.songPath = songPath;
    }

    //getters
    public String getSongName() {
        return songName;
    }
    public String getSongDuration() {
        return songDuration;
    }
    public String getSongPath() {
        return songPath;
    }
}