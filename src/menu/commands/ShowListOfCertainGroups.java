package menu.commands;

import actions.Actions;
import menu.Command;

public class ShowListOfCertainGroups implements Command {

    Actions actions;

    public ShowListOfCertainGroups(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.showListOfCertainGroups();
    }
}
