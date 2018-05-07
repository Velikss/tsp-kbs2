/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Felix
 */
public class RightPanel extends JPanel implements ActionListener {

    private JPanel settings;
    private JTextArea infoBox;
    private JScrollPane scroll;
    private JSpinner simcount;

    public RightPanel() {
        setPreferredSize(new Dimension(250, 800));
        setLayout(new BorderLayout());

        settings = new JPanel();
        settings.setLayout(new FlowLayout());
        settings.setPreferredSize(new Dimension(200, 300));
        settings.setBackground(Color.white);
        
        settings.add(new JLabel("Simulatie instellingen"));
        
        settings.add(new JLabel("Aantal simulaties"));
        simcount = new JSpinner();
        settings.add(simcount);
        
        add(settings, BorderLayout.PAGE_START);

        infoBox = new JTextArea();
        infoBox.setBorder(new TitledBorder(new EtchedBorder(), "Info box"));
        infoBox.setFont(new Font("Serif", Font.ITALIC, 16));
        infoBox.setLineWrap(true);
        infoBox.setWrapStyleWord(true);
        //comLog.setEditable(false);
        scroll = new JScrollPane(infoBox);
        add(scroll, BorderLayout.CENTER);
//        add(infoBox, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
