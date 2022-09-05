package actions;

import controllers.Controller;
import controllers.ControllerHeadmare;
import model.*;
import scanner.Scaner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Actions {
    public ArrayList<Group> groups = new ArrayList<>();

    Scaner in = new Scaner();

    public void login() {
        Scanner sc;
        String login, password;
        try {
            String file = "src/resources/LoginAndPassword.txt";
            sc = new Scanner(new File(file));
            sc.useDelimiter(" |;");
            ArrayList<String> dataFile = new ArrayList<>();
            while (sc.hasNext()) {
                dataFile.add(sc.next());
            }
            System.out.println("Login: ");
            login = in.anString();
            System.out.println("Password: ");
            password = in.anString();
            if (login.equals(dataFile.get(1)) && password.equals(dataFile.get(3))) {
                System.out.println("Access allowed\n");
                System.out.println("Welcome Headmare!");
                new ControllerHeadmare().startProgram(this);
            } else {
                System.out.println("Access denied\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void logout() {
        Scanner sc;
        System.out.println("Are you sure?(Y/N) ");
        if (in.anString().equalsIgnoreCase("Y")) {
            try {
                String file = "src/resources/LoginAndPassword.txt";
                sc = new Scanner(new File(file));
                sc.useDelimiter(" |;");
                ArrayList<String> dataFile = new ArrayList<>();
                while (sc.hasNext()) {
                    dataFile.add(sc.next());
                }
                System.out.println("Please confirm your password: ");
                if (in.anString().equals(dataFile.get(3))) {
                    System.out.println("See you later, Headmare!");
                    new Controller().startProgram(this);
                } else {
                    System.out.println("It's wrong");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Keep working...");
        }
    }

    public void addHumanWithKeyboard() {
        String nsf, date;
        boolean isMale = false;
        System.out.println("Enter Surname, Name and Fathername: ");
        nsf = in.anString();
        System.out.println("Date of birth format(dd.MM.yyyy): ");
        date = in.anString();
        System.out.println("Sex:\n1 - male; 2 - female ");
        int chooseSex = in.anInt();
        if (chooseSex == 1) isMale = true;
        System.out.println("Which grade? (1-11): ");
        int group = in.anInt();
        Student student = new Student(nsf, date, isMale, group);
        Group thisGroup = groupIsExist(group);
        thisGroup.addStudentToGroup(student);
    }

    private Group groupIsExist(int group) {
        if (groups.size() == 0) {
            groups = new FillFromFiles().fill();
        }
        return groups.get(group - 1);
    }

    public void removeHuman() {
        Group thisGroup = chooseGroup();
        System.out.println("Enter Surname, Name or Fathername: ");
        String snf = in.anString();
        for (int i = 0; thisGroup.getSizeStudents() > i; i++) {
            if (searchStudent(thisGroup, i, snf)) {
                System.out.println(thisGroup.getStudents().get(i).getSurname() + " " +
                        thisGroup.getStudents().get(i).getName() + " " +
                        thisGroup.getStudents().get(i).getFathername());
                System.out.println("Remove this student? (Y/N)");
                if (in.anString().equalsIgnoreCase("Y")) {
                    thisGroup.getStudents().remove(i);
                    break;
                }

            }
            if (i == thisGroup.getSizeStudents()){
                System.out.println("Can't find this student, sorry...");
            }
        }
    }

    public void searchForStudents() {
        System.out.println("Search student by name(1) or ID(2)?");
        int choice = in.anInt();
        Group thisGroup = chooseGroup();
        if (choice == 1) {
            System.out.println("Enter Surname, Name or Fathername: ");
            String snf = in.anString();
            for (int i = 0; thisGroup.getSizeStudents() > i; i++) {
                if (searchStudent(thisGroup, i, snf)) {
                    System.out.println(thisGroup.getStudents().get(i).getSurname() + " " +
                            thisGroup.getStudents().get(i).getName() + " " +
                            thisGroup.getStudents().get(i).getFathername() + "\n" + "Birthday at: " +
                            thisGroup.getStudents().get(i).getDate());
                    break;
                }
                if (i == thisGroup.getSizeStudents()){
                    System.out.println("Can't find this student, sorry...");
                }
            }
        } else {
            System.out.println("Enter student number: ");
            int id = in.anInt();
            if (thisGroup.getStudents().get(id) != null){
                System.out.println(thisGroup.getStudents().get(id).getSurname() + " " +
                        thisGroup.getStudents().get(id).getName() + " " +
                        thisGroup.getStudents().get(id).getFathername() + "\n" + "Birthday at: " +
                        thisGroup.getStudents().get(id).getDate());
            } else System.out.println("Can't find this student, sorry...");
        }
    }

    private boolean searchStudent(Group group, int id, String snf) {
        if (group.getStudents().get(id).getName().equalsIgnoreCase(snf)) return true;
        else if (group.getStudents().get(id).getSurname().equalsIgnoreCase(snf)) return true;
        else if (group.getStudents().get(id).getFathername().equalsIgnoreCase(snf)) return true;
        else return false;
    }

    public void showGroups() {
        if (groups.size() == 0) {
            groups = new FillFromFiles().fill();
        }
        System.out.println("List of groups: ");
        for (int i = 0; i < groups.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(groups.get(i).getSizeStudents());
        }
    }

    public void showListOfCertainGroups() {
        Group gr = chooseGroup();
        gr.showStudentsList();
    }

    public void fillFromFile() {
        Scanner sc;
        String file = "src/resources/Students.txt";
        try {
            sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                int group;
                Student student = new Student(sc.next(), sc.next(), sc.next(), sc.next(),
                        true, group = Integer.parseInt(sc.next()));
                Group thisGroup = groupIsExist(group);
                thisGroup.addStudentToGroup(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Group chooseGroup() {
        System.out.println("Which grade? (1-11): ");
        int choice = in.anInt();
        while (choice > 11 || choice < 1) {
            System.out.println("It's a school only with 11 grades. Try again: ");
            choice = in.anInt();
        }
        return groupIsExist(choice);
    }

    public void sortStudentsInCertainGroup() {

        Group gr = chooseGroup();
        Sort sort = new Sort();

        int minLettersInSurmane = 10;
        for (int i = 0; gr.getSizeStudents() > i; i++) {
            char[] lettersInSurmane = gr.getStudents().get(i).getSurname().toCharArray();
            if (minLettersInSurmane > lettersInSurmane.length) {
                minLettersInSurmane = lettersInSurmane.length;
            }
        }

        char[][] letters = new char[gr.getSizeStudents()][minLettersInSurmane];
        for (int a = 0; gr.getSizeStudents() > a; a++) {
            char[] lettersInSurmane = gr.getStudents().get(a).getSurname().toCharArray();
            for (int b = 0; minLettersInSurmane > b; b++) {
                letters[a][b] = lettersInSurmane[b];
            }
        }

        String[] toSort = new String[gr.getSizeStudents()];
        HashMap<Integer, String> tempera = new HashMap<>();
        for (int a = 0; gr.getSizeStudents() > a; a++) {
            StringBuilder temp = new StringBuilder();
            for (int b = 0; minLettersInSurmane > b; b++) {
                temp.append(letters[a][b]);
            }
            toSort[a] = temp.toString();
            tempera.put(a, temp.toString());
        }

        sort.radixSort(toSort, 26, toSort[0].length());

        HashMap<String, Integer> tempera1 = new HashMap<>();
        for (int a = 0; gr.getSizeStudents() > a; a++) {
            for (int b = 0; toSort.length > b; b++) {
                if (tempera.get(a).equalsIgnoreCase(toSort[b])) {
                    tempera1.put(toSort[b], b);
                }
            }
        }


        HashMap<Integer, Student> students = gr.getStudents();
        Student student, temp;
        int a = 0;
        student = students.get(a);
        for (int i = 0; gr.getSizeStudents() > i; i++) {
            temp = students.get(tempera1.get(tempera.get(a)));
            students.put(tempera1.get(tempera.get(a)), student);
            student = temp;
            if (a != tempera1.get(tempera.get(a))) {
                a = tempera1.get(tempera.get(a));
            } else {
                a++;
            }
        }
    }
}
