import java.util.Scanner;

public class Main {
    public static int nod(int a, int b){
        if(Math.max(a, b)%Math.min(a,b)==0 || Math.min(a,b)==1){
            return Math.min(a,b);
        }
        return nod(Math.min(a, b), (Math.max(a,b)-Math.min(a,b)));
    }

    public static int nod4(int a, int b, int c, int d){
        return nod(nod(a,b), nod(c,d));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(),b = sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
        System.out.println(nod4(a,b,c,d));
    }
}
