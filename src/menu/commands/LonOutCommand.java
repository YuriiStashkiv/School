package menu.commands;

import actions.Actions;
import menu.Command;

public class LonOutCommand implements Command {

    Actions actions;

    public LonOutCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.logout();
    }
}
