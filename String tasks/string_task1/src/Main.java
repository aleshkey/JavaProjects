import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count =1, maxcount =0;
        for(int i =0; i< str.length();i++){
            if (i+1<str.length() && str.charAt(i)==' '&& str.charAt(i+1)==' '){ count++;}
            else {
                if (maxcount<count) {
                    maxcount=count;
                }
                count=1;
            }
        }
        System.out.println(maxcount);
    }
}