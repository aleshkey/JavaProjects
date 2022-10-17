import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean isFourthNumber(int x){
        if(x!=0 && x!=1){
            int count =0;
            for (int i=1; i<Math.sqrt(x);i++){
                if(x%i==0) count++;
            }
            if(x%Math.sqrt(x)==0) count++;
            if (count == 1) return true;
            return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n =sc.nextInt(),sum=0;
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        for (int i=0;i<n;i++){
            if(isFourthNumber(i)){
                sum+=arr.get(i);
            }
        }
        System.out.println(sum);
    }
}
