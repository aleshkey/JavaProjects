package Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    static Text text = new Text();
    public static void print() {
        System.out.println("1 - read from file\n" +
                "2 - change file\n" +
                "3 - add info\n" +
                "4 - save text");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kod;
        try {
            kod = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        start(kod);
    }

    private static void start(int kod) {
        switch (kod){
            case 1:{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String path;
                try {
                    path = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                text.

                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + kod);
        }
    }


}
