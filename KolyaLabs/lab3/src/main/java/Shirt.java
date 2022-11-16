public class Shirt extends Clothes {

    private String lengthOfSleeves;

    private int percentOfWool;

    public Shirt(String manufacturer, double price, String style) {
        super(manufacturer, price, style);
    }

    public Shirt() {

    }

    public String getLengthOfSleeves() {
        return lengthOfSleeves;
    }

    public void setLengthOfSleeves(String lengthOfSleeves) {
        this.lengthOfSleeves = lengthOfSleeves;
    }

    public int getPercentOfWool() {
        return percentOfWool;
    }

    public void setPercentOfWool(int percentOfWool) {
        this.percentOfWool = percentOfWool;
    }


    @Override
    public String toString() {
        return "Shirt{" +super.toString()+
                "lengthOfSleeves='" + lengthOfSleeves + '\'' +
                ", percentOfWool=" + percentOfWool +
                '}';
    }
}
