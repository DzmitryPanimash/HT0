package creating_buildings;

public class Furniture extends Things {

    private String name;
    private int minArea;
    private int maxArea;

    //constructor

    public Furniture(String name, int minArea, int maxArea) {
        this.name = name;
        try {
            setMinArea(minArea);
            setMaxArea(maxArea);
        }catch (IllegalArgumentException ex) {
            System.out.println (ex.getMessage());
        }

    }

    //setters and getters


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setMinArea(int minArea) throws IllegalArgumentException{
        if(minArea <= 0) {
            throw new IllegalArgumentException("The area of furniture cannot be zero or less than zero!");
        } else{
        this.minArea = minArea;}
    }

    public int getMinArea() {
        return minArea;
    }

    public void setMaxArea(int maxArea) throws IllegalArgumentException{
        if(maxArea <= 0) {
            throw new IllegalArgumentException("The area of furniture cannot be zero or less than zero!");
        } else{
            this.maxArea = maxArea;}
    }

    public int getMaxArea() {
        return maxArea;
    }

    @Override
    public void describeThing() {
        System.out.print(this.getName() + "(max area: " + this.getMaxArea() + ", " + "min area: " + this.getMinArea() + ").\n");
    }
}
