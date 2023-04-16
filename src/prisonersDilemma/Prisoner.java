package prisonersDilemma;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Prisoner extends Agent {
    private static int RADIUS_VALUE = 10;
    private Strategy strategy;
    private int fitness;
    private boolean cheated;
    public boolean partnerCheated;
    public Prisoner() {
        super("Prisoner's Dilemma");
        fitness = 0;
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        this.strategy.setMyPrisoner(this);

        Prisoner neighbor = (Prisoner) world.getNeighbor(this, RADIUS_VALUE); // true = cheated, false = cooperated
        if (neighbor!=null) {
            cheated = this.cooperate();
            partnerCheated = neighbor.cheated;

            if (!cheated && !neighbor.cheated) {
                updateFitness(3);
            }
            else if (!cheated && neighbor.cheated) {
                updateFitness(0);
            }
            else if (cheated && !neighbor.cheated) {
                updateFitness(5);
            }
            else {
                updateFitness(1);
            }
        }
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void updateFitness(int n) {
        fitness += n;
    }

    public void setStrategy(Strategy s) {
        strategy = s;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public int getFitness() {
        return fitness;
    }
}