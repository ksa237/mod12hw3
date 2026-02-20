package ru.netology.demoHiber.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false, length = 30)
    private String name;

    @Column(name="surname", nullable = false, length = 50)
    private String surname;

    @Column(name="age", nullable = false)
    private Integer age;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="city_of_living")
    private String city;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number='" + phone_number + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
}