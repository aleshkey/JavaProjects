public class Test2{
    private int x;
    private int y;

    public Test2(){
        x=1;
        y=1;
    }

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
    public Test2(int x, int y){
        this.x = x;
        this.y = y;
    }
}
