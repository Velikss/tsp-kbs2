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

    public NearestNeighbour() {
        super.setName("Nearest Neighbour Algorithm");
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        int size = locations.size();
        //Start timer        
        time = System.nanoTime();
        
        //Algorithm        
        ArrayList<Location> route = new ArrayList<>();
        //Add start location
        Location startLocation = new Location (0, 0);
        route.add(startLocation);
        
        for (int i = 0; i < size; i++) {
            Location nearest = findNearest(locations, route.get(i));
            route.add(nearest);
            locations.remove(nearest);
        }
        //Add end location        
        route.add(new Location(0, 0));
        
        //End timer        
        time = (System.nanoTime() - time) / 1000000;
        System.out.println("Nearest Neighbour route: " + route + "Size: " + (route.size()-2));
//        System.out.println("Tijd:" + time);
        
        Route result = new Route(route);
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
