import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B=sc.nextInt(), x = sc.nextInt(),y=sc.nextInt(), z= sc.nextInt();
        if ((A>=x && B>=y) || (A>=x && B>=z) || (A>=y && B>=x) || (A>=y && B>=z) || (A>=z && B>=x) || (A>=z && B>=y)){
            System.out.println("yes");
        }
        else System.out.println("no");
    }
}
