/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Felix
 */
public class Bruteforce extends Algorithm {
    private ArrayList<Location> allLocs;
    private ArrayList<Location> bestRoute;
    private int total =0;

    public Bruteforce() {
        super.setName("Bruteforce algorithm");
        allLocs = new ArrayList<>();
        bestRoute = new ArrayList<>();
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        //Start timer
        time = System.nanoTime();

        int options = calculateOptions(locations.size());

        //Algorithm
        this.result = new Route(loop(locations), this.getName(), this.time);
        System.out.println("BRUTEFORCE" + result.getRoute());
        return result;
    }

    private ArrayList<Location> loop(ArrayList<Location> locations) {
        allLocs = locations;
        for(int i=0; i<locations.size(); i++){
            ArrayList<Location> route = new ArrayList<>();
            route.add(new Location(0,0));
            checkRoute(route, i);
        }

//        System.out.println(calculateOptions(allLocs.size()));
//        System.out.println(total);
        return bestRoute;
    }

    private void checkRoute(ArrayList<Location> route, int offset){
        ArrayList<Location> thisRoute = (ArrayList<Location>) route.clone();
        thisRoute.add(allLocs.get(offset));
        if(thisRoute.size() == allLocs.size()+1){
            total++;
            thisRoute.add(new Location(0,0));
            if(bestRoute.size() != 0){
                if(getTotalDistance(bestRoute) > getTotalDistance(thisRoute)){
                    bestRoute = (ArrayList<Location>) thisRoute.clone();
                    return;
                }
            }else{
                bestRoute = (ArrayList<Location>) thisRoute.clone();
                return;
            }
        }

        for(int i=0; i<allLocs.size(); i++){
            if(!thisRoute.contains(allLocs.get(i))){
                checkRoute(thisRoute, i);
            }
        }
    }

    private int calculateOptions(int points) {
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
