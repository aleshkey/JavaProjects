package models;

public class Product {

    private String name;

    private String price;

    private String URL;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String name, String price, String URL, String description) {
        this.name = name;
        this.price = price;
        this.URL = URL;
        this.description = description;
    }

    @Override
    public String toString() {
        return  name + '\n' +
                price + '\n' +
                description + '\n'+
                URL + '\n';
    }
}
