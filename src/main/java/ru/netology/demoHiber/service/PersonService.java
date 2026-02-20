package ru.netology.demoHiber.service;


import org.springframework.stereotype.Service;
import ru.netology.demoHiber.domain.Person;
import ru.netology.demoHiber.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;


    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

}
