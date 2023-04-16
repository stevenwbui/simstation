package simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() throws Exception {
        if (!(model instanceof Simulation)) {
            throw new Exception("Model must instantiate Simulation");
        }
        Simulation sim = (Simulation)model;
        Utilities.inform(sim.getStats());
    }
}