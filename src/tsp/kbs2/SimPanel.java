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

    private boolean raster;

    public SimPanel(boolean raster) {
        this.setPreferredSize(new Dimension(500, 400));
        this.raster = raster;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        if (raster) {
            for (int j = 0; j <= 400; j += 5) {
                g.drawLine(j, 0, j, 400);
            }
            for (int j = 0; j <= 500; j += 5) {
                g.drawLine(0, j, 500, j);
            }
        }
    }
}
