import data.Student;
import realization.FileWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static ArrayList<Student>students= FileWork.read();
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void search() throws IOException {
        int kod = Integer.parseInt(in.readLine());// ждём пока клиент что-нибудь нам напишет
        String info = in.readLine();
        String buffer="";
        Student bufferStud = new Student();
        switch (kod)
        {
            case 1: {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getName().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
            case 2:{
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getLast_name().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
            case 3:{
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getGroup().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
            case 4:{
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
            case 5:{
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getMark_math().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
            case 6:{
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getMark_language().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
            case 7:{
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getMark_IT().equals(info)) {
                        out.write(students.get(i).toString()+"\n");
                    }
                }
                break;
            }
        }
    }

    public static void add(){

    }

    public static void printAll() throws IOException {
        for (int i=0; i <students.size();i++) {
            out.write(students.get(i).toString()+"\n");
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                try {
                    server = new ServerSocket(4004);
                    System.out.println("on");
                    clientSocket = server.accept();
                    try {
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        int kod = Integer.parseInt(in.readLine());
                        switch (kod) {
                            case 1: {
                                search();
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3:{
                                printAll();
                                break;
                            }
                        }
                        out.flush();
                    } finally { // в любом случае сокет будет закрыт
                        clientSocket.close();
                        // потоки тоже хорошо бы закрыть
                        in.close();
                        out.close();
                    }
                } finally {
                    System.out.println("closed!");
                    server.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}