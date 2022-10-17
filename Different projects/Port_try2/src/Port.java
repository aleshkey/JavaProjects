import java.util.ArrayList;

public class Port {
    private static int numberOfPiers=4;

    private static double capacity=2000;


    private static ArrayList<Pier> piers = new ArrayList<Pier>();

    public static void main(String[] args) throws InterruptedException {

        for(int i=0; i<numberOfPiers;i++){
            Pier pier = new Pier();
            pier.setCapacity(capacity);
            piers.add(pier);
        }
        while (true) {
            Ship ship = new Ship();
            ship.setContainers();
            boolean waiting = true;
            while (waiting) {
                for (int i = 0; i < piers.size(); i++) {
                    if (piers.get(i).isFree()) {
                        Thread thread =  new Thread(piers.get(i));
                        piers.get(i).setShipNow(ship);
                        thread.start();
                        waiting=false;
                        break;
                    }
                }
            }
        }
    }

}
