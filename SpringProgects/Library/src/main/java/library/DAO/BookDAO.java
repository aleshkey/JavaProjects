package library.DAO;

import library.models.Book;
import library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Book> index()
    {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT*FROM book where book_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("insert into book(title, author, year) values (?,?,?)", book.getTitle(), book.getAuthor(),book.getYearOfRelease());
    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year=? WHERE book_id=?", updatedBook.getTitle(), updatedBook.getAuthor(),updatedBook.getYearOfRelease(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from book where person_id=?", id);
    }

}
