import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), max;
        List<Integer> arr = new ArrayList();
        for (int i =0; i<n; i++){
            arr.add(sc.nextInt());
        }
        max=arr.get(0)+arr.get(1);
        for(int i = 1; i<n-1;i++){
            if(max < arr.get(i)+arr.get(i+1)){
                max = arr.get(i)+arr.get(i+1);
            }
        }
        System.out.println(max);
    }
}
