package creating_buildings;

public class Main {

    public static void main (String[] args) {

        Building building = new Building();
        building.addRoom("Bedroom", 100, 3);

        System.out.println(building.getNumberOfRooms());





    }
}

