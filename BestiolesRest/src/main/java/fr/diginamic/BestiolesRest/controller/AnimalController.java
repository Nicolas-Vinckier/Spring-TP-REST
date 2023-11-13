package fr.diginamic.BestiolesRest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import fr.diginamic.BestiolesRest.model.Animal;
import fr.diginamic.BestiolesRest.service.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {
        // ------------------------- Log -------------------------

    public static void log(String msg) {
        System.out.println("-------------------- LOG --------------------");
        System.out.println("Date: " + new Date() + " - Class: " +
                AnimalController.class.getSimpleName() + " - " + msg);
        System.out.println("---------------------------------------------");
    }
    // ------------------------- Autowired -------------------------

    @Autowired
    private AnimalService animalService;

    // ------------------------- CRUD -------------------------
    @GetMapping("/all")
    public List<Animal> getAll() {
        log("getAll");
        return animalService.findAll();
    }

    @PostMapping("/add")
    public Animal add(@RequestBody Animal animal) {
        log("add");
        return animalService.save(animal);
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable("id") Integer id) {
        log("findById");
        return animalService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Animal update(@PathVariable("id") Integer id, @RequestBody @Valid Animal animal) {
        log("update");
        animal.setId(id);
        return animalService.save(animal);
    }

    @DeleteMapping("/delete/{id}")
    public Animal delete(@PathVariable("id") Integer id) {
        log("delete");
        return animalService.deleteById(id);
    }

}
