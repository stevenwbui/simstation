package plague;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

import java.util.Iterator;

public class PlagueSimulation extends Simulation {
    public static int RADIUS_VALUE = 10;
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public void populate() {
        int starting_infected = Utilities.rng.nextInt(5) + 1;

        for(int i = 0; i < starting_infected; i++)
            addAgent(new Host(true));

        for(int i =starting_infected; i < 50; i++)
            addAgent(new Host(false));
    }

    public double getInfectedPercent() {
        int infected = 0;

        Iterator<Agent> it = this.iterator();
        while (it.hasNext()) {
            Host h = (Host) it.next();
            if (h.isInfected()) {
                infected++;
            }
        }

        return (infected / 50.0)*100;
    }

    @Override
    public String[] getStats() {
        String[] newStats = new String[3];
        String[] stats = super.getStats();
        newStats[0] = stats[0];
        newStats[1] = stats[1];
        newStats[2] = "% infected = " + getInfectedPercent();
        return newStats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
