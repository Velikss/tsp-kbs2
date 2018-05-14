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
    private int linesX;
    private int linesY;

    public SimPanel(boolean grid, int X, int Y) {
        this.setPreferredSize(new Dimension(500, 390));
        this.grid = grid;
        this.linesX = X;
        this.linesY = Y;

    }

    @Override
    public void paintComponent(Graphics g) {
        int dimensionY = 387 / linesY;
        int dimensionX = 498 / linesX;
        
        int lengthX = 498 - (498 % linesX);
        int lengthY = 387 - (387 % linesY);
        
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.black);
        
        if (grid) {
//          Paints vertical lines
            for (int j = 1; j <= lengthX + 1; j += dimensionX) {
                g.drawLine(j, 1, j, lengthY);
            }
//          Paints horizontal lines
            for (int j = 1; j <= lengthY + 1; j += dimensionY) {
                g.drawLine(1, j, lengthX, j);
            }
        }
    }
}
