package fr.diginamic.BestiolesRest.service;

import org.springframework.stereotype.Service;

import fr.diginamic.BestiolesRest.model.Species;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
    // ------------------------- Create -------------------------

    public void save(@Valid Species species) {

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
