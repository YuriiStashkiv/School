import actions.Actions;
import controllers.Controller;

public class Main {
    public static void main(String[] args) {
        Actions actions = new Actions();
        new Controller().startProgram(actions);
    }
}
