package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimStationFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model m) {
        return new SimulationView((Simulation) m);
    }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Click Start to start a new simulation.", "Click Suspend to pause the simulation.", "Click Resume to continue the paused simulation.",
                "Click Stop to end the simulation.", "Click stats to view the simulation's statistics."};
    }

    @Override
    public String about() {
        return "SimStation Simulator version 1.0. Copyright 2023 by Steven Bui, Michael Chu, Ashna Pattanayak";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Start") {
            return new StartCommand(model);
        }
        else if (type == "Suspend") {
            return new SuspendCommand(model);
        }
        else if (type == "Resume") {
            return new ResumeCommand(model);
        }
        else if (type == "Stop") {
            return new StopCommand(model);
        }
        else if (type == "Stats") {
            return new StatsCommand(model);
        }
        return null;
    }
}
