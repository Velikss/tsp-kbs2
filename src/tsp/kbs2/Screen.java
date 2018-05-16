/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Felix
 */
public class Screen extends JFrame implements ActionListener {

    public Simulator simulator;

    public Screen(Simulator sim) {
        this.simulator = sim;
        
        LeftPanel left = new LeftPanel(sim);
        RightPanel right = new RightPanel(sim, left);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TSP Simulator");
        setSize(1400, 900);
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setVgap(0);
        layout.setHgap(0);

        setLayout(layout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(left);
        add(right);

        setVisible(true);
    }

    //action preformed toevoegen zodat je wat kunt doen met de knoppen en texten
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
