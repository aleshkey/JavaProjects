import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    private static File file = new File ("treasure.txt");

    public ReadFromFile() throws FileNotFoundException {
    }

    public static List<Integer> inFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Integer> rez = new ArrayList<Integer>();
        while (bufferedReader.ready()){
            rez.add(Integer.parseInt(bufferedReader.readLine()));
        }
        return rez;
    }
}
