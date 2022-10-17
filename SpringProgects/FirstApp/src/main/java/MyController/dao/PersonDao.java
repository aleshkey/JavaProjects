package MyController.dao;

import MyController.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDao {

    private static final String URL="jdbc:postgresql://localhost:5432/people_db";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    public List<Person> index()
    {
        return jdbcTemplate.query("SELECT*FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
       return jdbcTemplate.query("SELECT*FROM person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("insert into person(name, age, email) values (?,?,?)", person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from person where id=?", id);
    }
}
