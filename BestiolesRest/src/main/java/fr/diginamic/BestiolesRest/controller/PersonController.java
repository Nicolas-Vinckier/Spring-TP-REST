package fr.diginamic.BestiolesRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.BestiolesRest.model.Person;
import fr.diginamic.BestiolesRest.repository.AnimalRepository;
import fr.diginamic.BestiolesRest.repository.PersonRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/")
    public String listPerson(Model model) {
        List<Person> person = (List<Person>) personRepository.findAll();
        model.addAttribute("personList", person);

        return "person/list_person";
    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            model.addAttribute(person.get());
            model.addAttribute(animalRepository.findAll());
            return "person/update_person";
        }
        return "person/error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        model.addAttribute(new Person());
        model.addAttribute(animalRepository.findAll());
        return "person/create_person";
    }

    @PostMapping
    public String createOrUpdate(Person personItem) {
        System.out.println(personItem);
        personRepository.save(personItem);
        return "redirect:/person";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer personId) {
        Optional<Person> personToDelete = personRepository.findById(personId);
        personToDelete.ifPresent(person -> personRepository.delete(person));
        return "redirect:/person";
    }

    // Catch other routes
    @GetMapping("")
    public String list() {
        return "redirect:/person/";
    }

    @GetMapping("/**")
    public String error() {
        return "person/error";
    }
}
