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
    public void solve(ArrayList<Product> locaties) {
        long startTime = System.nanoTime() / 1000;
        ArrayList<Product> currentSolution = new ArrayList<>();
        
        for (Product product : products) {
            
        }
    }
    
}
