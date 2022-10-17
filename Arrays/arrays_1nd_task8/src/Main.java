import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n= sc.nextInt(), min;
        for(int i = 0;i<n;i++){
            arr.add(sc.nextInt());
        }
        min=arr.get(0);
        for(int i=0;i<n;i++){
            if(min>arr.get(i)){
                min=arr.get(i);
            }
        }
        for(int i= 0;i<arr.size();i++){
            if (arr.get(i)==min){
                arr.remove(i);
            }
        }
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
