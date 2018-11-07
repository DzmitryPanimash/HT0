package creating_buildings;

import java.util.ArrayList;

public class Room extends Building implements ValidAndDescribe{
    private int area;
    private int usefulSpace;
    private int canGetSpace;
    private int numberOfWindows;
    private String nameOfRoom;
    private int illumination;
    private int numberOfBulb;

    private ArrayList<Things> bulbAndFurniture = new ArrayList<>();


    //constructor
    Room(String nameOfRoom, int area, int numberOfWindows){
       this.setNameOfRoom(nameOfRoom);
        try{
        this.setArea(area);
        this.setNumberOfWindows(numberOfWindows);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        this.setUsefulSpace(area);
        this.canGetSpace = 0;
        this.setIllumination(this.numberOfWindows);
        setNumberOfBulb(0);

    }

    //setters and getters

    public void setArea (int area) throws IllegalArgumentException{
       if(area <= 0){
           throw  new IllegalArgumentException("The area cannot be zero or less than zero!");
       } else{
        this.area = area;

       }
    }

    public int getArea(){
        return this.area;
    }

    public void setUsefulSpace(int area) {
        this.usefulSpace = area;
    }

    public int getUsefulSpace() {
        return this.usefulSpace;
    }

    public int getCanGetSpace() {
        return canGetSpace;
    }

    public void setNumberOfWindows (int numberOfWindows) throws IllegalArgumentException{
        if(numberOfWindows < 0) {
            this.numberOfWindows = 0;
            throw new IllegalArgumentException("The number of windows cannot be less than zero!");
        } else if(numberOfWindows >= 0){
        this.numberOfWindows = numberOfWindows;
        }
    }

    public int getNumberOfWindows() {
        return this.numberOfWindows;
    }

    public void setIllumination(int numberOfWindows) {
        this.illumination = numberOfWindows * 700;
    }

    public int getIllumination() {
        return this.illumination;
    }

    public void setNameOfRoom(String nameOfRoom) {
        this.nameOfRoom = nameOfRoom;
    }

    public String getNameOfRoom() {
        return this.nameOfRoom;
    }

    public void setNumberOfBulb(int numberOfBulb) {
        if(numberOfBulb == 0){
            this.numberOfBulb = numberOfBulb;
        } else {
        this.numberOfBulb = this.numberOfBulb + numberOfBulb;
        }
    }

    public int getNumberOfBulb() {
        return numberOfBulb;
    }


    //for adding of light bulbs
    public void addBulb(int bulbIllumination){

        Bulb bulb = new Bulb(bulbIllumination);
        this.bulbAndFurniture.add(bulb);
       setNumberOfBulb(1);
        this.illumination = this.illumination + bulbIllumination;

    }

    //for adding of furniture

    public void addFurniture(String name, int minArea, int maxArea){
        Furniture furniture  = new Furniture(name, minArea, maxArea);
        this.bulbAndFurniture.add(furniture);
        this.usefulSpace = this.usefulSpace -  maxArea;
        this.canGetSpace = this.canGetSpace +(maxArea - minArea);

    }

    //if you need to delete window/bulb/furniture
    public void deleteWindow(){
        if(this.numberOfWindows > 0) {
            this.numberOfWindows = this.numberOfWindows - 1;
            this.illumination = this.illumination - 700;
        } else {
            System.out.println("You can't delete the window from this room!");
        }
    }

    public void deleteBulb(int bulbIllumination){

        if(this.numberOfBulb > 0) {
            for (int i = 0; i < bulbAndFurniture.size(); i++) {

                if (bulbAndFurniture.get(i).getName().equalsIgnoreCase("Light bulb")) {
                    Bulb bulb = (Bulb) bulbAndFurniture.get(i);
                    if (bulb.getBulbIllumination() == bulbIllumination) {
                        this.illumination = this.illumination - bulb.getBulbIllumination();
                        this.numberOfBulb = this.numberOfBulb - 1;
                        bulbAndFurniture.remove(i);
                    }
                }

            }
        }else {
            System.out.println("You can't delete any bulbs from this room");
        }
    }

    public void deleteFurniture(String name){

        if(this.usefulSpace != this.area){
        for (int i = 0; i < bulbAndFurniture.size(); i++) {

            if (bulbAndFurniture.get(i).getName().equalsIgnoreCase(name)) {
                Furniture furniture = (Furniture)bulbAndFurniture.get(i);

                    this.usefulSpace = this.usefulSpace + furniture.getMaxArea();
                    this.canGetSpace = this.canGetSpace - (furniture.getMaxArea() - furniture.getMinArea());

                bulbAndFurniture.remove(i);

            }

        }
    }else{
            System.out.println("There is no furniture. You can't delete anything");
        }
    }

    //validating of the room
    @Override
   public boolean isValid () throws Exception {

        boolean valid;
        if (this.illumination < 300) {
            valid = false;
            throw new IlluminanceExceptions (this.nameOfRoom + ": this room has not enough illumination!");

        }else if (this.illumination > 4000) {
            valid = false;
            throw new IlluminanceExceptions (this.nameOfRoom +": this room has too much illumination!");

        }else valid = true;

        if(((double)this.usefulSpace / this.area) < 0.3){
            valid = false;
            throw new SpaceUsageTooMuchException (this.nameOfRoom+ ": this room has too much furniture!");

        }
        return valid;
    }

    @Override
    public void describe() throws Exception {
        this.isValid();
        System.out.println(this.nameOfRoom + ": ");
        System.out.print("The area: " + this.area + " m^2. The useful space (without furniture): " + this.getUsefulSpace() + "m^2. \n");

        if (this.usefulSpace < this.area) {
            System.out.print("The furniture takes: " + (this.area - this.getUsefulSpace()) + "m^2. You can get " + this.getCanGetSpace() + "m^2 extra space. \n");
            System.out.print("The furniture: ");

            for (int i = 0; i < bulbAndFurniture.size(); i++) {
                if (!bulbAndFurniture.get(i).getName().equalsIgnoreCase("Light bulb")) {
                    bulbAndFurniture.get(i).describeThing();
                }
            }
        }
        System.out.print("The illumination: " + this.illumination + " lx. ");
        System.out.print("The number of windows: " + this.numberOfWindows + " (700 lx for each of them). The number of light bulbs: " + this.numberOfBulb + ". ");
        if (this.numberOfBulb != 0) {
            System.out.print("Light bulbs, which are here: ");
            for (int i = 0; i < bulbAndFurniture.size(); i++) {

                if (bulbAndFurniture.get(i).getName().equalsIgnoreCase("Light bulb")) {
                    bulbAndFurniture.get(i).describeThing();
                }
            }
            System.out.print(".\n");
        }
    }

}
