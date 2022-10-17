import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;



public class Treasures {
    private List<Integer> treasure = new ArrayList<Integer>();

    public Treasures() throws IOException {
        treasure = ReadFromFile.inFile();
    }

    public void chooseTheMostExpensive(){
        List<Integer> list = treasure;
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }

    public void showTreasures(){
        System.out.println("--------------------------");
        for(int i=0; i< treasure.size();i++){
            System.out.println(treasure.get(i));
        }
        System.out.println("--------------------------");
    }

    private int sum(List<Integer> arr){
        int s=0;
        for (int i=0;i<arr.size();i++){
            s+=arr.get(i);
        }
        return s;
    }

    private boolean existNumber(List<Integer> arr, int sum, int givenAmount){
        for(int i=0; i<arr.size(); i++) {
            if (givenAmount-arr.get(i)==sum){
                return true;
            }
        }
        return false;
    }

    public void searchForGivenAmount(){
        Collections.sort(treasure);
        Scanner sc = new Scanner(System.in);
        System.out.print("given amount = ");
        int givenAmount = sc.nextInt();
        for(int i=0; i < treasure.size(); i++) {
            for (int j = i; j< treasure.size(); j++){
                int q=j;
                List<Integer> buffer = new ArrayList<Integer>();
                buffer.add(q);
                while (sum(buffer)<=givenAmount){
                    if(sum(buffer)==givenAmount){
                        for(int p =0; p<buffer.size()-1;p++) {
                            System.out.print(buffer.get(p)+" + ");
                        }
                        System.out.println(buffer.get(buffer.size()-1)+" = "+givenAmount);
                    }

                }
            }
        }
    }
}
