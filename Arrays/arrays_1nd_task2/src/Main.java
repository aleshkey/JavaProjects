import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n = sc.nextInt(), z = sc.nextInt(), count =0;
        for (int i=0; i<n; i++){
            int buffer = sc.nextInt();
            arr.add(buffer);
        }
        for(int i =0; i<arr.size(); i++){
            if(arr.get(i)>z){
                arr.set(i,z);
                count++;
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        System.out.println(count);
    }
}
