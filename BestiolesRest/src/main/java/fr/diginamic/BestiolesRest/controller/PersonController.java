package fr.diginamic.BestiolesRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Person add(@RequestBody @Valid Person person) {
        return personService.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Integer id) {
        return personService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Object update(@PathVariable("id") Integer id, @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return personService.findAll();
        }
        personService.save(person);
        return personService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public Person delete(@PathVariable("id") Integer id) {
        return personService.deleteById(id);
    }

}
