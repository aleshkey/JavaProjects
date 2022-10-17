import java.util.Scanner;

public class Main {
    public static int[] createNumber(int n){
        int[] rez = new int[10-n];
        int startNumber =1, count;
        for (int i=0;i<10-n;i++){
            count=0;
            int temp = startNumber+1, buffer = startNumber;
            while (count<n-1){
                buffer = buffer*10+temp;
                temp++;
                count++;
            }
            rez[i]=buffer;
            startNumber++;
        }
        return rez;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = createNumber(n);
        for (int i=0; i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
