import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine(), reversestr="";
        for (int i =str.length()-1; i>=0;i--){
            reversestr+=str.charAt(i);
        }
        if (str.equals(reversestr)){
            System.out.println("yes");
        }
        else System.out.println("no");
    }
}
