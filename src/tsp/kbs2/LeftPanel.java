/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class LeftPanel extends JPanel implements ActionListener {

    public Simulator simulator;
    private SimPanel Weightedtwoopt, Twoopt, Bruteforce, NearestNeighbour;
//    private ArrayList<Location> locations;
    private int X, Y, points;

    public LeftPanel(Simulator sim) {
        this.simulator = sim;
        this.X = 13;
        this.Y = 13;
        this.points = 4;
        
        setPreferredSize(new Dimension(1100, 800));
//        setLayout(new GridLayout(4, 2));
        setLayout(new FlowLayout());

        //Initializing SimPanels
        ArrayList<Location> locations = simulator.generateLocations(this.X, this.Y, this.points);
        
        Algorithm NearestNeighbourAlgorithm = new NearestNeighbour();
        ArrayList<Location> NearestNeighbourRoute = NearestNeighbourAlgorithm.solve(locations);        
        Weightedtwoopt = new SimPanel(NearestNeighbourAlgorithm, true, X, Y, NearestNeighbourRoute);
        Weightedtwoopt.add(new JLabel("<html><font color='blue'>Visualisatie Weighted Two Opt</font></html>"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel(NearestNeighbourAlgorithm, true, X, Y, NearestNeighbourRoute);
        Twoopt.add(new JLabel("<html><font color='blue'>Visualisatie 2 opt</font></html>"));
        add(Twoopt);

        Bruteforce = new SimPanel(NearestNeighbourAlgorithm, true, X, Y, NearestNeighbourRoute);
        Bruteforce.add(new JLabel("<html><font color='blue'>Visualisatie Bruteforce</font></html>"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel(NearestNeighbourAlgorithm, true, X, Y, NearestNeighbourRoute);
        NearestNeighbour.add(new JLabel("<html><font color='blue'>Visualisatie Nearest Neighbour</font></html>"));
        add(NearestNeighbour);
    }

    public void setXCoord(int X) {
        this.X = X;
        Weightedtwoopt.setXCoord(X);
        Twoopt.setXCoord(X);
        Bruteforce.setXCoord(X);
        NearestNeighbour.setXCoord(X);
    }

    public void setYCoord(int Y) {
        this.Y = Y;
        Weightedtwoopt.setYCoord(Y);
        Twoopt.setYCoord(Y);
        Bruteforce.setYCoord(Y);
        NearestNeighbour.setYCoord(Y);
    }

    public int getXCoord() {
        return Weightedtwoopt.getXCoord();
    }

    public int getYCoord() {
        return Weightedtwoopt.getYCoord();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int max, int points) {
        ArrayList<Location> locations = simulator.generateLocations(this.X, this.Y, this.points);
        this.points = points;
        Weightedtwoopt.setRoute(locations);
        Twoopt.setRoute(locations);
        Bruteforce.setRoute(locations);
        NearestNeighbour.setRoute(locations);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
