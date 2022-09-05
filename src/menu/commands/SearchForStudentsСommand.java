package menu.commands;

import actions.Actions;
import menu.Command;

public class SearchForStudentsСommand implements Command {
    Actions actions;
    public SearchForStudentsСommand(Actions actions) {
        this.actions = actions;
    }

    @Override
    public void execute() {
        actions.searchForStudents();
    }
}
