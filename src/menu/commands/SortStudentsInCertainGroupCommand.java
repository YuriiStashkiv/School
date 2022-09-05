package menu.commands;

import actions.Actions;
import menu.Command;

public class SortStudentsInCertainGroupCommand implements Command {

    Actions actions;

    public SortStudentsInCertainGroupCommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.sortStudentsInCertainGroup();
    }
}
