import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void printMenu() throws IOException {
        Treasures treasures = new Treasures();
        while (true) {
            System.out.println("1 - print\n2 - find max\n3 - find by sum");
            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();
            switch (menu){
                case 1:{
                    treasures.showTreasures();
                    break;
                }
                case 2:{
                    treasures.chooseTheMostExpensive();
                    break;
                }
                case 3:{
                    treasures.searchForGivenAmount();
                    break;
                }
            }
        }
    }
}
