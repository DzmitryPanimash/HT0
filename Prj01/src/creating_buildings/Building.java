package creating_buildings;

import java.util.ArrayList;

public class Building {

    private int numberOfRooms = 0;
    private ArrayList<Room> allRooms = new ArrayList<>();

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void addRoom(String nameOfRoom, int area, int numberOfWindows){

        Room room = new Room (nameOfRoom, area, numberOfWindows);
        allRooms.add(room);
        numberOfRooms++;
    }

   // public Room getRoom (String name) {


   // }

    public void describe(){

    }

}

