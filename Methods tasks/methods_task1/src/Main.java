import java.util.Scanner;

public class Main {
    public static int nod(int a, int b){
        if(Math.max(a, b)%Math.min(a,b)==0 || Math.min(a,b)==1){
            return Math.min(a,b);
        }
        return nod(Math.min(a, b), (Math.max(a,b)-Math.min(a,b)));
    }

    public static int nok(int a, int b){
        return (a*b)/nod(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b=sc.nextInt();
        System.out.println(nod(a,b));
        System.out.println(nok(a,b));
    }
}
