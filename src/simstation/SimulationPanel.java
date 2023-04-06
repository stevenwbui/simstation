package simstation;

import mvc.AppFactory;
import mvc.AppPanel;

import java.awt.*;

public class SimulationPanel extends AppPanel {
    public SimulationPanel(AppFactory factory) {
        super(factory);
        Simulation sim = (Simulation)model;

        this.setLayout(new GridLayout(1, 2));

    }

    public static void main(String[] args) {
        AppFactory factory = new SimStationFactory();
        AppPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
