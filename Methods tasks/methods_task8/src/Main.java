import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int sum(List<Integer> arr, int start, int end){
        int s =0;
        for (int i=start; i<=end;i++){
            s+=arr.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n= sc.nextInt();
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        try {
            System.out.println(sum(arr, 0, 2));
            System.out.println(sum(arr, 2, 4));
            System.out.println(sum(arr, 4, 5));
        }
        catch (Exception exception){
            System.out.println("there isnt such element");
        };
    }
}
