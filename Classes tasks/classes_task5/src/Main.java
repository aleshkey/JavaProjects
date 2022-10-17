public class Main {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        counter1.count();
        System.out.println();
        Counter counter2 = new Counter(49, 1, 100);
        counter2.count();
    }
}
