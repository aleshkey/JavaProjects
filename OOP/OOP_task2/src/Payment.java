import java.util.Scanner;

public class Payment {
    private Scanner sc = new Scanner(System.in);
    private Gods gods = new Gods();
    public void setGods(){
        System.out.println("cout number of bikes");
        gods.setNumberOfBikes(sc.nextInt());
        System.out.println("cout price for one bike");
        gods.setPriceForBike(sc.nextInt());
        System.out.println("cout number of sculptures");
        gods.setNumberOfSculpture(sc.nextInt());
        System.out.println("cout price for one sculpture");
        gods.setPriceForSculpture(sc.nextInt());
        System.out.println("cout number of smth else");
        gods.setNumberOfSmthElse(sc.nextInt());
        System.out.println("cout price for smth else");
        gods.setPriceForSmthElse(sc.nextInt());
    }
    public void printGods(){
        System.out.println(gods);
    }
}

class Gods{
    private int numberOfBikes, numberOfSculpture, numberOfSmthElse, price, priceForBike = 2, priceForSculpture = 5, priceForSmthElse = 1;

    public Gods() {
    }

    public Gods(int numberOfBikes, int numberOfSculpture, int numberOfSmthElse,  int priceForBike, int priceForSculpture, int priceForSmthElse) {
        this.numberOfBikes = numberOfBikes;
        this.numberOfSculpture = numberOfSculpture;
        this.numberOfSmthElse = numberOfSmthElse;
        this.priceForBike = priceForBike;
        this.priceForSculpture = priceForSculpture;
        this.priceForSmthElse = priceForSmthElse;
    }

    public int getNumberOfBikes() {
        return numberOfBikes;
    }

    public void setNumberOfBikes(int numberOfBikes) {
        this.numberOfBikes = numberOfBikes;
    }

    public int getNumberOfSculpture() {
        return numberOfSculpture;
    }

    public void setNumberOfSculpture(int numberOfSculpture) {
        this.numberOfSculpture = numberOfSculpture;
    }

    public int getNumberOfSmthElse() {
        return numberOfSmthElse;
    }

    public void setNumberOfSmthElse(int numberOfSmthElse) {
        this.numberOfSmthElse = numberOfSmthElse;
    }

    public int getPriceForBike() {
        return priceForBike;
    }

    public void setPriceForBike(int priceForBike) {
        this.priceForBike = priceForBike;
    }

    public int getPriceForSculpture() {
        return priceForSculpture;
    }

    public void setPriceForSculpture(int priceForSculpture) {
        this.priceForSculpture = priceForSculpture;
    }

    public int getPriceForSmthElse() {
        return priceForSmthElse;
    }

    public void setPriceForSmthElse(int priceForSmthElse) {
        this.priceForSmthElse = priceForSmthElse;
    }

    private void getPrice(){
        price = numberOfBikes*priceForBike+numberOfSculpture*priceForSculpture+numberOfSmthElse*priceForSmthElse;
    }

    @Override
    public String toString() {
        getPrice();
        return "Bikes  - " + numberOfBikes+" - "+numberOfBikes*priceForBike+"\n"+
                "Sculpture - "+numberOfSculpture+" - "+ numberOfSculpture*priceForSculpture+"\n"+
                "SmthElse - "+numberOfSmthElse+" - "+numberOfSmthElse*priceForSmthElse+"\n"+
                "-------------------------------------------------------\n"+
                "                     "+price;
    }
}
