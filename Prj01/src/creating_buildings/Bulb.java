package creating_buildings;

public class Bulb extends Things {
    private int bulbIllumination;
    private String name = "Light bulb";

    //constructor

  public Bulb( int bulbIllumination) throws IllegalArgumentException {
      if(bulbIllumination <= 0) {
          throw new IllegalArgumentException("The illumination of bulbs cannot be zero or less than zero!");
      } else{
      setBulbIllumination(bulbIllumination);
      }
  }

  //getters and setters


    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
      return this.name;
    }

    public void setBulbIllumination(int bulbIllumination) {
        this.bulbIllumination = bulbIllumination;
    }

    public int getBulbIllumination() {
        return this.bulbIllumination;
    }

    @Override
    public void describeThing() {
        System.out.print("[" + this.getBulbIllumination() + " lx]");
    }
}
