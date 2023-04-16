package flocking;

import mvc.AppPanel;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

import java.util.Iterator;

public class FlockingSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 30; i++)
            addAgent(new Bird());
    }

    @Override
    public String[] getStats() {
        int one = 0, two = 0, three = 0, four = 0, five = 0;
        Iterator<Agent> it = this.iterator();
        while (it.hasNext()) {
            Bird b = (Bird) it.next();
            switch (b.speed) {
                case (1): {one++; break;}
                case (2): {two++; break;}
                case (3): {three++; break;}
                case (4): {four++; break;}
                case (5): {five++; break;}
            }
        }
        String[] stats = {"#birds @ speed 1 = " + one, "#birds @ speed 2 = " + two, "#birds @ speed 3 = " + three, "#birds @ speed 4 = " + four, "#birds @ speed 5 = " + five};
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
