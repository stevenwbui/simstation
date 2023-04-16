package prisonersDilemma;

import mvc.Model;
import plague.PlagueSimulation;
import simstation.SimStationFactory;

public class PrisonerFactory extends SimStationFactory {
    public Model makeModel() { return new PrisonerSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma";}
}
