import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int hours = (int)(T/3600);
        T = T-hours*3600;
        int minutes = (int)(T/60);
        T = T - minutes*60;
        System.out.println(hours+"h "+minutes+"min "+T+"c");
    }
}
