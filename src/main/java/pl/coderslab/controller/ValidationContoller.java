package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.model.ValidationTest;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationContoller {
@Autowired
private Validator validator;

    @GetMapping("/validate")
    @ResponseBody
    public String vali(){
        Book b = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(b);
        if(violations.isEmpty()){
            return "Obiekt poprawny! ";
        }
        else{
            String resultTxt = "Naruszenie: <br> \n";
            for(ConstraintViolation<Book> v: violations){
                resultTxt += v.getPropertyPath() + " " + v.getMessage() + "<br>\n";
            }
            return resultTxt;
        }

}

    @GetMapping("/validateview")
    public String validate(Model model){
        Book b = new Book();
        b.setTitle("ala");
        Set<ConstraintViolation<Book>> violations = validator.validate(b);
        model.addAttribute("violations", violations);
            return "validation";
        }

    @GetMapping("/validateaut")
    public String validateAu(Model model){
        Author a = new Author("sdsadas","97052901571");
        Set<ConstraintViolation<Author>> violations = validator.validate(a);
        model.addAttribute("violations", violations);
        return "validation";
    }
    @GetMapping("/validatepub")
    public String validatePu(Model model){
        Publisher a = new Publisher();
        a.setNip("sdas");
        a.setRegon("sda");
        Set<ConstraintViolation<Publisher>> violations = validator.validate(a);
        model.addAttribute("violations", violations);
        return "validation";
    }


    @GetMapping("myown")
    @ResponseBody
    public String myOwnValidator(){
        Author author = new Author();
        author.setFirstname("Adrian");
        author.setLastname("Lany");
        author.setYearOfBirth(2007);
        Set<ConstraintViolation<Author>> violations = this.validator.validate(author);
        if(violations.isEmpty()){
            return "Ok";
        }
        else{
            String result = "Vuilations: <br>\n";
            for(ConstraintViolation<Author>a : violations){
                result += a.getPropertyPath() + " " + a.getMessage() + "<br>\n";
            }
            return result;
        }

    }


    @GetMapping("overxyo")
    @ResponseBody
    public String myOwnValidatorxyo() {
       ValidationTest test = new ValidationTest();
       test.yearOfBirth = 2005;
       Set<ConstraintViolation<ValidationTest>> violations = this.validator.validate(test);
        if(violations.isEmpty()){
            return "Ok";
        }
        else{
            String result = "Vuilations: <br>\n";
            for(ConstraintViolation<ValidationTest> a : violations){
                result += a.getPropertyPath() + " " + a.getMessage() + "<br>\n";
            }
            return result;
        }



    }
    }



