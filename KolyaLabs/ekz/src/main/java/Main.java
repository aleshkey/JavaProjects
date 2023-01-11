import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu.print();
    }

}

class PostalAddress {

    private String town;

    private String street;

    private String house;

    private int index;

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "{" +
                "town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", index=" + index +
                '}';
    }
}


class Menu{
    private static List<PostalAddress> address = new ArrayList<>();

    private static File file = new File("result.txt");

    static int kod=-1;
    private static Scanner sc = new Scanner(System.in);
    static void print() {
        while (kod!=0) {
            System.out.println("0 - exit\n1 - create new postal address\n2 - delete postal address\n3 - print in file\n4 - print in console\n5 - change info");
            kod =  sc.nextInt();
            makeChoice();
        }
    }

    static void makeChoice(){
        switch (kod){
            case 0:{
                System.out.println("termination...");
                break;
            }
            case 1:{
                PostalAddress postalAddress = new PostalAddress();
                sc.nextLine();
                System.out.println("enter town");
                postalAddress.setTown(sc.nextLine());
                System.out.println("enter street");
                postalAddress.setStreet(sc.nextLine());
                System.out.println("enter house");
                postalAddress.setHouse(sc.nextLine());
                System.out.println("enter index");
                postalAddress.setIndex(sc.nextInt());
                address.add(postalAddress);
                break;
            }
            case 2:{
                System.out.println("enter index");
                int index = sc.nextInt();
                for(int i=0; i<address.size(); i++){
                    if (address.get(i).getIndex() == index){
                        address.remove(i);
                    }
                }
                break;
            }
            case 3:{
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(file));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (var a : address){
                    try {
                        bw.write(a.toString()+"\n");
                        bw.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                break;
            }
            case 4:{
                for(var a : address){
                    System.out.println(a);
                }
                break;
            }
            case 5:{
                System.out.println("enter index");
                int index = sc.nextInt();
                for(var a : address){
                    if (a.getIndex()==index){
                        sc.nextLine();
                        System.out.println("enter town");
                        a.setTown(sc.nextLine());
                        System.out.println("enter street");
                        a.setStreet(sc.nextLine());
                        System.out.println("enter house");
                        a.setHouse(sc.nextLine());
                        System.out.println("enter index");
                        a.setIndex(sc.nextInt());
                    }
                }
                break;
            }
            default: {
                System.out.println("incorrect input\ntry again");
            }
        }
    }
}

