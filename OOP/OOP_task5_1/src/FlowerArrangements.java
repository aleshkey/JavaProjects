import Flowers_and_package.Flower;
import Flowers_and_package.Package;

import java.util.ArrayList;
import java.util.Scanner;

public class FlowerArrangements {
    private ArrayList<Flower> flowers = new ArrayList<Flower>();
    private  Package aPackage= new Package();

    public void setFlowers() {
        System.out.print("number of flowers - ");
        Scanner sc = new Scanner(System.in);
        int numberOfFlowers = sc.nextInt();
        for(int i = 0; i < numberOfFlowers; i++){
            System.out.println("new flower");
            Flower flowerBuff = new Flower();
            flowerBuff.setType();
            flowerBuff.setColor();
            flowerBuff.setSize();
            flowers.add(flowerBuff);
        }
    }

    public void setaPackage(){
        System.out.println("package");
        aPackage.setColor();
        aPackage.setSize();
    }

    @Override
    public String toString() {
        String rez =  "FlowerArrangements{ flowers: ";
        for(int i = 0; i<flowers.size();i++){
            rez= rez+flowers.get(i).toString()+ ", ";
        }
        rez= rez + aPackage.toString();
        rez= rez+'}';
        return rez;
    }
}
