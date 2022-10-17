import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int countplus =0, countminus=0, countnull=0,n= sc.nextInt();
        for (int i =0;i<n;i++){
            int buffer = sc.nextInt();
            arr.add(buffer);
        }
        for (int i =0;i<n;i++){
            if(arr.get(i)>0) countplus++;
            if (arr.get(i)<0) countminus++;
            if(arr.get(i)==0) countnull++;
        }
        System.out.println(countminus+", "+countnull+", "+countplus);
    }
}
