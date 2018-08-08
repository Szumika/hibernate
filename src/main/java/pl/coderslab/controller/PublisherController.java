package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;
    @Autowired
    private BookDao bookDao;
    @RequestMapping("/add/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        Publisher publisher  = new Publisher();
        publisher.setName(name);
        publisherDao.save(publisher);
        return "Id dodanego publishera to:"
                +  publisher.getId() + "find: " + publisherDao.findById(publisher.getId()) ; }


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