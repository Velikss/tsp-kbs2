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

    private Long time;
    private String name;
    private int simulatieNr;
    private float afstand;
    protected ArrayList<Product> products = new ArrayList<>();

    public void solve(ArrayList<Product> products) {
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
