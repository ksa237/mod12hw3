package ru.netology.demoHiber.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.demoHiber.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<String> showConnectStatus() {
        return ResponseEntity.ok("Server is working ok!");
    }

    @GetMapping("/by-city")
    ResponseEntity<List<String>> showPersonsByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(service.findPersonsByCity(city));
    }

    @GetMapping("/by-age")
    ResponseEntity<List<String>> showPersonsAgeLess(@RequestParam("ageless") Integer age) {
        return ResponseEntity.ok(service.findPersonsByAgeLess(age));
    }

    @GetMapping("/by-full-name")
    ResponseEntity<String> showPersonByFullName(@RequestParam("name") String name, @RequestParam String surname) {
        return ResponseEntity.ok(service.findPersonByFullName(name, surname));
    }

}
