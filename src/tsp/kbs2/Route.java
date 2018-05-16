/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class Route {
    
    private ArrayList<Location> route;
    private double distance;
    
    public Route(ArrayList<Location> route) {
        this.route = route;
        this.distance = getDistance(route);
    }

    public ArrayList<Location> getRoute() {
        return route;
    }
    
    private double getDistance(ArrayList<Location> locations) {
        return distance;
    }
    
    
}
