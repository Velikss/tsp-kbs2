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
public class Simulation {
    private boolean running;
    private ArrayList<Location> products;
    private ArrayList<Algorithm> algorithms;

    public Simulation(){
        products = new ArrayList<>();
        algorithms = new ArrayList<>();
    }    
    
    public void generateProducts() {
        //Genereert random producten        
    }
}
