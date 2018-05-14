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
    private JSpinner simcount, pointcount, height, width;
    private JCheckBox bruteforcecheck, twooptcheck, nearestneighbourcheck, weightedtwooptcheck;

    public RightPanel(LeftPanel left) {
        setPreferredSize(new Dimension(250, 800));
        setLayout(new BorderLayout());

        settings = new JPanel();
        settings.setBorder(new TitledBorder(new EtchedBorder(), "Settings"));
//        settings.setLayout(new FlowLayout());
        BoxLayout boxLayout = new BoxLayout(settings, BoxLayout.Y_AXIS); 
        settings.setLayout(boxLayout);
        settings.setBackground(Color.white);

//      Simulatie settings
        settings.add(new JLabel("Simulatie settings"));
        settings.add(new JLabel("Aantal simulaties"));
        simcount = new JSpinner();
        settings.add(simcount);

        settings.add(new JLabel("Bruteforce"));
        bruteforcecheck = new JCheckBox();
        settings.add(bruteforcecheck);

        settings.add(new JLabel("2-opt"));
        twooptcheck = new JCheckBox();
        settings.add(twooptcheck);

        settings.add(new JLabel("Nearest Neighbour"));
        nearestneighbourcheck = new JCheckBox();
        settings.add(nearestneighbourcheck);

        settings.add(new JLabel("Weighted 2-opt"));
        weightedtwooptcheck = new JCheckBox();
        settings.add(weightedtwooptcheck);

//      Grid settings
        settings.add(new JLabel("Simulatie settings"));
        settings.add(new JLabel("Aantal punten"));
        pointcount = new JSpinner();
        settings.add(pointcount);
        
        settings.add(new JLabel("Hoogte"));
        height = new JSpinner();
        int panelHeight = left.getYCoord();
        height.setValue(panelHeight);
        settings.add(height);
        
        settings.add(new JLabel("Breedte"));
        width = new JSpinner();
        int panelWidth = left.getXCoord();
        width.setValue(panelWidth);
        settings.add(width);

        add(settings, BorderLayout.PAGE_START);

        infoBox = new JTextArea();
        infoBox.setBorder(new TitledBorder(new EtchedBorder(), "Info box"));
        infoBox.setFont(new Font("Serif", Font.ITALIC, 16));
        infoBox.setLineWrap(true);
        infoBox.setWrapStyleWord(true);
        //comLog.setEditable(false);
        scroll = new JScrollPane(infoBox);
        add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
