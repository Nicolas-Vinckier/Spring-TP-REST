package fr.diginamic.BestiolesRest.service;

import org.springframework.stereotype.Service;
import fr.diginamic.BestiolesRest.model.Species;
import fr.diginamic.BestiolesRest.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Service
public class SpeciesService {

    private final SpeciesRepository speciesRepository;

    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    // ------------------------- Create -------------------------

    public Species save(@Valid Species species) {
        return speciesRepository.save(species);
    }

    // ------------------------- Read -------------------------

    public Species findById(Integer id) {
        Species species = speciesRepository.findById(id).orElse(null);

        return species;
    }

    public Iterable<Species> findAll() {
        Iterable<Species> speciesIterable = speciesRepository.findAll();

        return speciesIterable;
    }

    // ------------------------- Update -------------------------

    public Species updateById(@Valid Species species) {
        return speciesRepository.save(species);
    }

    // ------------------------- Delete -------------------------

    public Species deleteById(Integer id) {
        Species speciesToDelete = speciesRepository.findById(id).orElse(null);
        if (speciesToDelete != null) {
            speciesRepository.deleteById(id);
        }
        return speciesToDelete;
    }

}