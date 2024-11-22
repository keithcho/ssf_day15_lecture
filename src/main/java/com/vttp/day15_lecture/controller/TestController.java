package com.vttp.day15_lecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vttp.day15_lecture.model.Person;
import com.vttp.day15_lecture.service.PersonService;

@Controller
@RequestMapping("/tests")
public class TestController {
    
    @Autowired
    PersonService personSvc;

    @GetMapping("/add")
    public String addPerson() {
        Person p = new Person(1, "John", "john@john.com");
        personSvc.addPerson("persons", p);
        p = new Person(2, "Jake", "jake@john.com");
        personSvc.addPerson("persons", p);

        return "index";
    }


    @ResponseBody
    @GetMapping("/persons")
    public List<Person> personFindAll() {
        return personSvc.findAll("persons");
    }
    
    @ResponseBody
    @GetMapping("/delete")
    public Boolean deletePerson(Person person) {
        
        Person p = new Person(1, "John", "john@john.com");
        return personSvc.delete("persons", p);
    }
    
    
}
