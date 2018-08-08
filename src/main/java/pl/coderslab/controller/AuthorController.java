package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;


    @GetMapping("/add")
    public String hello(@Valid  Author author, BindingResult result){
        return "author/add";
    }

        @PostMapping("/add")
        public String addau(@Valid  Author author, BindingResult result){
        if(result.hasErrors()){
            return "author/add";
        }
        authorDao.save(author);
        return "form/success";
        }

//    @GetMapping("/addbook/{authorid}/{bookid}")
//    @ResponseBody
//    public String addbook( @PathVariable long authorid,
//                           @PathVariable long bookid){
//        Author author  = this.authorDao.findById(authorid);
//        Book b = this.bookDao.findById(bookid);
//        author.getBooks().add(b);
////        b.getAuthors().add(author);
//
//        this.authorDao.update(author);
////        this.bookDao.update(b);
//        return " dziala "+this.authorDao.findById(authorid)+ " " + this.authorDao.findById(authorid).getBooks(); }

        @GetMapping("/find/{id}")
        @ResponseBody
        public String find(@PathVariable long id){
            Author author = authorDao.findById(id);
        return "author: " + author;
        }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Author author = authorDao.findById(id);
        author.setFirstname("Dominik");
        authorDao.update(author);
        return "Dziala, update poszedl :) ";
                }
    @GetMapping("/remove/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
            String authorToRem = "Book " + authorDao.findById(id) + "deleted";
        authorDao.romoveById(id);
            return authorToRem;

    }
}