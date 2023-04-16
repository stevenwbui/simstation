package prisonersDilemma;

import java.awt.*;

public class Cheat extends Strategy {

    @Override
    public boolean cooperate() {
        return true;
    }

    public Color getStrategyColor() {return Color.RED;}
}
