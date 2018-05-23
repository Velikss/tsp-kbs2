/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Felix
 */
public class Bruteforce extends Algorithm {

    private ArrayList<Location> newBestRoute = new ArrayList<Location>();

    public Bruteforce() {
        super.setName("Bruteforce algorithm");
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        //Start timer
        time = System.nanoTime();

        int options = calculateOptions(locations.size());

        //Algorithm
        loop(locations, locations.size());
        this.result = new Route(newBestRoute, this.getName(), this.time);
        return result;
    }

    public void loop(ArrayList<Location> locations, int a) {
        double distance = 999999999;
        if (a == 1) {
            return;
        }
        for (int i = 0; i < a; i++) {
            Collections.swap(locations, i, a - 1);
            
            if(getTotalDistance(locations) < distance) {
                newBestRoute = locations;
                distance = getTotalDistance(locations);
            }
            
            loop(locations, a - 1);
            
            Collections.swap(locations, i, a - 1);
            
            if(getTotalDistance(locations) < distance) {
                newBestRoute = locations;
                distance = getTotalDistance(locations);
            }
        }
        this.distance = distance;
    }

    public int calculateOptions(int points) {
        int factorial = 1;

        for (int i = 1; i <= points; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private double calculateDistance(Location locA, Location locB) {
        double distA;
        double distB;
        if (locA.getPositionX() > locB.getPositionX()) {
            distA = locA.getPositionX() - locB.getPositionX();
        } else {
            distA = locB.getPositionX() - locA.getPositionX();
        }
        if (locA.getPositionY() > locB.getPositionY()) {
            distB = locA.getPositionY() - locB.getPositionY();
        } else {
            distB = locB.getPositionY() - locA.getPositionY();
        }
        return Math.sqrt(Math.pow(distA, 2) + Math.pow(distB, 2));
    }

    private double getTotalDistance(ArrayList<Location> route) {
        double totalDistance = 0;

        for (int i = 0; i < route.size() - 1; i++) {
            totalDistance += calculateDistance(route.get(i), route.get(i + 1));
        }
        this.distance = totalDistance;
        return distance;
    }

}
