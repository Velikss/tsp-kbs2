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
public class RightPanel extends JPanel implements ActionListener {

    private JPanel settings, infoBox;

    public RightPanel() {
        setPreferredSize(new Dimension(250, 800));
        setLayout(new BorderLayout());

        settings = new JPanel();
        settings.setLayout(new FlowLayout());
        settings.setPreferredSize(new Dimension(200, 300));
        settings.setBackground(Color.orange);
        add(settings, BorderLayout.PAGE_START);

        infoBox = new JPanel();
        infoBox.setLayout(new FlowLayout());
        infoBox.setPreferredSize(new Dimension(200, 450));
        infoBox.setBackground(Color.red);
        add(infoBox,BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
