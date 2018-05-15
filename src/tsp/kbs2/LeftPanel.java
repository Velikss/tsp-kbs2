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

    private SimPanel Weightedtwoopt, Twoopt, Bruteforce, NearestNeighbour;
    private ArrayList<Location> locations;
    private int X, Y;

    public LeftPanel(ArrayList<Location> locations) {
        this.locations = locations;
        this.X = 11;
        this.Y = 11;
        
        setPreferredSize(new Dimension(1100, 800));
//        setLayout(new GridLayout(4, 2));
        setLayout(new FlowLayout());

        //Initializing SimPanels
        Algorithm NearestNeighbourAlgorithm = new NearestNeighbour();
        Weightedtwoopt = new SimPanel(NearestNeighbourAlgorithm, true, X, Y);
        Weightedtwoopt.add(new JLabel("<html><font color='blue'>Visualisatie Weighted Two Opt</font></html>"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel(NearestNeighbourAlgorithm, true, X, Y);
        Twoopt.add(new JLabel("<html><font color='blue'>Visualisatie 2 opt</font></html>"));
        add(Twoopt);

        Bruteforce = new SimPanel(NearestNeighbourAlgorithm, true, X, Y);
        Bruteforce.add(new JLabel("<html><font color='blue'>Visualisatie Bruteforce</font></html>"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel(NearestNeighbourAlgorithm, true, X, Y);
        NearestNeighbour.add(new JLabel("<html><font color='blue'>Visualisatie Nearest Neighbour</font></html>"));
        add(NearestNeighbour);
    }

    public void setXCoord(int X) {
        Weightedtwoopt.setXCoord(X);
        Twoopt.setXCoord(X);
        Bruteforce.setXCoord(X);
        NearestNeighbour.setXCoord(X);
    }

    public void setYCoord(int Y) {
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
