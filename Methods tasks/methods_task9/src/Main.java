import java.util.Scanner;

public class Main {
    public static double s_triangle(double a, double b, double corner){
        return 0.5*a*b*Math.sin(corner);
    }

    public static double corner(double a, double b, double c){
        double x = (b*b+c*c-a*a)/(2*b*c);
        return Math.acos(x);
    }

    public static double s4(int x,int y,int z,int t){
        double s1 = s_triangle(x,y, Math.PI/2), s2 = s_triangle(z, t, corner(Math.sqrt(x*x+x*x), z, t));
        return s1+s2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt(), y= sc.nextInt(), z= sc.nextInt(),t= sc.nextInt();
        System.out.println(s4(x,y,z,t));
    }
}
