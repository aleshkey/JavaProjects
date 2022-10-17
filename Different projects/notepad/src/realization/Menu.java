package realization;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    private static Notes notes;

    static {
        try {
            notes = new Notes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Menu() throws IOException {
    }

    public static void print() throws IOException, ParseException {
        while (true) {
            System.out.println("1 - add note\n2 - search");
            int menu = new Scanner(System.in).nextInt();
            switch (menu) {
                case 1: {
                    notes.addNote();
                    break;
                }
                case 2: {
                    notes.search();
                    break;
                }
            }
        }
    }

    public static void printForSearching(){
        System.out.println("search for:\n0 - exit\n1 - title\n2 - date\n3 - e-mail\n4 - body");
    }
}
