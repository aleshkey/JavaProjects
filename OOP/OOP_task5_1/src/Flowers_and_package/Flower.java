package Flowers_and_package;

import java.util.Scanner;

public class Flower {
    private String type, size, color;

    public void setType() {
        System.out.println("1 - rose\n2 - carnation\n3 - orchid");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1: {
                type = "rose";
                break;
            }
            case 2: {
                type = "carnation";
                break;
            }
            case 3: {
                type = "orchid";
                break;
            }
            default:
                System.out.println("incorrect input");
        }
    }

    public void setSize() {
        System.out.println("1 - big\n2 - medium\n3 - small");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1: {
                size = "big";
                break;
            }
            case 2:{
                size = "medium";
                break;
            }
            case 3:{
                size = "small";
                break;
            }
                default:
                System.out.println("incorrect input");
        }
    }

    public void setColor() {
        System.out.println("1 - red\n2 - white\n3 - yellow");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:{
                color = "red";
                break;
            }
            case 2: {
                color = "white";
                break;
            }
            case 3: {
                color = "yellow";
                break;
            }
            default:
                System.out.println("incorrect input");
        }
    }

    @Override
    public String toString() {
        return size+" "+color+" "+type +", ";
    }
}
