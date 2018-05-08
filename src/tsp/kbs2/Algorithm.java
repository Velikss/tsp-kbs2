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

    protected Long time;
    protected String name;
    protected int simulatieNr;
    protected float afstand;
    protected ArrayList<Location> products = new ArrayList<>();
    protected ArrayList<Location> newRoute = new ArrayList<>();

    public void solve(ArrayList<Location> products) {
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
        return products;
    }

    public void setProducts(ArrayList<Location> products) {
        this.products = products;
    }

}
