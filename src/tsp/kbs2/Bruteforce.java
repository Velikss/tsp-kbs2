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
public class Bruteforce extends Algorithm {

    public Bruteforce() {
        super.setName("Bruteforce algorithm");
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        //Start timer
        time = System.nanoTime();

        ArrayList<Location> route = new ArrayList<>();

        int options = calculateOptions(locations.size());

        //Algorithm
        for (int i = 1; i < options; i++) {
            
        }
        //Add start location
        Location startLocation = new Location(0, 0);
        route.add(startLocation);
        return result;
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

        for (int i = 0; i < route.size(); i++) {
            totalDistance += calculateDistance(route.get(i), route.get(i+1));
        }
        this.distance = totalDistance;
        return distance;
    }

}
