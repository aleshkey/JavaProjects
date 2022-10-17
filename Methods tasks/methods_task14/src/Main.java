import java.util.Scanner;

public class Main {
    public static int hasNumbers(int x){
        int count =0;
        while (x>=1){
            count ++;
            x=x/10;
        }
        return count;
    }

    public static int sumNumbers(int x){
        int sum =0;
        while (x>=1){
             sum+=x%10;
            x=x/10;
        }
        return sum;
    }

    public static void allArmstrong(int k){
        for  (int i=1; i<=k;i++){
            if (Math.pow(sumNumbers(i), hasNumbers(i)) == i){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int k = sc.nextInt();
       allArmstrong(k);
    }
}
