package realization;

import data.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class FileWork {
    private static ArrayList<Student> rez = new ArrayList<Student>();

    private static void readFromFile(){
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("D:\\java\\archive\\students.xml");
            NodeList list = doc.getElementsByTagName("student");
            for (int i=0; i < list.getLength(); i++){
                Node n = list.item(i);
                Element e = (Element)n;
                Student student = new Student();
                student.setId(e.getElementsByTagName("id").item(0).getTextContent());
                student.setName(e.getElementsByTagName("name").item(0).getTextContent());
                student.setLast_name(e.getElementsByTagName("last_name").item(0).getTextContent());
                student.setGroup(e.getElementsByTagName("group").item(0).getTextContent());
                student.setMark_math(e.getElementsByTagName("mark_math").item(0).getTextContent());
                student.setMark_language(e.getElementsByTagName("mark_language").item(0).getTextContent());
                student.setMark_IT(e.getElementsByTagName("mark_IT").item(0).getTextContent());
                rez.add(student);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(Student student){

    }

    public static ArrayList<Student> read() {
        readFromFile();
        return rez;
    }

    public void setRez(ArrayList<Student> rez) {
        this.rez = rez;
    }
}
