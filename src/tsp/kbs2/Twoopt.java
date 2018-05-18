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

    public Twoopt() {
        super.setName("Two-opt Algorithm");
    }

    @Override
    public Route solve(ArrayList<Location> locations) {
        time = System.nanoTime();
        ArrayList<Location> currentSolution = new ArrayList<>();
        currentSolution.addAll(locations);
        int size = currentSolution.size();
        for (int i = 0; i < size; i++) {
            for (Location loc : locations) {

            }
        }
        return result;
    }

}
