/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Felix
 */
public class Route {

    private ArrayList<Location> route;
    private double distance;
    private double time;
    private String name;

    public Route(ArrayList<Location> route, String name, double time) {
        this.name = name;
        this.route = route;
        this.time = time / 1E6;
//        this.time = TimeUnit.MILLISECONDS.convert((long) time, TimeUnit.NANOSECONDS);
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

        for (int i = 0; i < route.size() - 1; i++) {
            totalDistance += calculateDistance(route.get(i), route.get(i + 1));
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

    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
//        return "Route{" + "route=" + route + ", name=" + name + '}';
        return name + " route: " + route;
    }

}
