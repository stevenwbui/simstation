package prisonersDilemma;

import java.awt.*;

public class Tit4Tat extends Strategy {
    private Prisoner myPrisoner;
    @Override
    public boolean cooperate() {
        if (!myPrisoner.partnerCheated) {
            return false;
        }
        return true;
    }

    public void setMyPrisoner(Prisoner myPrisoner) {
        this.myPrisoner = myPrisoner;
    }

    public Color getStrategyColor() {return Color.PINK;}
}
