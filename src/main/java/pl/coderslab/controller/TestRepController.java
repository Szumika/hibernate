package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.repository.BookRepository;

import java.util.List;


    @Controller
    @RequestMapping("/rep")
    public class TestRepController {
        @Autowired
        BookRepository bookRepository;

        @RequestMapping("/add/{title}/{desc}")
        @ResponseBody
        public String hello(@PathVariable String title, @PathVariable String desc){
            Book book  = new Book();
            book.setTitle(title);
            book.setDescription(desc);
            bookRepository.save(book);
            return "Id dodanej książki to:"
                    +  book.getTitle() + " : " + book.getDescription() ; }



        @RequestMapping("/PeopleByAge")
        @ResponseBody
        public String getPeopleByAge() {
            String result = "";
            List<Book> list = bookRepository.findAll();
            for (Book b : list) {
                result += b.getTitle() + " : " + b.getDescription() + "<br>\n";
            }
            return result;
        }


        @GetMapping("/rating")
        @ResponseBody
        public String rat() {
            String result = "";
            List<Book> list = bookRepository.findByRating(0);
            for (Book b : list) {
                result += b.getTitle() + " : " + b.getDescription() + "<br>\n";
            }
            return result;
        }

        @GetMapping("/list")
        public String list( ){
            return "book/list";
        }


    @ModelAttribute("books")
        public List<Book> books(){
            return this.bookRepository.findAll();
    }

    }


