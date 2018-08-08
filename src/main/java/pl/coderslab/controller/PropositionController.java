package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;
import pl.coderslab.validation.PropostiteBookValidate;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/proposition")
@Controller
public class PropositionController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublisherDao publishers;
    @Autowired
    private AuthorDao authorDao;



    @GetMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable long id){
        Book book = bookDao.findById(id);
        return "book: " + book;
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Book book = bookDao.findById(id);
        book.setTitle("Dominik");
        bookDao.update(book);
        return "Dziala ?";
    }
    @GetMapping("/remove/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        String booktoRem = "Book " + bookDao.findById(id) + "deleted";
        bookDao.romoveById(id);
        return booktoRem;

    }


    @GetMapping("/addform")
    public String addBookForm(Model model){
        model.addAttribute("book",new Book());

        return "prop/addForm";
    }




    @PostMapping("/addform")
    public String addpost(@Validated({PropostiteBookValidate.class}) Book book,
                          BindingResult result){

        if (result.hasErrors()) {
            return "prop/addForm";
        }
        book.setPropostition(true);
        this.bookDao.saveBook(book);
        return "redirect:list";
    }





    //------------------------------validate add book-------------------
    @GetMapping("/addformv")
    public String addBookFormVali(@Valid Book book, BindingResult result){

        return "prop/addFormValid";
    }

    @PostMapping("/addformv")
    public String addpostvali(@Validated({PropostiteBookValidate.class}) Book book,
                              BindingResult result){
        if(result.hasErrors()){
            return "prop/addFormValid";
        }
        this.bookDao.saveBook(book);
        return "redirect:list";
    }







    @GetMapping("/list")
    public String list( ){
        return "prop/list";
    }


    @GetMapping("/edit/{id}")
    public String editbook(Model model, @PathVariable long id){

        model.addAttribute("book",bookDao.findById(id));
        return "book/addForm";
    }
    @PostMapping("/edit/{id}")
    public String editbookpost(@ModelAttribute Book book){
        this.bookDao.update(book);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String deletebook(Model model, @PathVariable long id){
        bookDao.romoveById(id);
        return "redirect:../list";
    }



    @ModelAttribute("prop")
    public  List<Book> prop(){
        return  this.bookDao.readProp();
    }

    @ModelAttribute("publisher")
    public List<Publisher> publishers(){
        return this.publishers.readAll();
    }
    @ModelAttribute("authors")
    public List<Author> authors(){
        return this.authorDao.readAll();
    }

    @ModelAttribute("books")
    public List<Book> books(){
        return bookDao.readAll();
    }

}
