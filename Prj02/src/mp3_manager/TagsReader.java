package mp3_manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class TagsReader {

    private String artistName;
    private String albumName;
    private String songName;
    private String songDuration;
    private ArrayList<Artist> artists = new ArrayList<>();


    public ArrayList<Artist> getArtists(){

        return this.artists;
    }



    public void getInfoFromFiles (ArrayList<String> containerForPaths){

        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
        Parser parser = new Mp3Parser();
        ParseContext parseCtx = new ParseContext();

        for(String songPath : containerForPaths){

            try{
                InputStream input = new FileInputStream(new File(songPath));
                parser.parse(input, handler, metadata, parseCtx);
                input.close();
            }catch (TikaException | SAXException | IOException e) {
                e.printStackTrace();
            }

            artistName = metadata.get("xmpDM:artist");
            albumName = metadata.get("xmpDM:album");
            songName = metadata.get("title");
            songDuration = metadata.get("xmpDM:duration");

            if(artists.isEmpty()){
                Artist artist = new Artist(artistName);
                artists.add(artist);
                artist.setAlbum(albumName, songName, songDuration, songPath);

            }else if(hasSuchArtist(artists, artistName)){
                getArtistFromList(artists, artistName).setAlbum(albumName, songName, songDuration, songPath);

                }else{
                Artist artist = new Artist(artistName);
                artists.add(artist);
                artist.setAlbum(albumName, songName, songDuration, songPath);
            }
        }


    }

    public Artist getArtistFromList(ArrayList<Artist> artists, String name){

        for(Artist artist : artists){
            if (artist.getArtistName().equalsIgnoreCase(name)){
                return artist;
            }
        }

        return null;
    }

    public boolean hasSuchArtist(ArrayList<Artist> artists, String name){

        for(Artist artist: artists){
            if (artist.getArtistName().equalsIgnoreCase(name)){
                return true;
            }
        }

        return false;

    }

    public void printData () {

        for (Artist artist : this.artists) {
            System.out.println("Artist: " + artist.getArtistName());

            for(Album album : artist.getArtistAlbums()){
                System.out.println("Album: " + album.getAlbumName());

                for(Song song : album.getAlbumSongs()){
                    System.out.print("Title: " + song.getSongName() + "   ");
                    System.out.print("Duration: " + getClearDuration(song.getSongDuration(), "min") + " min " + getClearDuration(song.getSongDuration(), "sec") + " sec. ");
                    System.out.println("Path: " + song.getSongPath());

                }
            }
        }
    }

    public int getClearDuration (String millis, String mask) {

        int minutes = (int) Double.parseDouble(millis) / 60000;
        int seconds = (int)((Double.parseDouble(millis) - (minutes * 60000)) / 1000);

        if (mask.equals("min")) {
            return minutes;
        } else {
            return seconds;
        }

    }

}

