import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n =sc.nextInt();
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        for(int i =0;i<n;i++){
            if(arr.get(i)>i){
                System.out.print(arr.get(i)+" ");
            }
        }
    }
}
