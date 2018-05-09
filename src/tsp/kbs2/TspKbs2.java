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
//        Screen s = new Screen();

          NearestNeighbour one = new NearestNeighbour();
          
          ArrayList<Location> locs = new ArrayList<>();
          
          Location een = new Location(1, 2);
          Location twee = new Location(4, 7);
          Location drie = new Location(5, 3);
          
          locs.add(een);
          locs.add(twee);
          locs.add(drie);
          
          one.solve(locs);
    }
    
}
