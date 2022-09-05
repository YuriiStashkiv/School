package model;

public class Student extends Human {

    private int groupe;

    public Student(String snf, String date, boolean isMale, int groupe) {
        super(snf, date, isMale);
        this.groupe = groupe;
    }

    public Student(String surname, String name, String fathername, String date, boolean isMale, int groupe) {
        super(name, surname, fathername, date, isMale);
        this.groupe = groupe;
    }
}
