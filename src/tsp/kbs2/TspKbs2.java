/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.kbs2;

import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class TspKbs2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Location> locations = new ArrayList<>();
        Location een = new Location(5, 2);
        Location twee = new Location(10, 7);
        Location drie = new Location(5, 7);

        locations.add(een);
        locations.add(twee);
        locations.add(drie);
        Simulator s = new Simulator(locations);

//          NearestNeighbour one = new NearestNeighbour();
//          
//          ArrayList<Location> locs = new ArrayList<>();
//          
//          Location een = new Location(11, 2);
//          Location twee = new Location(45, 7);
//          Location drie = new Location(5, 30);
//          
//          locs.add(een);
//          locs.add(twee);
//          locs.add(drie);
//          
//          one.solve(locs);
    }
    
}
