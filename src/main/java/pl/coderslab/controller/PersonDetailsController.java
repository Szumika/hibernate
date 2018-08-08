package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.PersonDetails;

@Controller
@RequestMapping("/persondet")
public class PersonDetailsController {
    @Autowired
    private PersonDetailsDao personDetailsDao;

    @RequestMapping("/add/{firstname}/{lastname}/{city}")
    @ResponseBody
    public String hello(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String city){
        PersonDetails personDetails  = new PersonDetails();
        personDetails.setFirstName(firstname);
        personDetails.setLastName(lastname);
        personDetails.setCity(city);
        personDetailsDao.save(personDetails);
        return "Id dodanego autora to:"
                +  personDetails.getId() + "find: " + personDetailsDao.findById(personDetails.getId()) ; }



        @GetMapping("/find/{id}")
        @ResponseBody
        public String find(@PathVariable long id){
            PersonDetails personDetails = personDetailsDao.findById(id);
        return "author: " + personDetails;
        }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        PersonDetails personDetails = personDetailsDao.findById(id);
        personDetails.setCity("Klaj");
        personDetailsDao.update(personDetails);
        return "Dziala, update poszedl :) ";
                }
    @GetMapping("/remove/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
            String authorToRem = "Book " + personDetailsDao.findById(id) + "deleted";
        personDetailsDao.romoveById(id);
            return authorToRem;

    }
    @GetMapping("/addformtag")
    public String addpersontag(Model model){
        model.addAttribute("person",new PersonDetails());
        return "persondetail/addformtag";
    }
}