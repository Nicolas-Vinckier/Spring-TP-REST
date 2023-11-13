package fr.diginamic.BestiolesRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import fr.diginamic.BestiolesRest.model.Animal;
import fr.diginamic.BestiolesRest.service.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    // ------------------------- Autowired -------------------------

    @Autowired
    private AnimalService animalService;

    // ------------------------- CRUD -------------------------
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("animals", animalService.findAll());
        return "animal/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/add";
    }

    @PostMapping("/add")
    public String add(@Valid Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return "animal/add";
        }
        animalService.save(animal);
        return "redirect:/animal/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("animal", animalService.findById(id));
        return "animal/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return "animal/update";
        }
        animalService.save(animal);
        return "redirect:/animal/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        animalService.deleteById(id);
        return "redirect:/animal/all";
    }

}
