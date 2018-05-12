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
    private int amount;

    public SimPanel(boolean grid, int amount) {
        this.setPreferredSize(new Dimension(500, 390));
        this.grid = grid;
        this.amount = amount;

    }

    @Override
    public void paintComponent(Graphics g) {
        int dimensionY = 389 / amount;
        int dimensionX = 499 / amount;
        
        int vertLength = 389 - (389 % amount);
        int horizLength = 499 - (499 %amount);
        
        
        super.paintComponent(g);
        setBackground(Color.WHITE);
        if (grid) {
//          Paints vertical lines
            for (int j = 20; j <= 499; j += dimensionX) {
                g.drawLine(j, 1, j, vertLength);
            }
//          Paints horizontal lines
            for (int j = 20; j <= 389; j += dimensionY) {
                g.drawLine(1, j, horizLength, j);
            }
        }
    }
}
