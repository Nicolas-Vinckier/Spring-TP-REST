package fr.diginamic.BestiolesRest.controller;

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

    // ------------------------- Autowired -------------------------

    @Autowired
    private SpeciesService speciesService;

    // ------------------------- CRUD -------------------------

    @GetMapping("/all")
    public Object getAll() {
        return speciesService.findAll();
    }

    @PostMapping("/add")
    public Species add(@RequestBody @Valid Species species) {
        return speciesService.save(species);
    }

    @GetMapping("/{id}")
    public Species findById(@PathVariable("id") Integer id) {
        return speciesService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Species update(@PathVariable("id") Integer id, @RequestBody @Valid Species species) {
        species.setId(id);
        return speciesService.updateById(species);
    }

    @DeleteMapping("/delete/{id}")
    public Species delete(@PathVariable("id") Integer id) {
        return speciesService.deleteById(id);
    }

}
