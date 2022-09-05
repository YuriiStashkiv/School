package menu.commands;

import actions.Actions;
import menu.Command;

public class ShowGroupsСommand implements Command {
    Actions actions;

    public ShowGroupsСommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.showGroups();
    }
}
