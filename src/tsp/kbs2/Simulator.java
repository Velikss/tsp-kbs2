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

/**
 *
 * @author Felix
 */
public class Simulator {

    private ArrayList<Location> locations = new ArrayList<Location>();
    private ArrayList<Algorithm> algorithms = new ArrayList<Algorithm>();
    private ArrayList<Route> routes = new ArrayList<Route>();
    ArrayList<ArrayList<Route>> simulations;
    private int X;
    private int Y;
    private int points;
    private String filePath, fileName, fileError;
    boolean FileNotFoundException;

    public Simulator() {
        this.X = 15;
        this.Y = 15;
        this.points = 5;

        Screen s = new Screen(this);
    }

    public void generateLocations(int X, int Y, int amount) {
        this.locations.clear();
        System.out.println("Generating locations... " + locations);
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
        System.out.println("Generated: " + locations);
    }

    public void simStart() {
            this.generateLocations(X, Y, points);
            routes.clear();
            for (Algorithm a : algorithms) {
                routes.add(a.solve(locations));
            }

            ArrayList<Route> results = (ArrayList<Route>) routes.clone();
            simulations.add(results);
    }

    public void exportResults() {
        FileNotFoundException = false;
        fileName = "Results-"
                + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
                        .format(new Date());
        filePath = "C:\\Users\\Felix\\Documents\\NetBeansProjects"
                    + "\\tsp-kbs2\\Results\\"
                    + fileName + ".json";
        try {
            PrintWriter writer = new PrintWriter(filePath);
            writer.println("{");
            int sizeSimulations = simulations.size();
            for (int j = 0; j < sizeSimulations; j++) {
                writer.println("    \"Iteration " + (j + 1) + "\" : [{");
                int sizeR = simulations.get(j).size();
                for (int i = 0; i < sizeR; i++) {
                    Route r = simulations.get(j).get(i);
                    writer.println("       \"name\": \"" + r.getName() + "\",");
                    writer.println("       \"route\": " + r.getRoute() + ",");
                    writer.println("       \"time (ms)\": \"" + r.getTime() + "\",");
                    writer.println("       \"distance\": \"" + r.getDistance() + "\"");
                    if (i < sizeR - 1) {
                        writer.println("        }, {");
                    }
                }
                if (j < sizeSimulations - 1) {
                    writer.println("        }],");
                }
                if (j == sizeSimulations - 1) {
                    writer.println("        }]");
                }
            }
            writer.println("}");
            writer.close();
        } catch (FileNotFoundException ex) {
            FileNotFoundException = true;
            fileError = "Error -> File could not be created " + ex.getMessage();
            System.out.println(fileError);
        }
    }

    public Route getRoute(int a) {
        return this.routes.get(a);
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
        return routes;
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

    public String getFilePath() {
        return filePath;
    }
    
    public String getFileError() {
        return fileError;
    }
    
    public ArrayList<Algorithm> getAlgorithms() {
        return algorithms;
    }

    public void newAlgorithms(ArrayList<Algorithm> newAlgorithms) {
        this.algorithms = newAlgorithms;
    }
    
    public void newSimulations() {
//        simulations.clear();
        simulations = new ArrayList<ArrayList <Route>>();
    }

}
