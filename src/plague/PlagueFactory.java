package plague;

import mvc.Model;
import simstation.SimStationFactory;

public class PlagueFactory extends SimStationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague Simulator";}
}
