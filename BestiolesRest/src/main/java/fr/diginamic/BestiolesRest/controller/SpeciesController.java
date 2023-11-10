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

import fr.diginamic.BestiolesRest.model.Species;
import fr.diginamic.BestiolesRest.repository.SpeciesRepository;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("/")
    public String listSpecies(Model model) {
        List<Species> species = speciesRepository.findAll();
        model.addAttribute("speciesList", species);

        return "species/list_species";
    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Species> species = speciesRepository.findById(id);
        if (species.isPresent()) {
            model.addAttribute(species.get());
            return "species/update_species";
        }
        return "species/error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        model.addAttribute(new Species());
        return "species/create_species";
    }

    @PostMapping
    public String createOrUpdate(Species speciesItem) {
        System.out.println(speciesItem);
        speciesRepository.save(speciesItem);
        return "redirect:/species";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer speciesId) {
        Optional<Species> speciesToDelete = speciesRepository.findById(speciesId);
        speciesToDelete.ifPresent(species -> speciesRepository.delete(species));
        return "redirect:/species";
    }

    // Catch other routes
    @GetMapping("")
    public String list() {
        return "redirect:/species/";
    }

    @GetMapping("/**")
    public String error() {
        return "species/error";
    }
}
