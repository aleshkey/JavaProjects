package MyController.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max=30, message = "incorrect input")
    private String name;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "incorrect input")
    private String email;

    @Min(value =0, message = "Age should be greater then 0")
    private int age;

    public Person(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public Person() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
