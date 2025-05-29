package crud.application.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    @NotBlank(message="Имя - обязательное поле")
    private String name;

    @Column(name="lastName")
    @NotBlank(message="Фамилия - обязательное поле")
    private String lastName;

    @Column(name="age")
    @Min(value=18, message = "Пользователь должен быть совершеннолетним")
    private int age;

    @Column(name="bank")
    @NotBlank(message = "Обязательное поле")
    private String bank;

    public User() {
    }

    public User(String name, String lastName, int age, String bank) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.bank = bank;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "{" +
                "с именем ='" + name + '\'' +
                ", фамилией ='" + lastName + '\'' +
                ", возрастом =" + age +
                '}';
    }
}
