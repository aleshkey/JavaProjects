import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public  static ArrayList<Train> sortingByNumber(ArrayList<Train> trains){
        for(int i =0; i< trains.size(); i++){
            Train trainBuff = trains.get(i);
            int min = trainBuff.getNumber(), nummin=i;
            for(int j=i; j< trains.size(); j++){
                trainBuff = trains.get(j);
                if(min>trainBuff.getNumber()) {
                    min = trainBuff.getNumber();
                    nummin = j;
                }
            }
            trainBuff = trains.get(nummin);
            trains.set(nummin, trains.get(i));
            trains.set(i, trainBuff);
        }
        return trains;
    }

    public  static ArrayList<Train> sortingByDestination(ArrayList<Train> trains){
        for(int i =0; i< trains.size(); i++){
            Train trainBuff = trains.get(i);
            String min = trainBuff.getDestination();
            int nummin=i;
            for(int j=i; j< trains.size(); j++){
                trainBuff = trains.get(j);
                if(firstAlphabet(trainBuff.getDestination(), min, 0)==1) {
                    min = trainBuff.getDestination();
                    nummin = j;
                }
                if(firstAlphabet(trainBuff.getDestination(), min, 0)==0){
                    String departureTime = trainBuff.getDepartureTime(), destination = trainBuff.getDestination();
                    trainBuff = trains.get(nummin);
                    if(firstAlphabet(trainBuff.getDepartureTime(), departureTime, 0)==2){
                        min = destination;
                        nummin=j;
                    }
                }
            }
            trainBuff = trains.get(nummin);
            trains.set(nummin, trains.get(i));
            trains.set(i, trainBuff);
        }
        return trains;
    }

    public static int firstAlphabet(String str1, String str2,int i){
        if(str1.charAt(i)==str2.charAt(i)){
            if(i+1<str1.length() && i+1<str2.length()){
                i++;
                return firstAlphabet(str1, str2, i);
            }
            else{
                return 0;
            }
        }
        else{
            if(str1.charAt(i)<str2.charAt(i)){
                return 1;
            }
        }
        return 2;
    }

    public static void printForNumber(int number, ArrayList<Train> trains){
        for (int i=0; i< trains.size(); i++){
            Train trainBuffer = trains.get(i);
            if(number == trainBuffer.getNumber()){
                System.out.println(trainBuffer);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Train> trains = new ArrayList<Train>();
        for(int i =0; i<3; i++){;
            String destination =sc.nextLine();
            int number = sc.nextInt();
            String emptyString = sc.nextLine();
            String departureTime = sc.nextLine();
            Train trainBuff = new Train();
            trainBuff.setDestination(destination);
            trainBuff.setDepartureTime(departureTime);
            trainBuff.setNumber(number);
            trains.add(trainBuff);
        }
        trains = sortingByNumber(trains);
        for(int i =0; i<3; i++){
            System.out.println(trains.get(i));
        }
        int number= sc.nextInt();
        printForNumber(number, trains);
        System.out.println();
        trains = sortingByDestination(trains);
        for (int i=0;  i <3; i++){
            System.out.println(trains.get(i));
        }
    }
}
