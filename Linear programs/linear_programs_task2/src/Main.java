import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a= sc.nextDouble(), b = sc.nextDouble(), c= sc.nextDouble();
        double D = (b+Math.sqrt(b*b+4*a*c))/(2*a)-a*a*a*c+1/(b*b);
        System.out.println(D);
    }
}
