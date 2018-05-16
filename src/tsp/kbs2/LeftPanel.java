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
    private int X, Y;

    public LeftPanel(Simulator sim) {
        this.simulator = sim;
        this.X = sim.getX();
        this.Y = sim.getY();
        
        setPreferredSize(new Dimension(1100, 800));
        setLayout(new FlowLayout());

        //Initializing SimPanels
//        ArrayList<Location> locations = simulator.generateLocations(this.X, this.Y, this.points);
        
//        Algorithm NearestNeighbourAlgorithm = new NearestNeighbour();
//        ArrayList<Location> NearestNeighbourRoute = NearestNeighbourAlgorithm.solve(locations); 
//        simulator.simStart(simulator.getAlgorithms());

        Weightedtwoopt = new SimPanel(simulator.getResults().get(0), true, X, Y);
        Weightedtwoopt.add(new JLabel("<html><font color='blue'>Visualisatie Weighted Two Opt</font></html>"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel(simulator.getResults().get(0), true, X, Y);
        Twoopt.add(new JLabel("<html><font color='blue'>Visualisatie 2 opt</font></html>"));
        add(Twoopt);

        Bruteforce = new SimPanel(simulator.getResults().get(0), true, X, Y);
        Bruteforce.add(new JLabel("<html><font color='blue'>Visualisatie Bruteforce</font></html>"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel(simulator.getResults().get(0), true, X, Y);
        NearestNeighbour.add(new JLabel("<html><font color='blue'>Visualisatie Nearest Neighbour</font></html>"));
        add(NearestNeighbour);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
