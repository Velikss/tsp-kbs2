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
public class Route {
    
    private ArrayList<Location> route;
    private double distance;
    private long time;
    private String name;
    
    public Route(ArrayList<Location> route, String name, long time) {
        this.name = name;
        this.route = route;
        this.time = time;
        getTotalDistance(route);
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

    private void getTotalDistance(ArrayList<Location> route) {
        double totalDistance = 0;

        for (int i = 0; i < route.size()-1; i++) {
            totalDistance += calculateDistance(route.get(i), route.get(i+1));
        }
        this.distance = totalDistance;
    }
    
    public ArrayList<Location> getRoute() {
        return route;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public long getTime() {
        return time;
    }
    
    
    
    
}
