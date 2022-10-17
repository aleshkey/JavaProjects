import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    public static int[][] maxDistance(List<List<Integer>> coordinates){
           int[][] rez = new int[2][2];
           rez[0][0]=coordinates.get(0).get(0);
           rez[0][1]=coordinates.get(0).get(1);
           rez[1][0]=coordinates.get(1).get(0);
           rez[1][1]=coordinates.get(1).get(1);
           double max = distance(coordinates.get(0).get(0), coordinates.get(0).get(1), coordinates.get(1).get(0), coordinates.get(1).get(1));
            for(int i = 0; i<coordinates.size();i++){
                for (int j=0;j<coordinates.size();j++){
                    if(max<distance(coordinates.get(i).get(0),coordinates.get(i).get(1), coordinates.get(j).get(0), coordinates.get(j).get(1))){
                        max = distance(coordinates.get(i).get(0),coordinates.get(i).get(1), coordinates.get(j).get(0), coordinates.get(j).get(1));
                        rez[0][0]=coordinates.get(i).get(0);
                        rez[0][1]=coordinates.get(i).get(1);
                        rez[1][0]=coordinates.get(j).get(0);
                        rez[1][1]=coordinates.get(j).get(1);
                    }
                }
            }
            return rez;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<List<Integer>> coordinates = new ArrayList();
        int n = sc.nextInt();
        for(int i =0; i<n; i++){
            List<Integer> buffer = new ArrayList();
            for(int j=0;j<2;j++){
                buffer.add(sc.nextInt());
            }
            coordinates.add(buffer);
        }
        int[][] rez = maxDistance(coordinates);
        for(int i = 0; i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(rez[i][j]+" ");
            }
            System.out.println();
        }
    }
}
