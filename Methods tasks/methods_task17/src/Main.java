import java.util.Scanner;

public class Main {
    public static int sumNumbers(int x){
        int sum = 0;
        while (x>=1){
            sum+=x%10;
            x/=10;
        }
        return sum;
    }

    public static int razn(int x, int count){
        count++;
        x= x-sumNumbers(x);
        if(x==0){
            return count;
        }

        return  razn(x, count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(razn(n, 0));
    }
}
