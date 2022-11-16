public class Jacket extends Clothes {

    private String season;

    private boolean hasHood;

    public Jacket(String manufacturer, double price, String style) {
        super(manufacturer, price, style);
    }

    public Jacket() {
    }

    public Jacket(String manufacturer, double price, String style, String season, boolean hasHood) {
        super(manufacturer, price, style);
        this.season = season;
        this.hasHood = hasHood;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public boolean isHasHood() {
        return hasHood;
    }

    public void setHasHood(boolean hasHood) {
        this.hasHood = hasHood;
    }


    @Override
    public String toString() {
        return "Jacket{" +super.toString()+","+
                "season='" + season + '\'' +
                ", hasHood=" + hasHood +
                '}';
    }
}
