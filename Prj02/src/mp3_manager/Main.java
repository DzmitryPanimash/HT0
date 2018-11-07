package mp3_manager;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileExtension = ".mp3";
        ArrayList<String> containerForPaths = new ArrayList<>();

        if(args.length == 0) {
            System.out.println("Please, enter your directory(ies) with mp3 files!");
            return;
        }

        for (String directory : args) {

            File file = new File(directory);
            if (!file.exists()) {

                System.out.println("This path " + directory + " is invalid!");
                return;

            } else {
                getPaths(file, containerForPaths, fileExtension);
            }
        }

        if(containerForPaths.size() == 0) {
            System.out.println("Sorry, your music collection doesn't have any mp3 :(");
            return;
        }

        TagsReader reader = new TagsReader();
        reader.getInfoFromFiles(containerForPaths);
       // reader.printData();
        HTMLwriter writer = new HTMLwriter();
        writer.createHtmlDoc(reader.getArtists());

    }


        static void getPaths (File file, ArrayList<String> containerForPaths, String extension){

        File[] pathFile = file.listFiles();

        for(File tempFile : pathFile){

        if(tempFile.isDirectory()) {
            getPaths(tempFile, containerForPaths, extension);
        }
        else{

            if(tempFile.getAbsolutePath().contains(extension)){

                containerForPaths.add(tempFile.getAbsolutePath());
            }
        }

            }
    }
}

