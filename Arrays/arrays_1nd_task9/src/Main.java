import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int numberOfRepeats(List<Integer> arr, int x){
        int count=0;
        for(int i = 0; i<arr.size();i++){
            if(arr.get(i)==x){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList();
        int n = sc.nextInt(), max, numberOfMax;
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        List<Integer> numbersOfRepeats =new ArrayList();
        for(int i=0;i<n;i++){
            numbersOfRepeats.add(numberOfRepeats(arr, arr.get(i)));
        }
        max=numbersOfRepeats.get(0);
        numberOfMax = 0;
        for(int i=0;i < numbersOfRepeats.size();i++){
            if(max<=numbersOfRepeats.get(i)){
                if (max==numbersOfRepeats.get(i)){
                    if(arr.get(numberOfMax)>arr.get(i)){
                        numberOfMax=i;
                    }
                }
                else{
                    max=numbersOfRepeats.get(i);
                    numberOfMax=i;
                }
            }
        }
        System.out.println(arr.get(numberOfMax));
    }
}
