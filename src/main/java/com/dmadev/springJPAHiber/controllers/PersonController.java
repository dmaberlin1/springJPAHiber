package com.dmadev.springJPAHiber.controllers;

import com.dmadev.springJPAHiber.models.Person;
import com.dmadev.springJPAHiber.services.ItemService;
import com.dmadev.springJPAHiber.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final ItemService itemService;

    @Autowired
    public PersonController(PersonService personService, ItemService itemService) {
        this.personService = personService;
        this.itemService = itemService;
    }


    @GetMapping()
    public String index(Model model){
      model.addAttribute("person",personService.findAll());

                itemService.findByItemName("MacBook");
                itemService.findByOwner(personService.findAll().get(0));
                //обходные пути для тестирования
                personService.test();
                return "person/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personService.findOne(id));

        return "person/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person")Person person){
        return "person/new";
    }


    @GetMapping("/new")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "person/new";
        }
        personService.save(person);
        return "person/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("person",personService.findOne(id));
        return "person/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,@PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "person/edit";
        }
        personService.update(id,person);
        return  "redirect:/person";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personService.delete(id);
        return "redirect:/person";
    }
}

