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
    public void solve(ArrayList<Location> locations) {
        for (Location a : locations) {
            for (Location b : locations) {

            }
        }
    }

    private double calculateDistance(Location locationA, Location locationB) {
        double distA;
        double distB;
        if (locationA.getPositionX() > locationB.getPositionX()) {
            distA = locationA.getPositionX() - locationB.getPositionX();
        } else {
            distA = locationB.getPositionX() - locationA.getPositionX();
        }
        if (locationA.getPositionY() > locationB.getPositionY()) {
            distB = locationA.getPositionY() - locationB.getPositionY();
        } else {
            distB = locationB.getPositionY() - locationA.getPositionY();
        }
        return Math.sqrt(Math.pow(distA, 2) + Math.pow(distB, 2));
    }

    public Location findNearest(ArrayList<Location> neighbours, Location a) {
        Location nearest = null;
        double distance = 999999999;
        for (Location s : neighbours) {
            if (this.calculateDistance(a, s) < distance) {
                distance = this.calculateDistance(a, s);
                nearest = s;
            }
        }
        return nearest;
    }
}
