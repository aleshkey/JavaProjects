import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static List<String> divideIntoParts(String str, char[] kod){
        List<String> rez = new ArrayList();
        String temp="";
        for(int i =0; i<str.length();i++){
            for (int j = 0; j< kod.length;j++) {
                if (i == str.length() - 1 || str.charAt(i) == kod[j]) {
                    if (i == str.length() - 1) temp = temp + str.charAt(i);
                    rez.add(temp);
                    temp = "";
                }
            }
            temp = temp + str.charAt(i);
        }
        return rez;
    }

    public static int number(String str, String regexp){
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static List<String> sorting (List<String> objects, String regexp){
       for (int j =0; j< objects.size(); j++) {
           int min = number(objects.get(j), regexp), minnumber = j;
           for (int i = j; i < objects.size(); i++) {
               if (min > number(objects.get(i), regexp)) {
                   min = number(objects.get(i), regexp);
                   minnumber = i;
               }
           }
           String buffer = objects.get(j), temp = objects.get(minnumber);
           objects.remove(j);
           objects.add (j, temp);
           objects.remove(minnumber);
           objects.add(minnumber, buffer);
       }
       return objects;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str="Fjsijflksj fjkfjsklf. Jfksjfklsjfklsj!\nAfdafaf? Afsfdsfdsfdsfe ewrefd. Jfkdlsjf.\nAsfjksl.";
        int menu;
        System.out.println("1-сортировка абзацев по количесву предложений\n2-сортировка по длине слова каждого предложения\n3-сортировка лексемы в предложении по убыванию кол-ва вхождений заданного символа");
        menu = sc.nextInt();
        switch (menu){
            case 1:{
                List<String> paragraphs = divideIntoParts(str, new char[]{'\n'});
                List<String> rez = sorting(paragraphs,"[A-Z][a-z0-9]*(\\s[a-z0-9]+)*\\.?\\!?\\??");
                for(int i =0; i<rez.size();i++){
                    System.out.println(rez.get(i));
                }
                break;
            }
            case 2:{
                List<String> sentences = divideIntoParts(str, new char[]{'.','!','?'});
                break;
            }
            case 3:{

                break;
            }
        }
    }
}
