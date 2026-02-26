package ru.netology.demoHiber.service;


import org.springframework.stereotype.Service;
import ru.netology.demoHiber.domain.Person;
import ru.netology.demoHiber.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<String> findPersonsByCity(String city) {
        List<Person> persons = repository.findByCityIgnoreCase(city);
        return persons.stream()
                .map(person -> String.format("%s %s, %d, %s, %s",
                        person.getName(),
                        person.getSurname(),
                        person.getAge(),
                        person.getPhone_number(),
                        person.getCity())).collect(Collectors.toList());
    }

    public List<String> findPersonsByAgeLess(Integer age) {
        List<Person> persons = repository.findByAgeLessThanOrderByAgeAsc(age);
        return persons.stream()
                .map(person -> String.format("%s %s, %d, %s, %s",
                        person.getName(),
                        person.getSurname(),
                        person.getAge(),
                        person.getPhone_number(),
                        person.getCity())).collect(Collectors.toList());

    }

    public String findPersonByFullName(String name, String surname) {
        Optional<Person> personOpt = repository.findFirst1ByNameAndSurnameAllIgnoreCase(name, surname);
        if (personOpt.isEmpty()) {
            return "Person not found";
        }
        Person person = personOpt.get();
        return String.format("%s %s, %d, %s, %s",
                person.getName(),
                person.getSurname(),
                person.getAge(),
                person.getPhone_number(),
                person.getCity());
    }

}
