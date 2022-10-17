import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean existsInArray(List<Character> arr, char symbol){
        for(int i=0; i<arr.size();i++){
            if(arr.get(i)==symbol){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> symbols = new ArrayList();
        symbols.add(' ');
        String str = sc.nextLine(), rez="";
        for(int i =0; i<str.length();i++){
            if(!existsInArray(symbols, str.charAt(i))){
                rez= rez+str.charAt(i);
                symbols.add(str.charAt(i));
            }
        }
        System.out.println(rez);
    }
}
