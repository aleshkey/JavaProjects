package library.DAO;

import library.models.Book;
import library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<Person> index()
    {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT*FROM person where person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("insert into person(lastname, year) values (?,?)", person.getLastName(), person.getYear());
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE person SET lastname=?, year=? WHERE person_id=?", updatedPerson.getLastName(), updatedPerson.getYear(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from person where person_id=?", id);
    }

    public List<Book> getListOfBooks(int id){
        List<Book> books = jdbcTemplate.query("select * from book where person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
        for(var book : books)
            System.out.println(book.getTitle());
        return books;
    }

}
