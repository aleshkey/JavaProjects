import data.Student;
import realization.FileWork;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = FileWork.read();
        System.out.println();
    }
}
