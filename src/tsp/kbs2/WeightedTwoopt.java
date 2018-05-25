package tsp.kbs2;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;

public class WeightedTwoopt extends Algorithm {

    private ArrayList<Location> currentRoute;
    private ArrayList<Double> distances;

    public WeightedTwoopt() {
        super.setName("WeightedTwoOpt");
        currentRoute = new ArrayList<>();
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        //Start timer
        time = System.nanoTime();

        currentRoute = (ArrayList<Location>) locations.clone();

        /* Calculate weight for each Location
         * Then sort Locations on their weight ascending and
         * perform twoopt on that.
         */
        calculateWeight();

        Collections.sort(currentRoute);
        currentRoute.add(0, new Location(0, 0));
        currentRoute.add(new Location(0, 0));

        Twoopt();
        
        //End timer
        time = System.nanoTime() - time;

        this.result = new Route(currentRoute, this.getName(), time);
        return result;
    }

    private void calculateWeight() {
        for (Location loc : currentRoute) {
            distances = new ArrayList<>();
            double weight = 0;
            for (Location loc2 : currentRoute) {
                if (!loc.equals(loc2)) {
                    distances.add(calculateDistance(loc, loc2));
                }
            }
            for (Double d : distances) {
                weight += d;
            }
            weight /= distances.size();
            loc.setWeight(weight);
        }
    }

    public void Twoopt() {
        int a = 0;
        for (int i = 1; i < currentRoute.size(); i++) {
            Location locA = currentRoute.get(i - 1);
            Location locB = currentRoute.get(i);

            //Checks all lines that come after line AB
            if (i <= currentRoute.size() - 1) {
                for (int j = i + 2; j < currentRoute.size(); j++) {
                    Location locC = currentRoute.get(j - 1);
                    Location locD = currentRoute.get(j);
                    if (intersect(locA, locB, locC, locD)) {
                        //Upon intersect swap two points and reset iteration
                        swap(i, j - 1);
                        i = 1;
                    }
                    a++;
                }
            }
            //Checks all lines that come before line AB
            if (currentRoute.size() - i >= 2) {
                for (int j = 1; j < i - 1; j++) {
                    Location locC = currentRoute.get(j - 1);
                    Location locD = currentRoute.get(j);
                    if (intersect(locA, locB, locC, locD)) {
                        //Upon intersect swap two points and reset iteration
                        swap(i - 1, j);
                        i = 1;
                    }
                    a++;
                }
            }
            if (a > 500000000) {
                System.out.println("INFINIT LOOP DETECTED");
                break;
            }
        }
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

    public boolean intersect(Location locA, Location locB, Location locC, Location locD) {
        int x1 = locA.getPositionX();
        int y1 = locA.getPositionY();
        int x2 = locB.getPositionX();
        int y2 = locB.getPositionY();
        int x3 = locC.getPositionX();
        int y3 = locC.getPositionY();
        int x4 = locD.getPositionX();
        int y4 = locD.getPositionY();

        if (Line2D.linesIntersect(x1, y1, x2, y2, x3, y3, x4, y4)) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int i, int j) {
        Location zero = new Location(0, 0);
        if (currentRoute.get(i).equals(zero)) {
            i -= 1;
        }
        if (currentRoute.get(j).equals(zero)) {
            j -= 1;
        }
//        int ix = currentRoute.get(i).getPositionX();
//        int iy = currentRoute.get(i).getPositionY();
//        currentRoute.get(i).setPositionX(currentRoute.get(j).getPositionX());
//        currentRoute.get(i).setPositionY(currentRoute.get(j).getPositionY());
//        currentRoute.get(j).setPositionX(ix);
//        currentRoute.get(j).setPositionY(iy);

        Collections.swap(currentRoute, i, j);
    }
}
