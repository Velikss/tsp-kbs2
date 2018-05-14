/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Felix
 */
public class LeftPanel extends JPanel implements ActionListener {

    private SimPanel Weightedtwoopt, Twoopt, Bruteforce, NearestNeighbour;
    private int X, Y;

    public LeftPanel(int X, int Y) {
        setPreferredSize(new Dimension(1100, 800));
//        setLayout(new GridLayout(4, 2));
        setLayout(new FlowLayout());
        this.X = X;
        this.Y = Y;

        //Initializing SimPanels
        Weightedtwoopt = new SimPanel(true, X, Y);
        Weightedtwoopt.add(new JLabel("<html><font color='blue'>Visualisatie Weighted Two Opt</font></html>"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel(true, X, Y);
        Twoopt.add(new JLabel("<html><font color='blue'>Visualisatie 2 opt</font></html>"));
        add(Twoopt);

        Bruteforce = new SimPanel(true, X, Y);
        Bruteforce.add(new JLabel("<html><font color='blue'>Visualisatie Bruteforce</font></html>"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel(true, X, Y);
        NearestNeighbour.add(new JLabel("<html><font color='blue'>Visualisatie Nearest Neighbour</font></html>"));
        add(NearestNeighbour);
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getXCoord() {
        return X;
    }

    public int getYCoord() {
        return Y;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
