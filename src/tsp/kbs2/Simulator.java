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
        this.points = 6;
        
        this.generateLocations(this.X, this.Y, this.points);
        results.add(new Route(locations));

        Screen s = new Screen(this);
    }

    public void generateLocations(int X, int Y, int amount) {
        if (locations.size() != 0) {
            this.locations.clear();
        }
        for (int i = 1; i <= amount; i++) {
            int randomX = (int) (Math.random() * (X - 1) + 2);
            int randomY = (int) (Math.random() * (Y - 1) + 2);
            Location newRandom = new Location(randomX, randomY);
            System.out.println(i + " : " + newRandom);
            locations.add(newRandom);
        }
        System.out.println(locations + " : " + locations.size());
    }

    public void simStart(ArrayList<Algorithm> algorithms) {
        ArrayList<Route> results = new ArrayList<Route>();
        this.generateLocations(X, Y, points);
        for (Algorithm a : algorithms) {
            results.add(a.solve(locations));
        }
        this.results = results;
    }
    
    public Route getRoute(int a){
        return this.results.get(a);
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
