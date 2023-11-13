package fr.diginamic.BestiolesRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import fr.diginamic.BestiolesRest.model.Animal;
import fr.diginamic.BestiolesRest.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // ------------------------- Create -------------------------

    public Animal save(@Valid Animal animal) {
        return animalRepository.save(animal);
    }

    // ------------------------- Read -------------------------

    public Animal findById(Integer id) {
        Animal animal = animalRepository.findById(id).orElse(null);

        return animal;
    }

    public List<Animal> findAll() {
        // Find all animals in the database
        Iterable<Animal> animauxIterable = animalRepository.findAll();
        List<Animal> animauxList = new ArrayList<>();
        animauxIterable.forEach(animauxList::add);

        // Return the list of animals
        return animauxList;
    }

    // ------------------------- Update -------------------------

    public Animal updateById(@Valid Animal animal) {
        return animalRepository.save(animal);
    }

    // ------------------------- Delete -------------------------

    public Animal deleteById(Integer id) {
        Animal animalToDelete = animalRepository.findById(id).orElse(null);
        if (animalToDelete != null) {
            animalRepository.deleteById(id);
        }
        return animalToDelete;
    }

}