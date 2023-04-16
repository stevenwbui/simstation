package prisonersDilemma;

import java.awt.*;

public abstract class Strategy {
    private Prisoner myPrisoner;
    public boolean cooperate() {return false;}
    public void setMyPrisoner(Prisoner myPrisoner) {
        this.myPrisoner = myPrisoner;
    }

    public Color getStrategyColor() {return Color.WHITE;}
}
