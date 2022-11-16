package Source;

import java.io.*;
import java.util.ArrayList;

public class Text {
    private ArrayList<String> rows = new ArrayList<>();
    private String path = "./src/main/resources/Text";

    public Text() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Text(String path) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            while (bufferedReader.ready()) {
                rows.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> getRows() {
        return rows;
    }

    public void change(){

    }
}
