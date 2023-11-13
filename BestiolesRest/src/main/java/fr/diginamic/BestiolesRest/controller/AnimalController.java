package fr.diginamic.BestiolesRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import fr.diginamic.BestiolesRest.model.Animal;
import fr.diginamic.BestiolesRest.service.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    // ------------------------- Autowired -------------------------

    @Autowired
    private AnimalService animalService;

    // ------------------------- CRUD -------------------------
    @GetMapping("/all")
    public List<Animal> getAll() {
        return animalService.findAll();
    }

    @PostMapping("/add")
    public List<Animal> add(@Valid Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return animalService.findAll();
        }
        animalService.save(animal);
        return animalService.findAll();
    }

    @GetMapping("/update/{id}")
    public List<Animal> update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("animal", animalService.findById(id));
        return animalService.findAll();
    }

    @PostMapping("/update/{id}")
    public List<Animal> update(@PathVariable("id") Integer id, @Valid Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return animalService.findAll();
        }
        animalService.save(animal);
        return animalService.findAll();
    }

    @GetMapping("/delete/{id}")
    public List<Animal> delete(@PathVariable("id") Integer id) {
        animalService.deleteById(id);
        return animalService.findAll();
    }

}
