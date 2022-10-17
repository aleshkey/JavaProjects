package realization;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    public static void printForAdmin() throws IOException, MessagingException {
        Library library = new Library();
        while(true) {
            System.out.println("1 - add");
            switch (sc.nextInt()) {
                case 1: {
                    library.addBookForAdmin();
                    break;
                }
            }
        }
    }

    public static void printForUser() throws IOException, InterruptedException {
        while (true){
            Library library = new Library();
            System.out.println("1 - view\n2 - search\n3 - suggestion for adding");
            switch (sc.nextInt()){
                case 1:{
                    library.printBooks();
                    break;
                }
                case 2:{
                    library.searchForBook();
                    break;
                }
            }
        }
    }
}
