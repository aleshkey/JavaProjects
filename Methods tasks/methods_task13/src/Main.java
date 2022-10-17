import java.util.Scanner;

public class Main {
    public static boolean isNum(int n){
        int count =0;
        for (int i=1; i<=Math.sqrt(n);i++){
            if (n%i==0) count++;
        }
        if (count==1) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt(), count =0;
        for (int i =n; i<=2*n;i++){
            if (isNum(i) && isNum(i+2) && i+2<2*n){
                System.out.println(i+" " + (i+2));
            }
        }
    }
}
