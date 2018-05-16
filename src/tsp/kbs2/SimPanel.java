/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.kbs2;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Felix
 */
public class SimPanel extends JPanel {

    private Route result;
    private boolean grid;
    private int X, Y;
    private Algorithm algorithm;

    public SimPanel(Route route, boolean grid, int X, int Y) {
        this.result = route;
        this.grid = grid;
        this.X = X;
        this.Y = Y;
        this.setPreferredSize(new Dimension(500, 390));

    }    

    @Override
    public void paintComponent(Graphics g) {
        int dimensionX = 498 / X;
        int dimensionY = 387 / Y;

        int lengthX = 498 - (498 % X);
        int lengthY = 387 - (387 % Y);

        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.black);
//      Draws grid
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
        
//      Draws locations
        ArrayList<Location> route = new ArrayList<Location>();
        route = result.getRoute();
        for (Location a : route) {
            int X = ((a.xPosition * dimensionX) - dimensionX) + 1;
            int Y = (lengthY - (a.yPosition * dimensionY)) + 1;

//          Fill rectangle at location a
            g.setColor(Color.red);
            g.fillRect(X, Y, dimensionX, dimensionY);
        }

//      Draws lines
        for (int i = 1; i < route.size(); i++) {
            int X1 = (route.get(i - 1).xPosition * dimensionX) - (dimensionX / 2);
            int Y1 = (lengthY - (route.get(i - 1).yPosition * dimensionY)) + (dimensionY / 2);
//            
            int X2 = (route.get(i).xPosition * dimensionX) - (dimensionX / 2);
            int Y2 = (lengthY - (route.get(i).yPosition * dimensionY)) + (dimensionY / 2);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
            g.setColor(Color.blue);
            g.drawLine(X1, Y1, X2, Y2);
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
