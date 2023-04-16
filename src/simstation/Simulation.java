package simstation;

import mvc.*;
import java.util.*;

public class Simulation extends Model {
    transient private Timer timer;
    private int clock;
    private List<Agent> agents;

    public Simulation() {
        clock = 0;
        agents = new LinkedList<>();
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
    public void start() {
        agents.clear();
        clock = 0;
        populate();
        startTimer();
        for (Agent a : agents) {
            a.start();
        }
    }

    public void suspend() {
        stopTimer();
        for (Agent a : agents) {
            a.suspend();
        }
    }

    public void resume() {
        startTimer();
        for (Agent a : agents) {
            a.resume();
        }
    }

    public void stop() {
        for (Agent a : agents) {
            a.stop();
        }
        stopTimer();
    }

    public Agent getNeighbor(Agent a, double radius) {
        int index = Utilities.rng.nextInt(agents.size());
        for (int i = 0; i < agents.size(); i++) {
            if ((Math.abs(agents.get(index).getXc() - a.getXc()) <= radius) && Math.abs(agents.get(index).getYc() - a.getYc()) <= radius) {
                return agents.get(index);
            }
            index++;
            if (index >= agents.size()) {
                index = 0;
            }
        }
        return null;
    }

    public void populate() {}

    public void addAgent(Agent a) {
        agents.add(a);
        a.setWorld(this);
    }

    public Iterator<Agent> iterator() {
        return agents.iterator();
    }

    public String[] getStats() {
        String[] stats = {"#agents = " + agents.size(), "clock = " + clock};
        return stats;
    }
}
