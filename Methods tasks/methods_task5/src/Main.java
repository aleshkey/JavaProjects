import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int max(List<Integer> arr){
        int max=arr.get(0), nummax=0;
        for(int i=1;i<arr.size();i++){
            if (arr.get(i)>max){
                max=arr.get(i);
                nummax=i;
            }
        }
        return nummax;
    }

    public static int sndmax(List<Integer> arr){
            int nummax =max(arr);
            arr.remove(nummax);
            nummax=max(arr);
            return arr.get(nummax);
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<Integer> arr =new ArrayList();
        int n=sc.nextInt();
        for (int i = 0;i<n;i++){
            arr.add(sc.nextInt());
        }
        System.out.println(sndmax(arr));
    }
}
