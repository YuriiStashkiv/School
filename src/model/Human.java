package model;

public class Human {

    private String name;
    private String surname;
    private String fathername;
    private String date;
    private boolean isMale;

    public Human(String snf, String date, boolean isMale) {
        String[] snf1 = snf.split(" ");
        surname = snf1[0];
        name = snf1[1];
        fathername = snf1[2];
        this.date = date;
        this.isMale = isMale;
    }

    public Human(String name, String surname, String fathername, String date, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.date = date;
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Human() {
        this.name = "unknown";
        this.surname = "unknown";
        this.fathername = "unknown";
        this.date = "00.00.0000";
        this.isMale = false;
    }
}
