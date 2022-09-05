package menu.commands;

import actions.Actions;
import menu.Command;

public class RemoveHumanCommand implements Command {

    Actions actions;

    public RemoveHumanCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.removeHuman();
    }
}
