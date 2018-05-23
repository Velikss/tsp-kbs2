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
public class Twoopt extends Algorithm {

    private ArrayList<Location> currentRoute = new ArrayList<Location>();

    public Twoopt() {
        super.setName("Two-opt Algorithm");
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        time = System.nanoTime();
        System.out.println("time: " + time);
        currentRoute.addAll(locations);

        while(!twoOpt()){
            System.out.println("test");}
        System.out.println("TSP -> 2-Opt result:");
        System.out.println(currentRoute);

        this.result = new Route(currentRoute, this.getName(), this.time);
        return result;
    }
    
    public boolean twoOpt() {
        boolean improved = false;
        int size = currentRoute.size();

        for (int i = 1; i < size - 1; i++) {
            System.out.println("First loop: " + i);
            for (int j = 1; j < size - 1; j++) {
                System.out.println("Second loop: " + j);
                double d = getTotalDistance(currentRoute);
                swap(i, j);
                double d2 = getTotalDistance(currentRoute);
                if (d < d2) {
                    swap(i, j);
                } else {
                    improved = true;
                }
            }
        }
        if (improved) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int i, int j) {
        System.out.println("Swapping...");
        int ix = currentRoute.get(i).getPositionX();
        int iy = currentRoute.get(i).getPositionY();
        currentRoute.get(i).setPositionX(currentRoute.get(j).getPositionX());
        currentRoute.get(i).setPositionY(currentRoute.get(j).getPositionY());
        currentRoute.get(j).setPositionX(ix);
        currentRoute.get(j).setPositionY(iy);
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
