package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private PublisherDao publishers;
    @Autowired
    private AuthorDao authorDao;
    @RequestMapping("/add/{title}/{desc}")
    @ResponseBody
    public String hello(@PathVariable String title, @PathVariable String desc){
        Book book  = new Book();
        book.setTitle(title);
                book.setDescription(desc);
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                +  book.getId() + "find " + bookDao.findById(book.getId()) ; }


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
    @GetMapping("/rating/{rating}")
    @ResponseBody
    public String jsql(@PathVariable int rating){
        return " " + bookDao.getRatingList(rating);
    }

    @GetMapping("/addform")
    public String addBookForm(Model model){
        model.addAttribute("book",new Book());

        return "book/addForm";
    }



    @PostMapping("/addform")
    public String addpost(@ModelAttribute Book book){
        this.bookDao.saveBook(book);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String list( ){
        return "book/list";
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