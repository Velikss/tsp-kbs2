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
    private int X, Y;

    public LeftPanel(Simulator sim) {
        this.simulator = sim;
        this.X = sim.getX();
        this.Y = sim.getY();

        setPreferredSize(new Dimension(1100, 800));
        setLayout(new FlowLayout());

        //Initializing SimPanels
        Weightedtwoopt = new SimPanel(sim, 0);
        Weightedtwoopt.add(new JLabel("<html><font color='blue'>Visualisatie Weighted Two Opt</font></html>"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel(sim, 0);
        Twoopt.add(new JLabel("<html><font color='blue'>Visualisatie 2 opt</font></html>"));
        add(Twoopt);

        Bruteforce = new SimPanel(sim, 0);
        Bruteforce.add(new JLabel("<html><font color='blue'>Visualisatie Bruteforce</font></html>"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel(sim, 0);
        NearestNeighbour.add(new JLabel("<html><font color='blue'>Visualisatie Nearest Neighbour</font></html>"));
        add(NearestNeighbour);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public void refresh(Simulator s) {
        Weightedtwoopt.setRoute(s.getRoute(0));
        Twoopt.setRoute(s.getRoute(0));
        Bruteforce.setRoute(s.getRoute(0));
        NearestNeighbour.setRoute(s.getRoute(0));
        repaint();
    }

    public void refreshY(int Y) {
        Weightedtwoopt.setYCoord(Y);
        Twoopt.setYCoord(Y);
        Bruteforce.setYCoord(Y);
        NearestNeighbour.setYCoord(Y);
        repaint();
    }

    public void refreshX(int X) {
        Weightedtwoopt.setXCoord(X);
        Twoopt.setXCoord(X);
        Bruteforce.setXCoord(X);
        NearestNeighbour.setXCoord(X);
        repaint();
    }
}
