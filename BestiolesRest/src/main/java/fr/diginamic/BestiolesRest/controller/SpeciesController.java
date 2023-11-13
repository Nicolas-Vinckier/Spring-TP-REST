package fr.diginamic.BestiolesRest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.BestiolesRest.model.Species;
import fr.diginamic.BestiolesRest.service.SpeciesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    // ------------------------- Log -------------------------

    public static void log(String msg) {
        System.out.println("-------------------- LOG --------------------");
        System.out.println("Date: " + new Date() + " - Class: " +
                PersonController.class.getSimpleName() + " - " + msg);
        System.out.println("---------------------------------------------");
    }

    // ------------------------- Autowired -------------------------

    @Autowired
    private SpeciesService speciesService;

    // ------------------------- CRUD -------------------------

    @GetMapping("/all")
    public Object getAll() {
        log("getAll");
        return speciesService.findAll();
    }

    @PostMapping("/add")
    public Species add(@RequestBody @Valid Species species) {
        log("add");
        return speciesService.save(species);
    }

    @GetMapping("/{id}")
    public Species findById(@PathVariable("id") Integer id) {
        log("findById");
        return speciesService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Species update(@PathVariable("id") Integer id, @RequestBody @Valid Species species) {
        log("update");
        species.setId(id);
        return speciesService.updateById(species);
    }

    @DeleteMapping("/delete/{id}")
    public Species delete(@PathVariable("id") Integer id) {
        log("delete");
        return speciesService.deleteById(id);
    }

}
