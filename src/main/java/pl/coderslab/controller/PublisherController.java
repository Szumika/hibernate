package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private BookDao bookDao;
    @GetMapping("/add")
    public String hello(@Valid Publisher publisher, BindingResult result){
        return "publisher/add";
    }

    @PostMapping("/add")
    public String addau(@Valid  Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisher/add";
        }
        publisherDao.save(publisher);
        return "form/success";
    }

//    @GetMapping("/addbook/{pubid}/{bookid}")
//    @ResponseBody
//    public String addbook( @PathVariable long pubid,
//                           @PathVariable long bookid){
//        Publisher publisher  = this.publisherDao.findById(pubid);
//        Book b = this.bookDao.findById(bookid);
//        publisher.getBooks().add(b);
//
//        this.publisherDao.update(publisher);
//        return "Id dodanego publishera to find: "; }



    @GetMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        return "author: " + publisher;
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        publisher.setName("Dominik");
        publisherDao.update(publisher);
        return "Dziala, update poszedl :) ";
    }
    @GetMapping("/remove/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        String pubToRem = "Book " + publisherDao.findById(id) + "deleted";
        publisherDao.romoveById(id);
        return pubToRem;

    }
}