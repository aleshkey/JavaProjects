import java.util.Scanner;
public class Main {
    public static double func(double x){
        return 1/(Math.pow(2,x))+1/(Math.pow(3,x));
    }

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          double e=sc.nextDouble(), sum=0;
          int n =0;
          while(e<=func(n)){
              sum+=func(n);
              n++;
          }
        System.out.println(sum);
    }
}
