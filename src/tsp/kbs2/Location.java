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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.xPosition != other.xPosition) {
            return false;
        }
        if (this.yPosition != other.yPosition) {
            return false;
        }
        if(this.toString().equals(obj.toString())) {
            return true;
        }
        return true;
    }  
    
    @Override
    public String toString() {
        return xPosition + ":" + yPosition;
    }
}
