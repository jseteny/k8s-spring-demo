package hu.lippert.demo.service;

import hu.lippert.demo.model.Person;
import hu.lippert.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService
{
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll()
    {
        return personRepository.findAll();
    }
}
