package prisonersDilemma;

import mvc.Utilities;

import java.awt.*;

public class RandomlyCooperate extends Strategy {
    @Override
    public boolean cooperate() {
        return Utilities.rng.nextBoolean(); // random
    }
    public Color getStrategyColor() {return Color.CYAN;}
}
