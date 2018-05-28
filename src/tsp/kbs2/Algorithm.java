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
public abstract class Algorithm {
    
    protected double time;
    private String name;
    protected ArrayList<Location> locations = new ArrayList<>();
    protected Route result;
    
    public abstract Route solve(ArrayList<Location> locations);
    
    protected abstract double calculateDistance(Location locA, Location locB);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }  
}
