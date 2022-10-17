import java.util.Scanner;

public class Main {
    public static int hasNumbers(int x){
        int count =0;
        while (x>1){
            count ++;
            x=x/10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt(), y= sc.nextInt();
        if (hasNumbers(x)>hasNumbers(y)){
            System.out.println("first");
        }
        else {
            if (hasNumbers(x)==hasNumbers(y)){
                System.out.println("both");
            }
            else System.out.println("second");
        }
    }
}
