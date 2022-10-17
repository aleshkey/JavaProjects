package realization;

import java.util.Scanner;

public class Menu {
    public static int printForAdmin(){
        System.out.println("1 - find\n2 - add\n3 - print all\n");
        return new Scanner(System.in).nextInt();
    }
    public static int printForSearch(){
        System.out.println("search by:\n1 - name\n2 - last name\n3 - group\n4 - ID\n5 - Math mark\n6 - language mark\n7 - IT mark\n");
        return new Scanner(System.in).nextInt();
    }

}
