public class Main {
    public static int facktor(int n){
        if(n==0 || n==1) return 1;
        return n*facktor(n-1);
    }

    public static void main(String[] args) {
        for(int i=1; i<=9;i+=2){
             System.out.print(facktor(i)+" ");
        }
    }
}
