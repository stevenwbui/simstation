package plague;

import flocking.Bird;
import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

import java.awt.*;

import static plague.PlagueSimulation.RADIUS_VALUE;

public class Host extends Agent {
    public static int INFECTION_TOTAL_VALUE = 300;
    private boolean infected;
    public Host(boolean infected) {
        super("Plague");
        this.infected = infected;
        this.setColor(Color.GREEN);
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected() {
        infected = true;
    }

    @Override
    public void update() {
        if (infected) {
            setColor(Color.RED);
        }

        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        Host neighbor = (Host) world.getNeighbor(this, RADIUS_VALUE);
        if (infected && !neighbor.isInfected() && neighbor!=null) {
            int randNum = Utilities.rng.nextInt(INFECTION_TOTAL_VALUE)+1;

            if (randNum >= PlagueSimulation.RESISTANCE && randNum < PlagueSimulation.VIRULENCE) {
                neighbor.setInfected();
            }
        }
    }
}
