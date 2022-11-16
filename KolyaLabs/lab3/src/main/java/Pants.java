public class Pants extends Clothes {

    private boolean flared;

    public Pants(String manufacturer, double price, String style) {
        super(manufacturer, price, style);
    }

    public Pants() {

    }

    public boolean isFlared() {
        return flared;
    }

    public void setFlared(boolean flared) {
        this.flared = flared;
    }


    @Override
    public String toString() {
        return "Pants{"+ super.toString() +
                "flared=" + flared +
                '}';
    }
}
