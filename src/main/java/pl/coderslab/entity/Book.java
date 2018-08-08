package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "myTitle",
            length=100,
            nullable = false)
    @Size(min = 5)
    private String title;
    @Min(1)
    @Max(10)
    private int rating;
    @Column(columnDefinition="TEXT")
    @Size(max=600)
    private String description;
    //just for valid test
    @Transient
    @NotNull
    public Author author;
    @Min(value = 2, message = "przynajmniej 2 str nie osmieszaj sie ")
    private int pages;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Publisher publisher;
    @ManyToMany( fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book:" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'';
    }

    public Book(String title, int rating,  String description) {
        this.title = title;

        this.rating = rating;

        this.description = description;
    }
}

