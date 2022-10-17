public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock(23, 59, 45);
        while(true){
            clock.printTime();
        }
    }
}
