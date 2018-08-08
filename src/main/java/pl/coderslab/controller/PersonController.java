package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PersonDetailsDao personDetailsDao;

    @RequestMapping("/add/{login}/{password}/{email}")
    @ResponseBody
    public String hello(@PathVariable String login, @PathVariable String password,@PathVariable String email){
        Person person  = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDao.save(person);
        return "Id dodanej osoby to:"
                +  person.getId() + "find: " + personDao.findById(person.getId()) ; }

    @GetMapping("/adddet/{personid}/{perdetid}")
    @ResponseBody
    public String addbook( @PathVariable long personid,
                           @PathVariable long perdetid){
        Person person  = this.personDao.findById(personid);
        PersonDetails b = this.personDetailsDao.findById(perdetid);
        person.setPersonDetails(b);

        this.personDao.update(person);
        return " dziala "+this.personDao.findById(personid)+
                " " + this.personDao.findById(personid).getPersonDetails(); }



        @GetMapping("/find/{id}")
        @ResponseBody
        public String find(@PathVariable long id){
            Person person = personDao.findById(id);
        return "author: " + person;
        }

    @GetMapping("/update/{id}/{email}")
    @ResponseBody
    public String update(@PathVariable long id,@PathVariable String email){
        Person person = personDao.findById(id);
        person.setEmail(email);
        personDao.update(person);
        return "Dziala, update poszedl :) ";
                }
    @GetMapping("/remove/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
            String authorToRem = "Person " + personDao.findById(id) + "deleted";
        personDao.romoveById(id);
            return authorToRem;

    }
    @GetMapping("/addform")
    public String addperson(){
        return "person/addform";
    }

    @PostMapping("/addform")
    @ResponseBody
    public String readperson(@RequestParam String login,@RequestParam String password,
                             @RequestParam String email,Model model){
        Person person = new Person(login,password,email);
//        model.addAttribute("persons",person);
        this.personDao.save(person);
        return ""+person;
    }

    @GetMapping("/addformtag")
    public String addpersontag(Model model){
        model.addAttribute("person",new Person());
        return "person/addformtag";
    }

    @PostMapping("/addformtag")
    public String processForm(@ModelAttribute Person person) {
        System.out.println(person);
        personDao.save(person);
        return "form/success";
    }

    @ModelAttribute("programmingSkills")
    public Collection<String> programmingSkills() {
        List<String> programmingSkills = new ArrayList<String>();
        programmingSkills.add(("Java"));
        programmingSkills.add(( "PHP"));
        programmingSkills.add(("Ruby"));
        return programmingSkills;
    }

    @ModelAttribute("countryItems")
    public Collection<String> countryItems() {
        List<String> countryItems = new ArrayList<String>();
        countryItems.add(("Polska"));
        countryItems.add(( "Niemcy"));
        countryItems.add(("Rosja"));
        return countryItems;
    }
    @ModelAttribute("hobbies")
    public Collection<String> skills() {
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("picie");
        hobbies.add("jedzenie");
        hobbies.add("spanie");
        hobbies.add("programowanie");
        return hobbies;
    }

}