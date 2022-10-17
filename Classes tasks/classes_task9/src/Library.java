import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void printByAuthor(String author){
        for(int i=0; i<books.size();i++){;
            if(books.get(i).getAuthor().equals(author)){
                System.out.println(books.get(i));
            }
        }
    }

    public void printByPublisher(String publisher){
        for(int i=0; i<books.size();i++){;
            if(books.get(i).getPublisher().equals(publisher)){
                System.out.println(books.get(i));
            }
        }
    }

    public void printByYear(int year){
        for(int i=0; i<books.size();i++){;
            if(books.get(i).getYearOfPublishing()>year){
                System.out.println(books.get(i));
            }
        }
    }
}
