/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package tsp.kbs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/*
 *
 * @author Felix
 */
public class RightPanel extends JPanel implements ActionListener {

    private JPanel settings;
    private JEditorPane infoBox;
    private JScrollPane scroll;
    private JButton startSimulation, generateResults;
    private JSpinner simcount, pointcount, height, width;
    private JCheckBox bruteforcecheck, twooptcheck, nearestneighbourcheck, weightedtwooptcheck;
    private JLabel simulationSettings, gridSettings;
    private Simulator simulator;
    private LeftPanel left;
    private int simulations = 1;

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
        simulationSettings = new JLabel("Simulation settings");
        simulationSettings.setFont(simulationSettings.getFont().deriveFont(13.0f));
        Font font = simulationSettings.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        simulationSettings.setFont(font.deriveFont(attributes));
        settings.add(simulationSettings);
        settings.add(new JLabel("Aantal simulaties"));

        SpinnerModel countModel = new SpinnerNumberModel(simulations, 1, 50, 1);
        simcount = new JSpinner(countModel);
        simcount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                simulations = (int) simcount.getValue();
            }
        });
        settings.add(simcount);
        
        //Algorithm checkboxes
        settings.add(new JLabel("Weighted 2-opt"));
        weightedtwooptcheck = new JCheckBox();
        settings.add(weightedtwooptcheck);
        weightedtwooptcheck.addActionListener(this);
        
        settings.add(new JLabel("Nearest Neighbour"));
        nearestneighbourcheck = new JCheckBox();
        settings.add(nearestneighbourcheck);
        nearestneighbourcheck.addActionListener(this);
        
        settings.add(new JLabel("Bruteforce"));
        bruteforcecheck = new JCheckBox();
        settings.add(bruteforcecheck);
        bruteforcecheck.addActionListener(this);
        
        settings.add(new JLabel("2-opt"));
        twooptcheck = new JCheckBox();
        settings.add(twooptcheck);
        twooptcheck.addActionListener(this);

//      Grid settings
        gridSettings = new JLabel("Grid settings");
        gridSettings.setFont(gridSettings.getFont().deriveFont(13.0f));
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        gridSettings.setFont(font.deriveFont(attributes));
        settings.add(gridSettings);

        settings.add(new JLabel("Aantal punten"));
        SpinnerModel pcm = new SpinnerNumberModel(simulator.getPoints(), 2, 9025, 1);
        pointcount = new JSpinner(pcm);
        pointcount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) pointcount.getValue();
                //Check if points fit in grid, if not set back to previous value
                if (value > (simulator.getX() * simulator.getY())) {
                    printToInfoBox(value + " points don't fit in the grid!");
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
                    printToInfoBox("Please select less points first!");
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
                    printToInfoBox("Please select less points first!");
                    value = simulator.getX();
                }
                simulator.setX(value);
                width.setValue(simulator.getX());
                left.refreshX(value);
            }
        });
        settings.add(width);

        startSimulation = new JButton("Start simulator");
        settings.add(startSimulation);
        startSimulation.addActionListener(this);

        generateResults = new JButton("Export to JSON");
        settings.add(generateResults);
        generateResults.addActionListener(this);

        add(settings, BorderLayout.PAGE_START);

        infoBox = new JEditorPane("text/html", "");
        infoBox.setBorder(new TitledBorder(new EtchedBorder(), "Info box"));
        infoBox.setFont(new Font("Serif", Font.ITALIC, 18));
        infoBox.setEditable(false);
        scroll = new JScrollPane(infoBox);
        add(scroll, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startSimulation) {
            //Clear infoBox from previos messages
            infoBox.setText(null);
            //First all selected algorithms get added to the list
            ArrayList<Algorithm> algorithms = new ArrayList<Algorithm>();
            if (weightedtwooptcheck.isSelected()) {
                algorithms.add(new WeightedTwoOpt());
            }
            if (nearestneighbourcheck.isSelected()) {
                algorithms.add(new NearestNeighbour());
            }
            if (bruteforcecheck.isSelected()) {
                algorithms.add(new Bruteforce());
            }
            if (twooptcheck.isSelected()) {
                algorithms.add(new TwoOpt());
            }

            if (algorithms.size() != 0) {
                //Add algorithms and clear old simulation results
                simulator.newAlgorithms(algorithms);
                simulator.newSimulations();

                //Loop iterations
                for (int i = 1; i <= simulations; i++) {
                    printToInfoBox("\nIteration " + i + " / " + simulations);
                    printToInfoBox("-------------------------------------------");
                    simulator.simStart();
                    for (int j = 0; j < algorithms.size(); j++) {
                        printToInfoBox(simulator.getResults().get(j).toString());
                        printToInfoBox("Time: " + simulator.getResults().get(j).getTime() + " ms");
                        printToInfoBox("Distance: " + simulator.getResults().get(j).getDistance());
                        printToInfoBox("-------------------------------------------");
                    }
                }
                left.refresh(simulator);
            } else {
                printToInfoBox("No algorithms selected!\n");
            }
        }

        if (e.getSource() == generateResults) {
            boolean NullPointerException = false;
            printToInfoBox("Exporting results...");
            try {
                simulator.exportResults();
            } catch (NullPointerException n) {
                printToInfoBox("No data to export!");
                NullPointerException = true;
            } finally {
                if (!NullPointerException) {
                    if (simulator.FileNotFoundException) {
                        printToInfoBox(simulator.getFileError());
                    } else {
                        printToInfoBox("Exported results to: " + simulator.getFilePath());
                    }
                }
            }

        }

        if (e.getSource() == bruteforcecheck) {
            if (simulator.getPoints() > 10) {
                printToInfoBox("You have selected too much points for the Bruteforce algorithm!");
                bruteforcecheck.setSelected(false);
            }
        }
    }

    public void printToInfoBox(String text) {
        try {
            Document doc = infoBox.getDocument();
            doc.insertString(doc.getLength(), text + "\n", null);
        } catch (BadLocationException exc) {
            exc.printStackTrace();
        }
    }
}
