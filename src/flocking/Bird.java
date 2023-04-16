package flocking;

import mvc.*;
import simstation.*;

public class Bird extends Agent {
    int speed;
    private final int RADIUS_VALUE = 10;
    public Bird() {
        super("Flocking");
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }
    @Override
    public void update() {
        Bird neighbor = (Bird) world.getNeighbor(this, RADIUS_VALUE);
        if (neighbor!=null) {
            this.speed = neighbor.speed;
            this.heading = neighbor.heading;
        }
        this.move(speed);
    }
}
