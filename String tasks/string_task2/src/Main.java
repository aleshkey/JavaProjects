import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(), rez="";
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='a'){
                rez+="ab";
            }
            else rez+=str.charAt(i);
        }
        System.out.println(rez);
    }
}
