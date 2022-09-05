package controllers;

import actions.Actions;
import menu.Command;
import menu.CommandExecutor;
import menu.commands.*;

import java.util.Scanner;

public class ControllerHeadmare {
    private CommandExecutor executor = new CommandExecutor();
    private Command command;

    public void startProgram(Actions actions) {
        int valueCommands = showCommandList();
        int choice = userNumber(valueCommands);
        while (true) {
            switch (choice) {
                case 1:
                    command = new ShowGroupsСommand(actions);
                    break;
                case 2:
                    command = new ShowListOfCertainGroups(actions);
                    break;
                case 3:
                    command = new SearchForStudentsСommand(actions);
                    break;
                case 4:
                    command = new AddHumanCommand(actions);
                    break;
                case 5:
                    command = new FillFromFileCommand(actions);
                    break;
                case 6:
                    command = new RemoveHumanCommand(actions);
                    break;
                case 7:
                    command = new SortStudentsInCertainGroupCommand(actions);
                    break;
                case 8:
                    command = new LonOutCommand(actions);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
            executor.setCommand(command);
            executor.execute();
            showCommandList();
            choice = userNumber(valueCommands);
        }
    }

    private int userNumber(int valueCommands) {
        System.out.print("Your choose: ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.print("Error. Try again: ");
        }
        int choose = sc.nextInt();
        while (choose > valueCommands && choose < 0) {
            System.out.println("Unknown command. Try again: ");
            while (!sc.hasNextInt()) {
                System.out.println("Error. Try again: ");
            }
            choose = sc.nextInt();
        }
        return choose;
    }

    private int showCommandList() {
        System.out.println();
        System.out.println(" School menu ");
        System.out.println();
        System.out.println("1. Show list of groups.");
        System.out.println("2. Show list of students/teachers of certain group.");
        System.out.println("3. Search for student.");
        System.out.println("4. Add new student");
        System.out.println("5. Add students from file...");
        System.out.println("6. Remove student");
        System.out.println("7. Sort students in certain group");
        System.out.println("8. Logout.");
        System.out.println("0. Exit from program. ");
        return 9;
    }
}
