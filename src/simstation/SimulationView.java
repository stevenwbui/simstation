package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Iterator;

public class SimulationView extends View {
    final int AGENT_DIAMETER = 5;
    public SimulationView(Simulation sim) {
        super(sim);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Simulation sim = (Simulation) model;
        Iterator<Agent> it = sim.iterator();
        while (it.hasNext()) {
            Agent a =it.next();
            gc.setColor(a.getColor());
            Graphics2D g2d = (Graphics2D) gc;
            Ellipse2D.Double point = new Ellipse2D.Double(a.getXc(), a.getYc(), AGENT_DIAMETER, AGENT_DIAMETER);
            g2d.fill(point);
        }
        gc.setColor(oldColor);
    }
}