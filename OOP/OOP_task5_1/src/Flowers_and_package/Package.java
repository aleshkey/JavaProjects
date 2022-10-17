package Flowers_and_package;

import java.util.Objects;
import java.util.Scanner;

public class Package {
    private String color, size;

    public String getColor() {
        return color;
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

    public String getSize() {
        return size;
    }

    public void setSize() {
        System.out.println("1 - big\n2 - medium\n3 - small");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1: {size = "big";break;}
            case 2: {size = "medium";break;}
            case 3: {size = "small";break;}
            default:
                System.out.println("incorrect input");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(color, aPackage.color) && Objects.equals(size, aPackage.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size);
    }

    @Override
    public String toString() {
        return "Package - " + color + ", " + size ;
    }
}
