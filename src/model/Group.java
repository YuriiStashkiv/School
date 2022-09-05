package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Group {

    private int group;
    private HashMap<Integer, Student> students;
    private ArrayList<String> subjects;

    public Group(int group, HashMap<Integer, Student> students, ArrayList<String> subjects) {
        this.group = group;
        this.students = students;
        this.subjects = subjects;
    }

    public Group(int group) {
        this.group = group;
        this.students = new HashMap<>();
        this.subjects = new ArrayList<>();
    }

    public Group() {
        this.group = 0;
        this.students = new HashMap<>();
        this.subjects = new ArrayList<>();
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Integer, Student> students) {
        this.students = students;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public void addStudentToGroup(Student student) {
        students.put(students.size(), student);
    }

    public void addSubjectsToGroup(String subject) {
        subjects.add(subject);
    }

    public int getSizeStudents() {
        return students.size();
    }

    public void showStudentsList() {
        System.out.println("Students list of group " + this.getGroup());
        for (int i = 0; i < this.getSizeStudents(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(this.getStudents().get(i).getSurname() + " " +
                    this.getStudents().get(i).getName() + " " +
                    this.getStudents().get(i).getFathername() + "\n" + "Birthday at: " +
                    this.getStudents().get(i).getDate());
        }
    }
}
