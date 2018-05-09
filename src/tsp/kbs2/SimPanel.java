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

    private boolean grid;

    public SimPanel(boolean grid) {
        this.setPreferredSize(new Dimension(500, 390));
        this.grid = grid;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        if (grid) {
            for (int j = 1; j <= 499; j += 20) {
                g.drawLine(j, 1, j, 389);
            }
            for (int j = 20; j <= 389; j += 20) {
                g.drawLine(1, j, 499, j);
            }
        }
    }
}
