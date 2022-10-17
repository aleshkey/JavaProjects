package realization;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notes {
    private ArrayList<Note> notes = new ArrayList<Note>();

    public Notes() throws IOException {
        notes = WorkingWithFile.read();
    }

    public void addNote() throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        Note newNote = new Note();
        String str="", buffer ="";
        newNote.setTitle(sc.nextLine());
        Calendar calendar = new GregorianCalendar();
        String date = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH))+"."+String.valueOf(calendar.get(Calendar.MONTH)+1)+"."+String.valueOf(calendar.get(Calendar.YEAR));

        newNote.setDate(date);
        newNote.setEmail();
        buffer=sc.nextLine();
        while (!buffer.equals("end")){
            str=str+buffer+"\n";
            buffer=sc.nextLine();
        }
        newNote.setBody(str);
        notes.add(newNote);
        WorkingWithFile.write(notes);
    }

    public void search() throws IOException, ParseException {
        int kod=-1;
        String str ="";
        Scanner sc = new Scanner(System.in);
        ArrayList<Note> searching = notes;
        while(kod!=0) {
            Menu.printForSearching();
            kod= sc.nextInt();
            sc.nextLine();
            if(kod!=0){
                str = sc.nextLine();
            }
            ArrayList<Note> buffer = new ArrayList<Note>();
            switch (kod) {
                case 0:{
                    Menu.print();
                    break;
                }
                case 1: {
                    for (int i = 0; i < searching.size(); i++){
                        Pattern pattern= Pattern.compile("^"+str+"$");
                        Matcher matcher = pattern.matcher(searching.get(i).getTitle());
                        if(matcher.find()){
                            System.out.println(searching.get(i));
                            buffer.add(searching.get(i));
                        }
                    }
                    break;
                }
                case 2:{
                    for (int i = 0; i < searching.size(); i++){
                        Pattern pattern= Pattern.compile("^"+str+"$");
                        Matcher matcher = pattern.matcher(searching.get(i).getDate());
                        if(matcher.find()){
                            System.out.println(searching.get(i));
                            buffer.add(searching.get(i));
                        }
                    }
                    break;
                }
                case 3:{
                    for (int i = 0; i < searching.size(); i++){
                        Pattern pattern= Pattern.compile("^"+str+"$");
                        Matcher matcher = pattern.matcher(searching.get(i).getEmail());
                        if(matcher.find()){
                            System.out.println(searching.get(i));
                            buffer.add(searching.get(i));
                        }
                    }
                    break;
                }
                case 4:{
                    for (int i = 0; i < searching.size(); i++){
                        Pattern pattern= Pattern.compile("(^|\\s)"+str+"($|\\s)");
                        Matcher matcher = pattern.matcher(searching.get(i).getBody());
                        if(matcher.find()){
                            System.out.println(searching.get(i));
                            buffer.add(searching.get(i));
                        }
                    }
                    break;
                }
            }
            searching=buffer;
        }
    }
}
