package com.fas.SpringBootMVC.controller;

import com.fas.SpringBootMVC.database.PersonRepo;
import com.fas.SpringBootMVC.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Period;
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
    @GetMapping(path="/persons")
    @ResponseBody
    public List<Person> listPersons() {
//        List<Person> persons = new ArrayList<Person>();
//        personRepo.findAll().forEach(per->persons.add(per));
//        StringBuilder sb = new StringBuilder();
//        for(Person p:persons){
//            sb.append("\nPerson id: "+p.getPid()+"Person name: "+p.getName()+"Person age:  "+p.getAge()+"\n");
//            sb.append("\n");
//        }
//        return personRepo.findAll().toString();
        return personRepo.findAll();
    }
    @GetMapping("/persons/{pid}")
    @ResponseBody
    public Optional<Person> listPerson(@PathVariable("pid") int pid) {
        Optional<Person> p=Optional.of(personRepo.findById(pid)).get();

        return p;
    }

    @DeleteMapping("/persons/{pid}")
    @ResponseBody
    public String deletePerson(@PathVariable("pid") int pid) {
       // Optional<Person> p=Optional.of(personRepo.findById(pid)).get();
        Person pe = personRepo.getById(pid);
       // delete the found item
        personRepo.delete(pe);

        return "deleted";
    }

  @GetMapping("/addPerson")
    public String  addPerso(Person person){
        personRepo.save(person);
        return "home";
    }

    @PostMapping("/addPerson")
    @ResponseBody
    public Person  addPerson(@RequestBody Person person){
        personRepo.save(person);
        return person;
    }
    @PutMapping("/addPerson")
    public String  UpdateOrSavePerson(Person person){
        personRepo.save(person);
        return "home";
    }


}
