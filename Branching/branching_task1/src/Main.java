import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int frstcorner =  sc.nextInt(), scndcorner = sc.nextInt();
        boolean kod = true;
        if (frstcorner+scndcorner>180){
            System.out.println("not exists");
        }
        else {
            System.out.println("exists");
            if ((frstcorner == 90 | scndcorner == 90 | (frstcorner + scndcorner == 90))) {
                System.out.println("this is a right triangle");
            }
        }
    }
}