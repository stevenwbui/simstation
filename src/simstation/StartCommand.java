package simstation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() throws Exception {
        if (!(model instanceof Simulation)) {
            throw new Exception("Model must instantiate Simulation");
        }
        Simulation sim = (Simulation)model;
        sim.start();
    }
}
