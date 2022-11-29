package library.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

public class Person {

    private int person_id;

    @NotEmpty(message = "last name should not be empty")
    private String lastName;

    @NotEmpty(message = "year should not be empty")
    private int year;

    ArrayList<Book> books = null;

    public Person() {
    }

    public Person(String lastName, int year) {
        this.lastName = lastName;
        this.year = year;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean hasBooks(){
        if (books==null){
            return false;
        }
        return true;
    }

    public void addBook(Book book){
        if (hasBooks()){
            books.add(book);
        }
        else{
            books = new ArrayList<>();
            books.add(book);
        }
    }

    public void removeBook(int id){
        if(hasBooks()) {
            for (int i =0; i<books.size(); i++) {
                if (books.get(i).getBook_id() == id) {
                    books.remove(i);
                }
            }
        }
        if (books.size()==0){
            books=null;
        }
    }
}
