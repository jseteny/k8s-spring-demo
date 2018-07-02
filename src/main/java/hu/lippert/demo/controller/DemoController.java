package hu.lippert.demo.controller;

import hu.lippert.demo.model.Person;
import hu.lippert.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController
{
    @Autowired
    private PersonService personService;

    @GetMapping("/hi/{s}")
    public ResponseEntity<String> sayHi(@PathVariable("s") String s)
    {
        return ResponseEntity.ok("Hi " + s);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> findAll()
    {
        return ResponseEntity.ok(personService.findAll());
    }
}
