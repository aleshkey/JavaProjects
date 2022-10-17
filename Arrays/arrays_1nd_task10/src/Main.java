import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for (int i=0;i<(n+1)/2;i++){
            arr[i]=arr[i*2];
        }
        for(int i = (n+1)/2; i<arr.length;i++){
            arr[i]=0;
        }
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
