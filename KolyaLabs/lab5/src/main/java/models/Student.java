package models;

public class Student {

    public Student() {
    }

    private String lastName;
    private int age;
    private boolean hasDebts;

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasDebts() {
        return hasDebts;
    }

    public void setHasDebts(boolean hasDebts) {
        this.hasDebts = hasDebts;
    }
}
