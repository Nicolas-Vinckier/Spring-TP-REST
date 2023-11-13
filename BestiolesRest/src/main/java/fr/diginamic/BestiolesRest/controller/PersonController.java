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

import fr.diginamic.BestiolesRest.service.PersonService;
import jakarta.validation.Valid;
import fr.diginamic.BestiolesRest.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
    // ------------------------- Log -------------------------

    public static void log(String msg) {
        System.out.println("-------------------- LOG --------------------");
        System.out.println("Date: " + new Date() + " - Class: " +
                PersonController.class.getSimpleName() + " - " + msg);
        System.out.println("---------------------------------------------");
    }

    // ------------------------- Autowired -------------------------

    @Autowired
    private PersonService personService;

    // ------------------------- CRUD -------------------------
    @GetMapping("/all")
    public Object getAll() {
        log("getAll");
        return personService.findAll();
    }
 
    @PostMapping("/add")
    public Person add(@RequestBody @Valid Person person) {
        log("add");
        return personService.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Integer id) {
        log("findById");
        return personService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Person update(@PathVariable("id") Integer id, @RequestBody @Valid Person person) {
        log("update");
        person.setId(id);
        return personService.save(person);
    }

    @DeleteMapping("/delete/{id}")
    public Person delete(@PathVariable("id") Integer id) {
        log("delete");
        return personService.deleteById(id);
    }

}
