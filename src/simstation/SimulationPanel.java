package simstation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends AppPanel {
    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;
    public SimulationPanel(AppFactory factory) {
        super(factory);
        this.setLayout(new GridLayout(1, 2));
        controlPanel.setBackground((Color.WHITE));

        controlPanel.setLayout(new GridLayout(5, 1));
        start = new JButton("Start");
        start.addActionListener(this);
        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        resume = new JButton("Resume");
        resume.addActionListener(this);
        stop = new JButton("Stop");
        stop.addActionListener(this);
        stats = new JButton("Stats");
        stats.addActionListener(this);
        controlPanel.add(start);
        controlPanel.add(suspend);
        controlPanel.add(resume);
        controlPanel.add(stop);
        controlPanel.add(stats);
    }

    public static void main(String[] args) {
        AppFactory factory = new SimStationFactory();
        AppPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
