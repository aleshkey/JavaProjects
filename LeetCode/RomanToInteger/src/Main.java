import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int valueOf(char ch){
        switch (ch){
            case 'I':{
                return 1;

            }

            case 'V':{
                return 5;
            }

            case 'X':{
                return 10;
            }

            case 'L':{
                return 50;
            }

            case 'C':{
                return 100;
            }

            case 'D':{
                return 500;
            }
        }
        return 1000;
    }

    public static int romanToInt(String s) {

        while (true) {
            List<List<Integer>> valueOfInput = new ArrayList<>();
            for (int i = 0; i < s.length() - 1; i++) {
                List<Integer> buffer = new ArrayList<>();
                while (i <(s).length() - 1 &&(s).charAt(i) ==(s).charAt(i + 1)) {
                    buffer.add(valueOf(s.charAt(i)));
                    i++;
                }
                buffer.add(valueOf(s.charAt(i)));
                valueOfInput.add(buffer);
            }
            if (valueOfInput.size() == 0 || valueOf(s.charAt(s.length() - 1)) != valueOfInput.get(valueOfInput.size() - 1).get(0)) {
                List<Integer> buffer = new ArrayList<>();
                buffer.add(valueOf(s.charAt(s.length() - 1)));
                valueOfInput.add(buffer);
            }

            return resultValue(valueOfInput);
        }
    }

    public static int sum(List<Integer> arr){

        int res=0;
        for(int i=0;i<arr.size(); i++){
            res+=arr.get(i);
        }
        return res;

    }

    public static int resultValue(List<List<Integer>> allNumbers){

        int res=0;
        for (int i = 0; i<allNumbers.size();i++){
            if(i+1<allNumbers.size() && (allNumbers.get(i).get(0)==1 && (allNumbers.get(i+1).get(0)==5 || allNumbers.get(i+1).get(0)==10))){
                res+=sum(allNumbers.get(i+1))-sum(allNumbers.get(i));
                i++;
            }
            else{
                if(i+1<allNumbers.size() && (allNumbers.get(i).get(0)==10 && (allNumbers.get(i+1).get(0)==50 || allNumbers.get(i+1).get(0)==100))){
                    res+=sum(allNumbers.get(i+1))-sum(allNumbers.get(i));
                    i++;
                }
                else {
                    if(i+1<allNumbers.size() && (allNumbers.get(i).get(0)==100 && (allNumbers.get(i+1).get(0)==500 || allNumbers.get(i+1).get(0)==1000))){
                        res+=sum(allNumbers.get(i+1))-sum(allNumbers.get(i));
                        i++;
                    }
                    else{
                        res+=sum(allNumbers.get(i));
                    }
                }
            }

        }
        return res;

    }
}
