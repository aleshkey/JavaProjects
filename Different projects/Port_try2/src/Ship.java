import java.util.ArrayList;
import java.util.Scanner;

public class Ship {

    private double loadCapacity = 50;

    private double weight;
    private ArrayList<Container> containers = new ArrayList<Container>();

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public double getWeight() {
        return weight;
    }

    public void setContainers() {
        System.out.println("number of containers:");
        Scanner sc = new Scanner(System.in);
        weight=0;
        int n= sc.nextInt();
        for (int i=0; i<n; i++){
            Container container = new Container();
            System.out.println("Container "+(i+1)+" weight:");
            container.setWeight(sc.nextDouble());
            weight+=container.getWeight();
            containers.add(container);
        }
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }


}
