package realization;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;



public class Library {
    private ArrayList<String> books = new ArrayList<String>();
    private Scanner sc = new Scanner(System.in);
    Session session;

    public Library() throws IOException {
        File file = new File("D:\\java\\library\\src\\data\\library\\library.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while(bufferedReader.ready()){
                books.add(bufferedReader.readLine());
        }
    }

    public void addBookForAdmin() throws IOException, MessagingException {
        System.out.println("enter info about new book");
        String newBook = sc.nextLine();
        books.add(newBook);
        File file = new File("D:\\java\\library\\src\\data\\library\\library.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();
        bufferedWriter.write(newBook);
        bufferedWriter.close();
        new JavaEmail().sendEmailForAdmin(newBook);
        //sendToGmailForAdmin("lesha.and.android@gmail.com", newBook);
    }

    /*private void sendToGmailForAdmin(String yourEmail, String newBook) throws IOException, MessagingException {
        Properties properties = new Properties();
        properties = System.getProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user","ajavatest1@gmail.com");
        properties.put("mail.smtp.port" ,"587");
        properties.put("mail.debug", "true");

        session = javax.mail.Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ajavatest1@gmail.com", "123123125");
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ajavatest1@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(yourEmail));
        message.setSubject("New Book");
        message.setText(newBook);

        Transport.send(message);
    }*/

    public void printBooks() throws IOException, InterruptedException {
        int kod=5, start=0, i =0, menu = 0;
        while(menu != 3 && start >= 0) {
            if (start + kod > books.size()) {
                for (i = start; i < books.size(); i++) {
                    System.out.println(books.get(i));
                }
            }
            else {
                for (i = start; i < start + kod; i++) {
                    System.out.println(books.get(i));
                }
            }
            System.out.println("1 - next book       2 - previous book\n3 - back to the menu ");
            menu = sc.nextInt();
            switch (menu) {
                case 1: {
                    start = i;
                    break;
                }
                case 2: {
                    start = start - kod;
                    break;
                }
                case 3: {
                    Menu.printForUser();
                    break;
                }
                default:
                    System.out.println("incorrect input");
            }
        }
    }

    public void searchForBook(){
        System.out.println("enter some info");
        String info = sc.nextLine();
        for(int i = 0; i < books.size(); i++){
            if (books.get(i).contains(info)){
                System.out.println(books.get(i));
            }
        }
    }
}
