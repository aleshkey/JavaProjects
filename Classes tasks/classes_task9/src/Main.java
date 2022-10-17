import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        Scanner sc = new Scanner(System.in);
        for(int i =0; i<5; i++){
            Book bookBuff = new Book();
            System.out.println("введите название книги");
            bookBuff.setTitle(sc.nextLine());
            System.out.println("введите автора");
            bookBuff.setAuthor(sc.nextLine());
            System.out.println("введите издательство");
            bookBuff.setPublisher(sc.nextLine());
            System.out.println("введите год издания");
            bookBuff.setYearOfPublishing(sc.nextInt());
            System.out.println("введите кол-во страниц");
            bookBuff.setNumberOfPages(sc.nextInt());
            System.out.println("введите цену книги");
            bookBuff.setPrice(sc.nextDouble());
            System.out.println("введите тип переплёта");
            String emptyString = sc.nextLine();
            bookBuff.setTypeOfBinding(sc.nextLine());
            books.add(bookBuff);
        }
        Library library = new Library(books);
        System.out.println("введите автора");
        library.printByAuthor(sc.nextLine());
        System.out.println("введите издательство");
        library.printByPublisher(sc.nextLine());
        System.out.println("введите год");
        library.printByYear(sc.nextInt());
    }
}
