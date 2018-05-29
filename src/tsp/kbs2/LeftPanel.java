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

    public Simulator simulator;
    private SimPanel Simpanel0, Simpanel1, Simpanel2, Simpanel3;
    private int X, Y;

    public LeftPanel(Simulator sim) {
        this.simulator = sim;
        this.X = sim.getX();
        this.Y = sim.getY();

        setPreferredSize(new Dimension(1100, 800));
        setLayout(new FlowLayout());

        
        //Initializing SimPanels
        System.out.println(sim.getAlgorithms());
        Simpanel0 = new SimPanel(sim, 0);
//        Simpanel0.add(new JLabel(sim.getAlgorithms().get(0).getName()));
        add(Simpanel0);
        
        Simpanel1 = new SimPanel(sim, 1);
//        Simpanel1.add(new JLabel(sim.getAlgorithms().get(1).getName()));
        add(Simpanel1);
        
        Simpanel2 = new SimPanel(sim, 2);
//        Simpanel2.add(new JLabel(sim.getAlgorithms().get(2).getName()));
        add(Simpanel2);
        
        Simpanel3 = new SimPanel(sim, 3);
//        Simpanel3.add(new JLabel(sim.getAlgorithms().get(3).getName()));
        add(Simpanel3);
        
//        Weightedtwoopt = new SimPanel(sim, 0);
//        Weightedtwoopt.add(new JLabel("<html><font color='blue'>Visualisatie Weighted Two Opt</font></html>"));
//        add(Weightedtwoopt);
//
//        Twoopt = new SimPanel(sim, 0);
//        Twoopt.add(new JLabel("<html><font color='blue'>Visualisatie 2 opt</font></html>"));
//        add(Twoopt);
//
//        Bruteforce = new SimPanel(sim, 0);
//        Bruteforce.add(new JLabel("<html><font color='blue'>Visualisatie Bruteforce</font></html>"));
//        add(Bruteforce);
//
//        NearestNeighbour = new SimPanel(sim, 0);
//        NearestNeighbour.add(new JLabel("<html><font color='blue'>Visualisatie Nearest Neighbour</font></html>"));
//        add(NearestNeighbour);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public void refresh(Simulator s) {
        Simpanel0.setRoute(s.getRoute(0));
        Simpanel1.setRoute(s.getRoute(0));
        Simpanel2.setRoute(s.getRoute(0));
        Simpanel3.setRoute(s.getRoute(0));
        repaint();
    }

    public void refreshY(int Y) {
        Simpanel0.setYCoord(Y);
        Simpanel1.setYCoord(Y);
        Simpanel2.setYCoord(Y);
        Simpanel3.setYCoord(Y);
        repaint();
    }

    public void refreshX(int X) {
        Simpanel0.setXCoord(X);
        Simpanel1.setXCoord(X);
        Simpanel2.setXCoord(X);
        Simpanel3.setXCoord(X);
        repaint();
    }
}
