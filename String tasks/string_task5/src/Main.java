import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int rez=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='a' || str.charAt(i)=='A'){
                rez++;
            }
        }
        System.out.println(rez);
    }
}
