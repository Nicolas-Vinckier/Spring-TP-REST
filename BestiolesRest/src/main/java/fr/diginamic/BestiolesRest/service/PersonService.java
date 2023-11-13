package fr.diginamic.BestiolesRest.service;

import org.springframework.stereotype.Service;

import fr.diginamic.BestiolesRest.model.Person;
import jakarta.validation.Valid;

@Service
public class PersonService {

    // ------------------------- Create -------------------------

    public void save(@Valid Person person) {

    }

    // ------------------------- Read -------------------------

    public Object findById(Integer id) {
        return null;
    }

    public Object findAll() {
        return null;
    }

    // ------------------------- Update -------------------------

    // ------------------------- Delete -------------------------

    public void deleteById(Integer id) {
    }

}
