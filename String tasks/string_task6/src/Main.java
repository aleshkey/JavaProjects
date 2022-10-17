import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String startstr = sc.nextLine(), finishstr ="";
        for(int i=0;i<startstr.length();i++){
            finishstr= finishstr + startstr.charAt(i)+startstr.charAt(i);
        }
        System.out.println(finishstr);
    }
}
