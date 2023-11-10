package fr.diginamic.BestiolesRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.BestiolesRest.enums.Sex;
import fr.diginamic.BestiolesRest.model.Animal;
import fr.diginamic.BestiolesRest.repository.AnimalRepository;
import fr.diginamic.BestiolesRest.repository.SpeciesRepository;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("/")
    public String listAnimal(Model model) {
        List<Animal> animal = (List<Animal>) animalRepository.findAll();
        model.addAttribute("animalList", animal);

        return "animal/list_animal";
    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isPresent()) {
            model.addAttribute(animal.get());
            model.addAttribute("sex", Sex.values());
            model.addAttribute("species", speciesRepository.findAll());
            return "animal/update_animal";
        }
        return "animal/error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("sex", Sex.values());
        model.addAttribute("species", speciesRepository.findAll());
        return "animal/create_animal";
    }

    @PostMapping
    public String createOrUpdate(Animal animalItem) {
        System.out.println(animalItem);
        animalRepository.save(animalItem);
        return "redirect:/animal";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer animalId) {
        Optional<Animal> animalToDelete = animalRepository.findById(animalId);
        animalToDelete.ifPresent(animal -> animalRepository.delete(animal));
        return "redirect:/animal";
    }

    // Catch other routes
    @GetMapping("")
    public String list() {
        return "redirect:/animal/";
    }

    @GetMapping("/**")
    public String error() {
        return "animal/error";
    }
}
