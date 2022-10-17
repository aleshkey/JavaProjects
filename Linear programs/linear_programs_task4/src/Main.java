import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        int celChast = (int)a;
        int drobnChast = (int)((a-celChast)*1000);
        System.out.println(drobnChast+"."+celChast);
    }
}
