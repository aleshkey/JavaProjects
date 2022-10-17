public class Test1 {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void print(){
        System.out.println(x+" "+y);
    }

    public void printSum(){
        System.out.println((x+y));
    }

    public void printProizv(){
        System.out.println(x*y);
    }
}
