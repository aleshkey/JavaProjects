import java.util.Scanner;
public class Main {

    public static double func1(double x){
        return (Math.pow(x,2)-3*x+9);
    }

    public static double func2(double x){
        return 1/(Math.pow(x,3)+6);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        if (x<=3){
            System.out.println(func1(x));
        }
        else System.out.println(func2(x));
    }
}
