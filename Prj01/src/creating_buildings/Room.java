package creating_buildings;

public class Room extends Building {
    private int area;
    private int numberOfWindows;
    private String nameOfRoom;
    private int illumination;
    private int numberOfBulb;


    //constructor
    Room(String nameOfRoom, int area, int numberOfWindows){
        this.nameOfRoom = nameOfRoom;
        this.area = area;
        this.numberOfWindows = numberOfWindows;

    }

    //setters and getters

    public void setArea (int area) {
        this.area = area;
    }

    public int getArea(){
        return area;
    }

    public void setNumberOfWindows (int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setIllumination() {
        this.illumination = (this.numberOfWindows * 700);
    }

    public int getIllumination() {
        return illumination;
    }

    public void setNameOfRoom(String nameOfRoom) {
        this.nameOfRoom = nameOfRoom;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }
}
