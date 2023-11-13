package fr.diginamic.BestiolesRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.BestiolesRest.service.PersonService;
import jakarta.validation.Valid;
import fr.diginamic.BestiolesRest.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
    // ------------------------- Autowired -------------------------

    @Autowired
    private PersonService personService;

    // ------------------------- CRUD -------------------------
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/add")
    public String add(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "person/add";
        }
        personService.save(person);
        return "redirect:/animal/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "person/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "person/update";
        }
        personService.save(person);
        return "redirect:/person/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        personService.deleteById(id);
        return "redirect:/person/all";
    }

}
