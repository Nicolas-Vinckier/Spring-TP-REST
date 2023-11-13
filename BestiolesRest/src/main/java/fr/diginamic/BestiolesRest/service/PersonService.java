package fr.diginamic.BestiolesRest.service;

import org.springframework.stereotype.Service;

import fr.diginamic.BestiolesRest.model.Person;
import fr.diginamic.BestiolesRest.repository.PersonRepository;
import jakarta.validation.Valid;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // ------------------------- Create -------------------------

    public Person save(@Valid Person person) {
        return personRepository.save(person);
    }

    // ------------------------- Read -------------------------

    public Person findById(Integer id) {
        Person person = personRepository.findById(id).orElse(null);

        return person;
    }

    public Object findAll() {
        Iterable<Person> personnesIterable = personRepository.findAll();

        return personnesIterable;
    }

    // ------------------------- Update -------------------------

    // ------------------------- Delete -------------------------

    public Person deleteById(Integer id) {
        Person personToDelete = personRepository.findById(id).orElse(null);
        if (personToDelete != null) {
            personRepository.deleteById(id);
        }
        return personToDelete;
    }

}
