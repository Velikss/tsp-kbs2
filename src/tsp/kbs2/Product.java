/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.kbs2;

/**
 *
 * @author Felix
 */
public class Product {
    public int xPosition;
    public int yPosition;
    
    public Product(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    @Override
    public String toString() {
        return xPosition + ":" + yPosition;
    }
}
