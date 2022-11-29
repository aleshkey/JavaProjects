package library.models;

import javax.validation.constraints.NotEmpty;

public class Book {

    private int book_id;

    @NotEmpty(message = "title should not be empty")
    private String title;

    @NotEmpty(message = "book should has author")
    private String author;

    @NotEmpty(message = "year of release should not be empty")
    private int yearOfRelease;

    private int user = -1;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }


    public boolean hasUser(){
        if (user == -1){
            return false;
        }
        return true;
    }
}
