import java.util.Scanner;

public class Main {
    public static int allLetters(String str, char a){
        int count=0;
        for (int i=0; i<str.length();i++){
            if(str.charAt(i)>=a && str.charAt(i)<=a+25){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(allLetters(str, 'a')>allLetters(str, 'A')){
            System.out.println("bolshe propisnih");
        }
        else if (allLetters(str, 'a')<allLetters(str, 'A'))System.out.println("bolshe bolshih");
        else System.out.println("ravno");
    }
}
