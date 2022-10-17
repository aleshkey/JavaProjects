import java.util.Scanner;
public class Main {
    public static int nod(int a, int b){
        if(Math.max(a, b)%Math.min(a,b)==0 || Math.min(a,b)==1){
            return Math.min(a,b);
        }
        return nod(Math.min(a, b), (Math.max(a,b)-Math.min(a,b)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(),b= sc.nextInt(),c=sc.nextInt();
        if (nod(a,b)==1 && nod(a,c)==1 && nod(b,c)==1){
            System.out.println("yes");
        }
        else System.out.println("no");
    }
}