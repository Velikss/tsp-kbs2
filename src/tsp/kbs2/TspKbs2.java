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
//        Location een = new Location(5, 2);
//        Location twee = new Location(10, 7);
//        Location drie = new Location(5, 7);

//        locations.add(een);
//        locations.add(twee);
//        locations.add(drie);
        for (int i = 0; i < 10; i++) {
            int random1 = (int) (Math.random() * 8 + 2);
            int random2 = (int) (Math.random() * 8 + 2);
            Location newRandom = new Location(random1, random2);
            locations.add(newRandom);
        }
//        System.out.println(locations);
        Simulator a = new Simulator();

    }

}
