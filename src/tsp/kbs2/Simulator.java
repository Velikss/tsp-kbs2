/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class Simulator {

    private ArrayList<Location> locations = new ArrayList<>();

    public Simulator() {
        Screen s = new Screen(this);
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Location> getLocations() {
        ArrayList<Location> lokaties = new ArrayList<Location>();
        Location een = new Location(5, 2);
        Location twee = new Location(10, 7);
        Location drie = new Location(7, 7);

        lokaties.add(een);
        lokaties.add(twee);
        lokaties.add(drie);
        return lokaties;
    }

    public ArrayList<Location> generateLocations(int X, int Y, int amount) {
        if (locations.size() != 0) {
            this.locations.clear();
        }
        for (int i = 0; i <= amount; i++) {
            int randomX = (int) (Math.random() * (X - 1) + 2);
            int randomY = (int) (Math.random() * (Y - 1) + 2);
            Location newRandom = new Location(randomX, randomY);
            locations.add(newRandom);
        }
        return locations;
    }
}
