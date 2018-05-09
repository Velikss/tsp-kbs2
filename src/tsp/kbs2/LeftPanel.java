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

    public LeftPanel() {
        setPreferredSize(new Dimension(1100, 800));
//        setLayout(new GridLayout(4, 2));
        setLayout(new FlowLayout());

        //Initializing SimPanels
        Weightedtwoopt = new SimPanel(true);
        Weightedtwoopt.add(new JLabel("Weighted Two Opt"));
        add(Weightedtwoopt);

        Twoopt = new SimPanel(true);
        Twoopt.add(new JLabel("Visualisatie 2 opt"));
        add(Twoopt);

        Bruteforce = new SimPanel(true);
        Bruteforce.add(new JLabel("Visualisatie Bruteforce"));
        add(Bruteforce);

        NearestNeighbour = new SimPanel(true);
        NearestNeighbour.add(new JLabel("Visualisatie Nearest Neighbour"));
        add(NearestNeighbour);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
