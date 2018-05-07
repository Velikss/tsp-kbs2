/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Felix
 */
public class SimPanel extends JPanel {

    public SimPanel() {
        this.setPreferredSize(new Dimension(500, 400));

    }

    public void paintComponent(Graphics g) {

        // teken de achtergrond
        super.paintComponent(g);

        setBackground(Color.WHITE);

    }
}
