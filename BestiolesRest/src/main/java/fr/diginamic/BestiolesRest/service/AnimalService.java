package fr.diginamic.BestiolesRest.service;

import org.springframework.stereotype.Service;

import fr.diginamic.BestiolesRest.model.Animal;
import jakarta.validation.Valid;

@Service
public class AnimalService {

    // ------------------------- Create -------------------------

    public void save(@Valid Animal animal) {

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