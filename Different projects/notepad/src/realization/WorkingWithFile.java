package realization;

import java.io.*;
import java.util.ArrayList;

public class WorkingWithFile {
    private static File file = new File("D:\\java\\notepad\\src\\data\\text.txt");

    public static ArrayList<Note> read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<Note> rez = new ArrayList<Note>();
        String str ="";
        while (bufferedReader.ready()){
            Note bufferNote = new Note();
            String bufferString = bufferedReader.readLine();
            bufferNote.setTitle(bufferString);
            bufferNote.setDate(bufferedReader.readLine());
            bufferNote.setEmail(bufferedReader.readLine());
            while (!bufferString.equals("")) {
               bufferString = bufferedReader.readLine();
               str = str +  bufferString+"\n";
            }
            bufferNote.setBody(str);
            rez.add(bufferNote);
            str="";
        }
        return rez;
    }

    public static void write(ArrayList<Note> notes) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (int i =0; i<notes.size(); i++){
            fileWriter.write(notes.get(i).toString());
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
