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
    protected String name;
    protected int simulatieNr;
    protected float afstand;
    protected ArrayList<Location> locations = new ArrayList<>();
    protected ArrayList<Location> route = new ArrayList<>();

    public ArrayList<Location> solve(ArrayList<Location> locations) {
        return route;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSimulatieNr() {
        return simulatieNr;
    }

    public void setSimulatieNr(int simulatieNr) {
        this.simulatieNr = simulatieNr;
    }

    public float getAfstand() {
        return afstand;
    }

    public void setAfstand(float afstand) {
        this.afstand = afstand;
    }

    public ArrayList<Location> getProducts() {
        return locations;
    }

    public void setProducts(ArrayList<Location> products) {
        this.locations = products;
    }

}
