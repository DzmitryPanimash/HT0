package creating_buildings;



public class Main {

    public static void main (String[] args) throws Exception {

        Building building = new Building();

        building.addRoom("Bedroom", 100, 3);
        building.addRoom("Bathroom", 30, 2);
        building.addRoom("Living room", 70, 6);


        building.getRoom("Bedroom").addBulb(250);
        building.getRoom("Bedroom").addBulb(550);
        building.getRoom("Bedroom").addBulb(250);
        building.getRoom("Bathroom").addBulb(1500);
        building.getRoom("Living room").addBulb(250);
        building.getRoom("Living room").addBulb(250);

        building.getRoom("Bedroom").addFurniture("Table", 2, 3);
        building.getRoom("Bedroom").addFurniture("Bed", 4, 8);
        building.getRoom("Bathroom").addFurniture("Bath", 4, 4);
        building.getRoom("Bathroom").addFurniture("Elevator", 2, 3);
        building.getRoom("Living room").addFurniture("TV", 2, 2);
        building.getRoom("Living room").addFurniture("Sofa", 6, 10);

        building.getRoom("Living room").deleteWindow();

        building.getRoom("Living room").addBulb(350);

        building.getRoom("Living room").deleteBulb(350);

        building.getRoom("Living room").deleteFurniture("Sofa");



        building.describe();
    }
}

