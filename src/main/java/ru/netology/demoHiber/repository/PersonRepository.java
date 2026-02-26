package ru.netology.demoHiber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.demoHiber.domain.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {



    //создайте метод, который будет принимать название города (city) и возвращать Entity из базы данных, соответствующие этому city;
    public List<Person> findByCityIgnoreCase(String city);


    //создайте метод, который будет принимать возраст (age) и возвращать Entity из базы данных, которые меньше переданного age и отсортированы по возрастанию;
    public List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);


    //создайте метод, который будет принимать имя и фамилию (name и surname)
    //и возвращать Entity из базы данных, которые соответствуют сочетанию name и surname и являются Optional.
    public Optional<Person> findFirst1ByNameAndSurnameAllIgnoreCase(String name, String surname);

}


