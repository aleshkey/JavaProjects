public class Main {
    public static void main(String[] args) {
        int proiz=1;
        for (int i=1; i<=200;i++){
            proiz *= Math.pow(i,2);
        }
        System.out.println(proiz);
    }
}