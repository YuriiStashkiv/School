package menu.commands;

import actions.Actions;
import menu.Command;

public class FillFromFileCommand implements Command {
    Actions actions;

    public FillFromFileCommand(Actions actions) {
        this.actions = actions;
    }


    @Override
    public void execute() {
        actions.fillFromFile();
    }
}
