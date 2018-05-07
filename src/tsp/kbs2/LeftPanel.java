/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Felix
 */
public class LeftPanel extends JPanel implements ActionListener {

    private SimPanel Weightedtwoopt, Twoopt, Bruteforce, NearestNeighbour;

    public LeftPanel() {
        setPreferredSize(new Dimension(1100, 800));
        setLayout(new FlowLayout());

        //Initializing SimPanels
        Weightedtwoopt = new SimPanel();
        Weightedtwoopt.setBorder(BorderFactory.createTitledBorder("Visualisatie Weighted 2 opt"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel();
        Twoopt.setBorder(BorderFactory.createTitledBorder("Visualisatie 2 opt"));
        add(Twoopt);

        Bruteforce = new SimPanel();
        Bruteforce.setBorder(BorderFactory.createTitledBorder("Visualisatie Bruteforce"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel();
        NearestNeighbour.setBorder(BorderFactory.createTitledBorder("Visualisatie Nearest Neighbour"));
        add(NearestNeighbour);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
