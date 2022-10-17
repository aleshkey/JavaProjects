import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int lengthOfWord(String str, int i){
        int length=0;
        if(i==0 || str.charAt(i-1)==' '){
            while(str.charAt(i)!=' '){
                length++;
                i++;
            }
        }
        return length;
    }

    public static List<String> allWords(String str){
        int i =0;
        List<String> rez = new ArrayList();
        while(i<str.length()) {
            String temp = "";
            while (i<str.length() && str.charAt(i) != ' ') {
                temp+=str.charAt(i);
                i++;
            }
            i++;
            rez.add(temp);
        }
        return rez;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxlength = 0, numofmax=0;
        List<String> words = allWords(str);

        for (int i =0; i<words.size();i++){
            if(maxlength<words.get(i).length()){
                numofmax=i;
                maxlength=words.get(i).length();
            }
        }
        System.out.println(words.get(numofmax));
    }
}
