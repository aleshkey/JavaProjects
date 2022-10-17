import java.util.Date;
import java.util.Timer;

public class Clock {
    private int hours, minutes, seconds;

    public Clock(){
        hours=12;
        minutes=0;
        seconds=0;
    }

    public Clock(int h, int m, int s){
        hours = h;
        minutes = m;
        seconds = s;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours < 24) {
            this.hours = hours;
        }
        else{this.hours = 0;}
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 60) {
            this.minutes = minutes;
        }
        else{this.minutes=0;}
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds < 60) {
            this.seconds = seconds;
        }
        else{
            this.seconds = 0;
        }
    }

    public void printTime(){
        while(true){
            System.out.format("%02d"+":"+"%02d"+":"+"%02d", hours, minutes, seconds);
            if(seconds<59) {
                seconds++;
            }
            else if(minutes<59) {
                minutes++;
                seconds=0;
            }
            else {
                if (hours < 23) {
                    hours++;
                }
                else hours=0;
                minutes = 0;
                seconds = 0;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\r");
        }
    }

    public void addSeconds(int sec){
        if(seconds+sec>=60){
            minutes+=(int)((sec+seconds)/60);
            seconds = (sec+seconds)%60;
        }
        if(minutes>=60){
            hours += (int)minutes/60;
            minutes=minutes%60;
        }
        if(hours>=24){
            hours=hours%24;
        }
    }

    public void addMinutes(int min){
        if(minutes+min>=60){
            hours += (int)((minutes+min)/60);
            minutes=(minutes+min)%60;
        }
        if(hours>=24){
            hours=hours%24;
        }
    }
}
