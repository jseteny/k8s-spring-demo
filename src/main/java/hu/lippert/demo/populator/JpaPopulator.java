package hu.lippert.demo.populator;

import hu.lippert.demo.model.Person;
import hu.lippert.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JpaPopulator implements CommandLineRunner
{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args)
    {
        if (personRepository.count() == 0)
        {
            personRepository.save(new Person("f1", "l1", new Date()));
            personRepository.save(new Person("f3", "l3", new Date()));
            personRepository.save(new Person("f2", "l2", new Date()));
        }
    }
}
