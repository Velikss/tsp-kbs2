/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 *
 * @author Felix
 */
public class RightPanel extends JPanel implements ActionListener {

    private JPanel settings;
    private JTextArea infoBox;
    private JScrollPane scroll;
    private JButton startSimulation, generateResults;
    private JSpinner simcount, pointcount, height, width;
    private JCheckBox bruteforcecheck, twooptcheck, nearestneighbourcheck, weightedtwooptcheck;
    private Simulator simulator;
    private LeftPanel left;

    public RightPanel(Simulator sim, LeftPanel left) {
        this.simulator = sim;
        this.left = left;
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
        SpinnerModel pcm = new SpinnerNumberModel(simulator.getPoints(), 2, 9025, 1);
        pointcount = new JSpinner(pcm);
        pointcount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) pointcount.getValue();
                //Check if points fit in grid, if not set back to previous value
                if (value > (simulator.getX() * simulator.getY())) {
                    infoBox.append(value + " points don't fit in the grid!\n");
                    value = simulator.getPoints();
                }
                simulator.setPoints(value);
                System.out.println("Set simulator point amount to: " + value);
                pointcount.setValue(simulator.getPoints());
            }
        });
        settings.add(pointcount);

        settings.add(new JLabel("Hoogte"));
        SpinnerModel heightModel = new SpinnerNumberModel(simulator.getY(), 2, 95, 1);
        height = new JSpinner(heightModel);
        height.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) height.getValue();
                //Check if there is enough room for the points
                if (value * simulator.getX() < simulator.getPoints()) {
                    infoBox.append("Please select less points first!\n");
                    value = simulator.getY();
                }
                simulator.setY(value);
                height.setValue(simulator.getY());
                left.refreshY(value);
            }
        });
        settings.add(height);

        settings.add(new JLabel("Breedte"));
        SpinnerModel widthModel = new SpinnerNumberModel(simulator.getX(), 2, 95, 1);
        width = new JSpinner(widthModel);
        int panelWidth = simulator.getX();
        width.setValue(panelWidth);
        width.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) width.getValue();
                //Check if there is enough room for the points
                if (value * simulator.getY() < simulator.getPoints()) {
                    infoBox.append("Please select less points first!\n");
                    value = simulator.getX();
                }
                simulator.setX(value);
                width.setValue(simulator.getX());
                left.refreshX(value);
            }
        });
        settings.add(width);

        startSimulation = new JButton("Start simulatie");
        settings.add(startSimulation);
        startSimulation.addActionListener(this);

        generateResults = new JButton("Genereer resultaten");
        settings.add(generateResults);
        generateResults.addActionListener(this);

        add(settings, BorderLayout.PAGE_START);

        infoBox = new JTextArea();
        infoBox.setBorder(new TitledBorder(new EtchedBorder(), "Info box"));
        infoBox.setFont(new Font("Serif", Font.ITALIC, 16));
        infoBox.setLineWrap(true);
        infoBox.setWrapStyleWord(true);
        //infoBox.setEditable(false);
        scroll = new JScrollPane(infoBox);
        add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startSimulation) {
            ArrayList<Algorithm> algorithms = new ArrayList<Algorithm>();
            algorithms.add(new Bruteforce());
            algorithms.add(new Bruteforce());
            algorithms.add(new Bruteforce());
            algorithms.add(new Bruteforce());
            simulator.simStart(algorithms);
            left.refresh(simulator);

            for (Algorithm a : algorithms) {

            }
        }

        if (e.getSource() == generateResults) {
            simulator.generateResults();
        }
    }
}
