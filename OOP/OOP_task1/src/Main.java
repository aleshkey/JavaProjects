import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void rename(File file) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("new name");
        String newName = sc.nextLine();
        File newFile = new File(newName);
        if(!file.renameTo(newFile)){
            System.out.println("rename failed");
        }
    }

    public static void showData(File file) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
        while(bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }
    }

    public static void addData(File file) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("input");
        String buffer=sc.nextLine();
        FileWriter fileWriter = new FileWriter(file);
        while(!buffer.equals("stop")){
            fileWriter.write(buffer+"\n");
            buffer = sc.nextLine();
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File file = null;
        while (true) {
            System.out.println("1 - create\n2- rename\n3 - print\n4 - add\n5 - remove");
            int menu = sc.nextInt();
            switch (menu) {

                case 1: {
                    System.out.println("name");
                    sc.nextLine();
                    String name = sc.nextLine();
                    file = new File(name);
                    file.createNewFile();
                    System.out.println("file is created");
                    break;
                }
                case 2: {
                    rename(file);
                    break;
                }
                case 3:{
                    showData(file);
                    break;
                }
                case 4:{
                    addData(file);
                    break;
                }
                case 5:{
                    file.delete();
                }
            }
        }
    }
}

