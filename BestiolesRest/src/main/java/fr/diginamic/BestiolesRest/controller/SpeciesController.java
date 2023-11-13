package fr.diginamic.BestiolesRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Object add(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return speciesService.findAll();
        }
        speciesService.save(species);
        return speciesService.findAll();
    }

    @GetMapping("/update/{id}")
    public Object update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("species", speciesService.findById(id));
        return speciesService.findAll();
    }

    @PostMapping("/update/{id}")
    public Object update(@PathVariable("id") Integer id, @Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return speciesService.findAll();
        }
        speciesService.save(species);
        return speciesService.findAll();
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        speciesService.deleteById(id);
        return speciesService.findAll();
    }

}
