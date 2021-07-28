package com.fas.SpringBootMVC.controller;

import com.fas.SpringBootMVC.database.PersonRepo;
import com.fas.SpringBootMVC.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("home")
    public ModelAndView  home(Person person){
       ModelAndView mv= new ModelAndView();
        mv.addObject("obj",person);
        mv.setViewName("index");
        return mv;
    }
    @GetMapping("/")
    public String  index(){
        return "home";
    }

    @GetMapping("/addPerson")
    public String  addPerson(Person person){
        personRepo.save(person);
        return "home";
    }

    @GetMapping("/getPerson")
    public ModelAndView  getPerson(String name){
        ModelAndView mv= new ModelAndView("personDetail");

       // Person person=personRepo.findById(pid).orElse(new Person());
        List<Person> person=personRepo.findByNameSorted(name);
        System.out.println("-----------------------------------------");
        System.out.println(personRepo.findByNameSorted(name));
        System.out.println("-----------------------------------------");
        mv.addObject("person",person);
        return mv;
    }
}
