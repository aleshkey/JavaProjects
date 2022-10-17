import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int buffer = sc.nextInt();
            arr.add(buffer);
        }
        int k = sc.nextInt();
        List<Integer> rez = new ArrayList();
        for (int i=0; i<n;i++){
            if(arr.get(i)%k==0){
                rez.add(arr.get(i));
            }
        }
        for(int i=0;i<rez.size();i++){
            System.out.println(rez.get(i));
        }
    }
}
