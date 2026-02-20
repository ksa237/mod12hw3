package ru.netology.demoHiber.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.demoHiber.domain.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {

        String sql = "SELECT * FROM persons WHERE LOWER(city_of_living) = :city";
        return entityManager.createNativeQuery(sql, Person.class)
                .setParameter("city", city.toLowerCase()).getResultList();

    }

}
