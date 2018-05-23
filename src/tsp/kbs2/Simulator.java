/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        this.X = 5;
        this.Y = 5;
        this.points = 4;

        this.generateLocations(this.X, this.Y, this.points);
        results.add(new Route(locations, "test", 0));
        results.add(new Route(locations, "test", 0));
        results.add(new Route(locations, "test", 0));
        results.add(new Route(locations, "test", 0));

        algorithms.add(new NearestNeighbour());
        algorithms.add(new NearestNeighbour());
        algorithms.add(new NearestNeighbour());
        algorithms.add(new NearestNeighbour());

        Screen s = new Screen(this);
    }

    public void generateLocations(int X, int Y, int amount) {
        this.locations.clear();

        for (int i = 1; i <= amount; i++) {
            boolean alreadyExists = false;
            int randomX = (int) (Math.random() * (X - 1) + 1.5);
            int randomY = (int) (Math.random() * (Y - 1) + 1.5);
            Location newRandom = new Location(randomX, randomY);

            for (Location a : locations) {
                if (newRandom.equals(a)) {
                    alreadyExists = true;
                }
            }

            if (alreadyExists) {
                i--;
            } else {
                locations.add(newRandom);
            }
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

    public void generateResults() {
        String fileName = "Results-"
                + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
                        .format(new Date());
        try {
            PrintWriter writer = new PrintWriter(
                    "C:\\Users\\Felix\\Documents\\NetBeansProjects"
                    + "\\tsp-kbs2\\Results\\"
                    + fileName + ".json");
            writer.println("[");
            for (Route r : results) {
                writer.println("    {");
                writer.println("       \"name\": " + r.getName() + ",");
                writer.println("       \"route\": " + r.getRoute() + ",");
                writer.println("       \"time\": " + r.getTime() + ",");
                writer.println("       \"distance\": " + r.getDistance() + ",");
                writer.println("    },");
            }
            writer.println("]");
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error -> File could not be created " + ex.getMessage());
        }
    }

    public Route getRoute(int a) {
        return this.results.get(a);
    }

    public void setPoints(int amount) {
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
