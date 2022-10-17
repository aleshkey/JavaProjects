import javax.swing.text.Document;
import java.util.ArrayList;

public class Pier implements Runnable {

    private ArrayList<Container> containers = new ArrayList<Container>();

    private boolean isFree;

    private double capacity;

    private double timeForOneContainer=10000;

    private Ship shipNow;

    private int containersNow;

    public Pier(Ship shipNow, double capacity,int containersNow, ArrayList<Container> containers) {
        this.shipNow = shipNow;
        isFree=true;
        this.capacity=capacity;
        this.containersNow= containersNow;
        this.containers=containers;
    }

    public Pier() {
        isFree=true;
    }

    public void setShipNow(Ship shipNow) {
        this.shipNow = shipNow;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    private void unload() throws InterruptedException {
        isFree=false;
        if(shipNow.getContainers().size()+containersNow<=capacity){
            for (int i=0;i<shipNow.getContainers().size();i++){
                containers.add(shipNow.getContainers().get(i));
            }

            Thread.sleep((long) (timeForOneContainer*shipNow.getContainers().size()));
            shipNow.getContainers().clear();
            System.out.println("well done!");
        }
        isFree=true;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public void run() {
        if (isFree){
            try {
                unload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
