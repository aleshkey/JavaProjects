package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Students {
    private ArrayList<Student> students= new ArrayList<Student>();

    public Students() {

        File dir = new File("./src/main/java/database"); //path указывает на директорию
        File[] arrFiles = dir.listFiles();
        List<File> files = Arrays.asList(arrFiles);
        for(File file : files){
            Student student = new Student();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (bufferedReader.ready()) {
                    student.setLastName(String.valueOf(bufferedReader.readLine()));
                    student.setAge(Integer.parseInt(bufferedReader.readLine()));
                    student.setHasDebts(Boolean.valueOf(bufferedReader.readLine()));
                    students.add(student);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void save(Student student){
        File file = new File("./src/main/java/database/"+student.getLastName());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(student.getLastName()+"\n"+student.getAge()+"\n" + student.isHasDebts());
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean exist (String lastName){
        for(Student s : students){
             if (s.getLastName().equals(lastName)){
                 return true;
             }
        }
        return false;
    }

    public void add(Student student) {
        if(!exist(student.getLastName())) {
            students.add(student);
            save(student);
        }
        else System.out.println("this student already exists");
    }

    public double getAverageAge(){
        double sum =0;
        for(Student s : students){
            sum += s.getAge();
        }
        return sum/students.size();
    }

    public int getNumberOfDebtors(){
        int res =0;
        for(Student s : students){
            if (s.isHasDebts()){
                res++;
            }
        }
        return res;
    }

    public void change(Student student) {

        for(Student s : students){
            if (s.getLastName().equals(student.getLastName())){
                s.setAge(student.getAge());
                s.setHasDebts(student.isHasDebts());
                student = s;
            }
        }
        save(student);
    }

    public void delete (String lastName){
        if (exist(lastName)) {
            File file = new File("./src/main/java/database/" + lastName);
            file.delete();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getLastName().equals(lastName)) {
                    students.remove(i);
                }
            }
        }
        else
            System.out.println("there is no such student");
    }

    @Override
    public String toString(){
        String s = "";
        for(Student student : students){
            s+=student.getLastName()+"\n"+String.valueOf(student.getAge())+"\n"+String.valueOf(student.isHasDebts())+"\n\n";
        }
        return s;
    }
}
