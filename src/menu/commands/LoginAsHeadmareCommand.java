package menu.commands;

import actions.Actions;
import menu.Command;

public class LoginAsHeadmareCommand implements Command {

    Actions actions;

    public LoginAsHeadmareCommand(Actions actions) {
        this.actions = actions;
    }

    public void execute() {
        actions.login();
    }
}
