package creating_buildings;

import java.util.ArrayList;

public class Building implements ValidAndDescribe{

    private int numberOfRooms = 0;
    public ArrayList<Room> allRooms = new ArrayList<>();
    private int indexOfRooms; //this variable is for returning of the rooms from the collection

    public int getNumberOfRooms() {
        return numberOfRooms;
    }


    public void addRoom(String nameOfRoom, int area, int numberOfWindows) throws Exception {
        if (checkingNameOfRoom(nameOfRoom)) {
            throw new Exception("This name has already set. Please, choose another name.");
        } else {

            Room room = new Room(nameOfRoom, area, numberOfWindows);
            allRooms.add(room);
            numberOfRooms++;
        }
    }

    public Room getRoom(String name) throws Exception {

        if (checkingNameOfRoom(name)) {
           return allRooms.get(indexOfRooms);
        }
        else {
            throw new Exception("There are no such rooms!");
        }

    }


    //this function helps to find out, does the room exist?
    public boolean checkingNameOfRoom(String name) {

        if(allRooms.isEmpty()){
            return false;
        }

        for (int i = 0; i < allRooms.size(); i++) {

            if (name.equalsIgnoreCase(allRooms.get(i).getNameOfRoom())) {

                this.indexOfRooms = i;
                return true;

            }

        }
        return false;
    }

    @Override
    public boolean isValid() throws Exception {

        for (Room room: allRooms) {

            if (room.isValid()) {
            } else{
                return false;

            }

}
        return true;
    }

    public void describe() throws Exception{
        this.isValid();
        System.out.println("This building has " + this.getNumberOfRooms() + " room(s): ");
        for (Room room: allRooms) {
            room.describe();
        }

    }
}
