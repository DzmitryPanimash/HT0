package mp3_manager;

import com.webfirmframework.wffweb.tag.html.Body;
import com.webfirmframework.wffweb.tag.html.Html;
import com.webfirmframework.wffweb.tag.html.metainfo.Head;
import com.webfirmframework.wffweb.tag.htmlwff.NoTag;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class HTMLwriter {


    public void createHtmlDoc(ArrayList<Artist> artists){
    Html html = new Html(null);
    Head head = new Head(html);
    new NoTag(head, "<title> Your Mp3 collection </title> ");
    Body body = new Body(html);

        for (Artist artist : artists) {
          new NoTag(body, "<h2> Artist: " +  artist.getArtistName() + "</h2> " );


            for(Album album : artist.getArtistAlbums()){
                new NoTag(body, "<h3> Album: " +  album.getAlbumName() + "</h3> " );
                new NoTag(body, "<ol>" );

                for(Song song : album.getAlbumSongs()){

                    new NoTag(body, "<li> Title: " + song.getSongName()+ ". Duration: " +
                     getClearDuration(song.getSongDuration(), "min") + " min " + getClearDuration(song.getSongDuration(), "sec") +
                     " sec. (Path: " +  song.getSongPath() + ") </li>");

                }
                new NoTag(body, "</ol>" );
            }
        }
        html.setPrependDocType(true);

        try {
            html.toOutputStream(new FileOutputStream("./result.html"), "UTF-8");
        } catch (IOException err) {
            System.out.print(err.getMessage());
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
