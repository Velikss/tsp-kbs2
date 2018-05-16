/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felix
 */
public class Simulator {

    private ArrayList<Location> locations = new ArrayList<Location>();
    private ArrayList<Algorithm> algorithms = new ArrayList<Algorithm>();
    private ArrayList<Route> results = new ArrayList<Route>();
    private int X;
    private int Y;
    private int points;

    public Simulator() {
        this.X = 13;
        this.Y = 13;
        this.points = 5;
        this.generateLocations(12, 12, 5);
        results.add(new Route(locations));
        this.algorithms.add(new NearestNeighbour());
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

    public void generateLocations(int X, int Y, int amount) {
        if (locations.size() != 0) {
            this.locations.clear();
        }
        for (int i = 0; i <= amount; i++) {
            int randomX = (int) (Math.random() * (X - 1) + 2);
            int randomY = (int) (Math.random() * (Y - 1) + 2);
            Location newRandom = new Location(randomX, randomY);
            locations.add(newRandom);
        }
    }

    public void simStart(ArrayList<Algorithm> algorithms) {
        ArrayList<Route> results = new ArrayList<Route>();
        for (Algorithm a : algorithms) {
            results.add(a.solve(locations));
        }
        this.results = results;
    }

    public void setAmount(int amount) {
        this.points = amount;
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public ArrayList<Route> getResults() {
        return results;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    public int getPoints() {
        return points;
    }

    public ArrayList<Algorithm> getAlgorithms() {
        return algorithms;
    }
    
    
    
    
}
