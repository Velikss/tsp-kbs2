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

        //Algorithm
        ArrayList<Location> route = new ArrayList<>();
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

}
