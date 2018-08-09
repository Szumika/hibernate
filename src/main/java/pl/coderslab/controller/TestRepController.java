package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.AuthorsRepository;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;


    @Controller
    @RequestMapping("/rep")
    public class TestRepController {
        @Autowired
        AuthorsRepository ar;
        @Autowired
        PublisherRepository pr;
        @Autowired
        CategoryRepository cr;
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


        @GetMapping("/rating/{val}")

        public String rat(@PathVariable int val, Model m) {
            String result = "";
            List<Book> list = bookRepository.findByRating(val);
            m.addAttribute("books",list);
            return "book/list";
        }

        @GetMapping("/list")
        public String list( ){
            return "book/list";
        }

        @GetMapping("/list/title/{title}")
        public String listtitle(@PathVariable String title, Model m ){
            List<Book> books = this.bookRepository.findAllByTitle(title);
            m.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/list/category/{category}")
        public String listcat(@PathVariable String category, Model m ){
            Category category1 = this.cr.findOneByName(category);
            List<Book> books = this.bookRepository.findAllByCategory(category1);
            m.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/list/catid/{catid}")
        public String listcatid(@PathVariable long catid, Model m ){
            Category category1 = this.cr.findOne(catid);
            List<Book> books = this.bookRepository.findAllByCategory(category1);
            m.addAttribute("books",books);
            return "book/list";
        }


        @GetMapping("/list/pub/{pub}")
        public String listpub(@PathVariable String pub, Model m ){
            Publisher pub1 = this.pr.findOneByName(pub);
            List<Book> books = this.bookRepository.findAllByPublisher(pub1);
            m.addAttribute("books",books);
            return "book/list";
        }


        @GetMapping("/list/author/{aut}")
        public String listaut(@PathVariable String aut, Model m ){
            Author author = this.ar.findOneByFirstname(aut);
            List<Book> books = this.bookRepository.findAllByAuthors(author);
            m.addAttribute("books",books);
            return "book/list";
        }


        @GetMapping("/pubnip/{nip}")

        public String pubnim(@PathVariable String nip,Model m){
            Publisher publisher = this.pr.findOneByNip(nip);
            List<Book> books = this.bookRepository.findAllByPublisher(publisher);
            m.addAttribute("books",books);
            return "book/list";
        }


        @GetMapping("/pubregon/{regon}")

        public String pubregon(@PathVariable String regon,Model m){
            Publisher publisher = this.pr.findOneByRegon(regon);
            List<Book> books = this.bookRepository.findAllByPublisher(publisher);
            m.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/authorpesel/{pesel}")

        public String pesel(@PathVariable String pesel,Model m){
            Author author = this.ar.findOneByPesel(pesel);
            List<Book> books = this.bookRepository.findAllByAuthors(author);
            m.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/authoremail/{email}")

        public String email(@PathVariable String email,Model m){
            Author author = this.ar.findOneByEmail(email);
            List<Book> books = this.bookRepository.findAllByAuthors(author);
            m.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/list/lastname/{name}")
        @ResponseBody
        public String listtitle12(@PathVariable String name, Model m ){
            String result = "";
            List<Author> authors = this.ar.findAllByLastname(name);
            for(Author a: authors){
                result += a.getFirstname() + " " + a.getLastname() + "<br>\n";
            }

            return result;
        }


        @GetMapping("/order/{name}")
        @ResponseBody
        public Book listordered(@PathVariable String name, Model m ){
            Category category1 = this.cr.findOneByName(name);
            List<Book> books = this.bookRepository.findAllByCategory(category1);
            Book books1 = this.bookRepository.findFirstByOrderByTitleAsc(books);
            return  books1;
        }

        @GetMapping("/list/jpqltest")

        public String jpqlte(Model m){
            List<Book> books = this.bookRepository.findAllBYJpqlTtile("potop");
            Category category = this.cr.findOneByName("Fantastyka");
            List<Book> books1 = this.bookRepository.findAllByJpqlCategory(category);

            //3
            List<Book> books2 = this.bookRepository.findAllWhereTitleContains("tle");
            List<Book> allBooks = new ArrayList<>();
            allBooks.addAll(books);
            allBooks.addAll(books1);
            allBooks.addAll(books2);

            m.addAttribute("books",allBooks);
            return "book/list";
        }

        @GetMapping("/ratingbetwen/{min}/{max}")
        public String rt(Model m, @PathVariable int min, @PathVariable int max){
            List<Book> books = this.bookRepository.findAleWhereRatingIsGre3Les5(min,max);
            m.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/autpub/{name}")
        public String autpub(@PathVariable String name,Model m){
            long a  = this.pr.findOneByName(name).getId();
            List<Book> books = this.bookRepository.poid(a);
            m.addAttribute("books",books);
            return "book/list";
        }


        @GetMapping("/firstordered/{name}")
        @ResponseBody
        public String catidbook(@PathVariable String name,Model m){
            long a  = this.cr.findOneByName(name).getId();
            Book books = this.bookRepository.firstorderedBytitle(a);
            return "book " + books ;
        }
        @GetMapping("/email/{param}")
        @ResponseBody
        public String like(@PathVariable String param){
            List<Author> authors = this.ar.emailzazynasieod(param);
            return "book: " + authors ;
        }



    @ModelAttribute("books")
        public List<Book> books(){
            return this.bookRepository.findAll();
    }

    }


