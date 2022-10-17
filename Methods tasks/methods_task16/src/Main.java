import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int countChet(int x){
        int count=0;
        while(x>=1){
            if(x%10%2==0){
                count++;
            }
            x=x/10;
        }
       return count;
    }

    public static int sumArr(List<Integer> arr){
        int sum=0;
        for (int i=0; i<arr.size();i++){
            if(countChet(arr.get(i))==0){
                sum+=arr.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        int sum = sumArr(arr);
        System.out.println(sum+" "+countChet(sum));
    }
}
