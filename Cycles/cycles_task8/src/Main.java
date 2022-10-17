import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static List<Integer> allNumbers(int x){
        List<Integer> numbers = new ArrayList<Integer>();
        while (x>=1){
            int a = (int)x/10;
            numbers.add(x-a*10);
            x=a;
        }
        return numbers;
    }

    public static boolean exists(List<Integer> l1, int x){
        for(int i=0;i<l1.size();i++){
            if(x==l1.get(i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        List<Integer> rezult = new ArrayList();
        List<Integer> x = allNumbers(a), y = allNumbers(b);
        for (int i =0; i<y.size();i++){
            if(exists(x,y.get(i))){
                rezult.add(y.get(i));
            }
        }
        for (int i=0; i<rezult.size();i++){
            System.out.println(rezult.get(i));
        }
    }
}
