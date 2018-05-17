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
public class Location {
    public int xPosition;
    public int yPosition;
    
    public Location(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    
    public int getPositionX() {
        return xPosition;
    }

    public int getPositionY() {
        return yPosition;
    }
    
    
    @Override
    public String toString() {
        return xPosition + ":" + yPosition;
    }
}
