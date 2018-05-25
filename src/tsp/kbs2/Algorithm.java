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
    
    protected long time;
    protected double distance;
    private String name;
    protected ArrayList<Location> locations = new ArrayList<>();
    protected Route result;
    protected boolean infinit = false;

    public abstract Route solve(ArrayList<Location> locations);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setInifinit(boolean b) {
        this.infinit = b;
    }
       
}
