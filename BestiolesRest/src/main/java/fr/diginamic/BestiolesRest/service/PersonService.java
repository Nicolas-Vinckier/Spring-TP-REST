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

    public void save(@Valid Person person) {
        personRepository.save(person);
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

    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }

}
