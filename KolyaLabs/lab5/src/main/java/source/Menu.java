package source;

import models.Student;
import models.Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Menu {

    private static Students students = new Students();
    private static void start(int kod){
        switch (kod){

            case 1:{
                Student student = new Student();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    System.out.println("Enter the last name of student\n");
                    student.setLastName(br.readLine());
                    System.out.println("Enter the age of student\n");
                    student.setAge(Integer.parseInt(br.readLine()));
                    System.out.println("Student has debts? (true/false)\n");
                    student.setHasDebts(Boolean.parseBoolean(br.readLine()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                students.add(student);
                break;
            }

            case 2:{
                System.out.println("Enter the last name of student\n");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String lastName = br.readLine();
                    students.delete(lastName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            case 3:{
                Student student = new Student();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    System.out.println("Enter the last name of student\n");
                    student.setLastName(br.readLine());
                    System.out.println("Enter the age of student\n");
                    student.setAge(Integer.parseInt(br.readLine()));
                    System.out.println("Student has debts? (true/false)\n");
                    student.setHasDebts(Boolean.parseBoolean(br.readLine()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                students.change(student);
                break;
            }

            case 4:{
                System.out.println(students);
                break;
            }

            case 5:{
                System.out.println(students.getAverageAge()+"\n"+ students.getNumberOfDebtors()+"\n");
            }

            default:
                System.out.println("incorrect info");
        }
    }
    public static void print() {
        while (true) {
            System.out.println("1 - add student\n" +
                    "2 - remove student\n" +
                    "3 - change info about student\n" +
                    "4 - print info\n" +
                    "5 - individual task\n");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int kod;
            try {
                kod = Integer.parseInt(br.readLine()); // for Integer Input
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            start(kod);
        }
    }


}
