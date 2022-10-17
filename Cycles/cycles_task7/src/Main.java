import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static int[] allDividers(int a){
        List<Integer> rez = new ArrayList<>();
        for (int i = 2; i < Math.sqrt(a); i++) {
            if(a % i==0){
                rez.add(i);
            }
        }
        int x = rez.size();
        for(int i=0;i<x;i++){
            rez.add(a/rez.get(i));
        }
        if (a%Math.sqrt(a)==0){
            rez.add((int)Math.sqrt(a));
        }
        int[] Rez = new int[rez.size()];
        for(int i=0; i<rez.size();i++){
            Rez[i] = rez.get(i);
        }
        return Rez;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n= sc.nextInt();
        for(int j =m; j<=n;j++){
            int[] dividers = allDividers(j);
            for(int i =0; i<dividers.length; i++){
                System.out.print(dividers[i]+" ");
            }
            System.out.println();
        }
    }
}
