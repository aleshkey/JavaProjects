import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble(), y = sc.nextDouble();
        if (x!=0 && y!=-1){
            if (Math.abs(x)<4 && y>-3 && y<0){
                System.out.println(true);
            } else if (Math.abs(x)<2 && y>0 && y<4) {
                System.out.println(true);
            }else System.out.println(false);
        }
        else System.out.println("false");
    }
}
