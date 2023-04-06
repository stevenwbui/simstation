package simstation;

import mvc.*;
import java.util.*;

public class Simulation extends Model {
    private Timer timer;
    private int clock;
    private List<Agent> agents;

    public Simulation() {
        clock = 0;
        agents = new ArrayList<Agent>();
    }
    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            changed();
        }
    }
    public void start() {}

    public void suspend() {}

    public void resume() {}

    public void stop() {}

    public Agent getNeighbor(Agent a, double radius) {
        return null;
    }

    public void populate() {}

    public void addAgent(Agent a) {
        agents.add(a);
        a.setWorld(this);
    }
}
