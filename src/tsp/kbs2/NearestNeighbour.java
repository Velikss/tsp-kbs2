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
public class NearestNeighbour extends Algorithm {
    
    private ArrayList<Location> currentRoute = new ArrayList<Location>();
    private ArrayList<Location> pickList = new ArrayList<Location>();

    public NearestNeighbour() {
        super.setName("Nearest Neighbour Algorithm");
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        int size = locations.size();
        pickList.addAll(locations);
        //Start timer        
        time = System.nanoTime();
        
        //Add start location
        Location startLocation = new Location(0, 0);
        currentRoute.add(startLocation);

        //Algorithm        
        for (int i = 0; i < size; i++) {
            Location nearest = findNearest(pickList, currentRoute.get(i));
            currentRoute.add(nearest);
            pickList.remove(nearest);
        }
        
        //Add end location        
        currentRoute.add(new Location(0, 0));

        //End timer        
        time = System.nanoTime() - time;

        this.result = new Route(currentRoute, this.getName(), time);
        return result;
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

    public Location findNearest(ArrayList<Location> neighbours, Location a) {
        Location nearest = null;
        double distance = 999999999;
        for (Location s : neighbours) {
            if (this.calculateDistance(a, s) != 0 && this.calculateDistance(a, s) < distance) {
                distance = this.calculateDistance(a, s);
                nearest = s;
            }
        }
        return nearest;
    }
}
