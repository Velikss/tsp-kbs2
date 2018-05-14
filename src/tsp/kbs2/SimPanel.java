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
    private int X;
    private int Y;

    public SimPanel(boolean grid, int X, int Y) {
        this.setPreferredSize(new Dimension(500, 390));
        this.grid = grid;
        this.X = X;
        this.Y = Y;

    }

    @Override
    public void paintComponent(Graphics g) {
        int dimensionY = 387 / Y;
        int dimensionX = 498 / X;

        int lengthX = 498 - (498 % X);
        int lengthY = 387 - (387 % Y);

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

    public int getXCoord() {
        return X;
    }

    public int getYCoord() {
        return Y;
    }
    public void setXCoord(int X) {
        this.X = X;
    }

    public void setYCoord(int Y) {
        this.Y = Y;
    }
}
