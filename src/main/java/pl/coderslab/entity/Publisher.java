package pl.coderslab.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany//(fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Publisher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
//    INSERT INTO `test`.`publisher` (`name`) VALUES ('Znam');
//        INSERT INTO `test`.`publisher` (`name`) VALUES ('Synergia');
//        INSERT INTO `test`.`publisher` (`name`) VALUES ('Fabryka slow');
//        INSERT INTO `test`.`publisher` (`name`) VALUES ('Nulizmatyk');