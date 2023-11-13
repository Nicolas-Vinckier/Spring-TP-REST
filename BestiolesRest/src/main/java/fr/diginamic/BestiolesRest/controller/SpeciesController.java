package fr.diginamic.BestiolesRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.BestiolesRest.model.Species;
import fr.diginamic.BestiolesRest.service.SpeciesService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    // ------------------------- Autowired -------------------------

    @Autowired
    private SpeciesService speciesService;

    // ------------------------- CRUD -------------------------

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("speciess", speciesService.findAll());
        return "species/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("species", new Species());
        return "species/add";
    }

    @PostMapping("/add")
    public String add(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return "species/add";
        }
        speciesService.save(species);
        return "redirect:/species/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("species", speciesService.findById(id));
        return "species/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Species person, BindingResult result) {
        if (result.hasErrors()) {
            return "species/update";
        }
        speciesService.save(person);
        return "redirect:/species/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        speciesService.deleteById(id);
        return "redirect:/species/all";
    }

}
