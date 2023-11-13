package fr.diginamic.BestiolesRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.BestiolesRest.service.PersonService;
import jakarta.validation.Valid;
import fr.diginamic.BestiolesRest.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
    // ------------------------- Autowired -------------------------

    @Autowired
    private PersonService personService;

    // ------------------------- CRUD -------------------------
    @GetMapping("/all")
    public Object getAll() {
        return personService.findAll();
    }

    @PostMapping("/add")
    public Object add(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return personService.findAll();
        }
        personService.save(person);
        return personService.findAll();
    }

    @GetMapping("/update/{id}")
    public Object update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return personService.findAll();
    }

    @PostMapping("/update/{id}")
    public Object update(@PathVariable("id") Integer id, @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return personService.findAll();
        }
        personService.save(person);
        return personService.findAll();
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        personService.deleteById(id);
        return personService.findAll();
    }

}
