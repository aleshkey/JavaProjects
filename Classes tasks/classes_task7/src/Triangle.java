public class Triangle {
    private double x1,y1, x2, y2, x3, y3;
    private double lengthAB, lengthBC, lengthAC;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    private double setLength(double x1, double y1, double x2, double y2){
        return(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
    }

    private void getLength(){
        lengthAB = setLength(x1,y1, x2,y2);
        lengthAC = setLength(x1,y1, x3,y3);
        lengthBC = setLength(x3,y3, x2,y2);
    }

    private double getCorner(){
        double cos = (lengthAC*lengthAC+lengthAB*lengthAB-lengthBC*lengthBC)/(2*lengthAC*lengthAB);
        return Math.acos(cos);
    }

    public void printP(){
        System.out.println((lengthAB+lengthAC+lengthBC));
    }

    public void printS(){
        double s = 0.5*lengthAB*lengthAB*Math.sin(getCorner());
        System.out.println(s);
    }

    public void printCoordinates(){
        Line line = new Line();
        line.findKB(x1,y1, ((x2+x3)/2), ((y2+y3)/2));
        double k1 = line.getK(), b1 = line.getB();
        line.findKB(x2, y2, x3, y3);
        double k2 = line.getK(), b2 = line.getB();
        line.findKB(k1, b2, k2, b1);
        double x = (x1+0.2/3*(line.getK()-x1)*10);
        line.setK(k1);
        line.setB(b1);
        double y = line.getY(x);
        System.out.format("x = "+ "%05f"+" y = " +"%05f", x, y);
    }
}


class Line{
    private double k, b;

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getY(double x){
        return k*x+b;
    }

    public void findKB(double x1, double y1, double x2, double y2){
        k=(y1-y2)/(x1-x2);
        b=y1-k*x1;
    }
}