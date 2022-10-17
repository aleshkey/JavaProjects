import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble(), y= sc.nextDouble();
        double chisl = Math.sin(x)+Math.cos(y);
        double znam = Math.cos(x)-Math.sin(y);
        System.out.println(chisl/znam*Math.tan(x*y));
    }
}
