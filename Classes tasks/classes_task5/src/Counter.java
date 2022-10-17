public class Counter {
    private int now, start, finish;


    public Counter(int now, int start, int finish){
        this.now = now;
        this.start=start;
        this.finish=finish;
    }

    public Counter(){
        start=(int)(Math.random()*10);
        finish=(int)(Math.random()*10)+start;
        now = (int)(Math.random()*finish+start);
        System.out.println(start+" "+finish+" "+now);
    }

    private void plus(){
       if(now+1<=finish) {now++;}
       else throw new ArithmeticException("now>finish");
    }

    private void minus(){
        if(now-1>=start){ now--;}
        else throw new ArithmeticException("now<Start");

    }

    public int getNow() {
        return now;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }

    public void count(){
        try{
            System.out.print(now+" ");
            while(true){
                if(Math.random()>0.5){
                    plus();
                }
                else {
                    minus();
                }
                System.out.print(now+" ");
            }
        }
        catch(ArithmeticException exception){
            System.out.println();
            System.out.println(exception);
        }
    }
}
