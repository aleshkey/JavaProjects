import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1=sc.nextDouble(),y1=sc.nextDouble(),x2=sc.nextDouble(),y2=sc.nextDouble(),x3=sc.nextDouble(),y3=sc.nextDouble();
        double k = (y1-y2)/(x1-x2), b = y1-k*x1;
        if(y3 == k*x3+b){
            System.out.println("is line");
        }
        else System.out.println("isnt line");
    }
}
