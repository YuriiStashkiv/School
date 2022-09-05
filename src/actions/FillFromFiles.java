package actions;

import model.Group;
import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FillFromFiles extends Actions{
    public ArrayList<Group> fill() {
        Scanner sc;
        try {
            String file = "src/resources/Groups.txt";
            sc = new Scanner(new File(file));
            sc.useDelimiter(" ");
            for (int i = 1; sc.hasNext(); i++){
                groups.add(new Group(Integer.parseInt(sc.next())));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }
}
