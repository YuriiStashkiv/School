package menu;

public class CommandExecutor{

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
