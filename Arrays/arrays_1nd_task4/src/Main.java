import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n = sc.nextInt(), min, max, numbermin=0,numbermax=0;
        for(int i =0; i<n;i++){
           arr.add(sc.nextInt());
        }
        min= arr.get(0);
        max=arr.get(0);
        for(int i =1;i<arr.size();i++){
            if(arr.get(i)<min) {
                min=arr.get(i);
                numbermin=i;
            }
            if(arr.get(i)>max){
                max=arr.get(i);
                numbermax=i;
            }
        }
        arr.set(numbermin,max);
        arr.set(numbermax, min);
        for (int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
