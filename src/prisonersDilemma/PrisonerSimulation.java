package prisonersDilemma;

import mvc.AppPanel;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

import java.util.Iterator;

public class PrisonerSimulation extends Simulation {
    public void populate() {
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new Cooperate());
            addAgent(p);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new RandomlyCooperate());
            addAgent(p);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new Cheat());
            addAgent(p);
        }
        for(int i = 0; i < 10; i++) {
            Prisoner p = new Prisoner();
            p.setStrategy(new Tit4Tat());
            addAgent(p);
        }
    }

    public String[] getStats() {
        String[] stats = new String[4];

        stats[0] = "avg fitness of Cooperate (GREEN) = " + getAverageFitness(new Cooperate());
        stats[1] = "avg fitness of Randomly Cooperate (CYAN) = " + getAverageFitness(new RandomlyCooperate());
        stats[2] = "avg fitness of Cheat (RED) = " + getAverageFitness(new Cheat());
        stats[3] = "avg fitness of Tit4Tat (PINK) = " + getAverageFitness(new Tit4Tat());

        return stats;
    }

    public double getAverageFitness(Strategy s) {
        double fitnessTotal = 0;
        double total = 0;

        Iterator<Agent> it = this.iterator();
        while (it.hasNext()) {
            Prisoner p = (Prisoner) it.next();
            if (s.getClass().equals(p.getStrategy().getClass())) {
                total++;
                fitnessTotal += p.getFitness();
            }
        }

        return fitnessTotal/total;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }


}
