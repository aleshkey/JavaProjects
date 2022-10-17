package realization;

import data.Student;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket; //����� ��� �������
    private static BufferedReader reader; // ��� ����� ����� �������� � �������, ����� ���
    // �� ������ ��� ����� ������� ������?
    private static BufferedReader in; // ����� ������ �� ������
    private static BufferedWriter out; // ����� ������ � �����

    public static void main(String[] args) {
        try {
            try {
                int kod;
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                // ������ ���������� � �������
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // ������ ���� ��
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                int menu = Menu.printForAdmin();
                out.write(menu + "\n");
                out.flush();
                switch (menu) {
                    case 1: {
                        kod = Menu.printForSearch();
                        String info = reader.readLine();
                        out.write(kod + "\n");
                        out.write(info + "\n");
                        out.flush();
                        while (in.ready()) {
                            String serverStudent = in.readLine();
                            System.out.println(serverStudent);
                        }
                        break;
                    }
                    case 3:{
                        while(in.ready()){
                            System.out.println(in.readLine());
                        }
                        break;
                    }
                }
            } finally { // � ����� ������ ���������� ������� ����� � ������
                System.out.println("client closed");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}