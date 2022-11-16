import java.util.Scanner;

public class Brand {
    private String type;


    public Brand(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClothes(){
        switch (type){
            case "jacket":{
                Jacket jacket = new Jacket();
                setManufacturer();
                Scanner sc = new Scanner(System.in);
                System.out.println("enter price");
                jacket.setPrice(sc.nextDouble());
                System.out.println("enter style");
                jacket.setStyle(sc.nextLine());
                System.out.println("enter season");
                jacket.setSeason(sc.nextLine());
                System.out.println("has hood?(true/false)");
                jacket.setHasHood(sc.nextBoolean());
                break;
            }
            case "shirt":{

                Shirt shirt = new Shirt();
                setManufacturer();
                Scanner sc = new Scanner(System.in);
                System.out.println("enter price");
                shirt.setPrice(sc.nextDouble());
                System.out.println("enter style");
                shirt.setStyle(sc.nextLine());
                System.out.println("length of sleeves");
                shirt.setLengthOfSleeves(sc.nextLine());
                System.out.println("enter percents of wool");
                shirt.setPercentOfWool(sc.nextInt());

                break;
            }
            case "pants": {
                Pants pants = new Pants();
                pants.setManufacturer();
                Scanner sc = new Scanner(System.in);
                System.out.println("enter price");
                pants.setPrice(sc.nextDouble());
                System.out.println("enter style");
                pants.setStyle(sc.nextLine());
                System.out.println("is flared(true/false)");
                pants.setFlared(sc.nextBoolean());
                break;
            }
        }
    }

    public String setManufacturer(String str){
        return str;
    }

    public String setManufacturer(){
        return "";
    }


    @Override
    public String toString() {
        return "Brand{" +
                "type='" + type + '\'' +
                '}';
    }
}
