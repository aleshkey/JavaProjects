import java.util.Scanner;

public class Main {
    public static double striangle(int a){
        return 0.5*a*a*Math.sin(Math.PI/3);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(6*striangle(a));
    }
}
