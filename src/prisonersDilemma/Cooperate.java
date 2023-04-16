package prisonersDilemma;

import java.awt.*;

public class Cooperate extends Strategy {
    @Override
    public boolean cooperate() {
        return false; // always coop
    }
    public Color getStrategyColor() {return Color.GREEN;}
}
