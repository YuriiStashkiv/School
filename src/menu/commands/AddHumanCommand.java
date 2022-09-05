package menu.commands;

import actions.Actions;
import menu.Command;

public class AddHumanCommand implements Command {

    Actions actions;

    public AddHumanCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.addHumanWithKeyboard();
    }
}
