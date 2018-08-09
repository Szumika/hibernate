package pl.coderslab.entity;

import pl.coderslab.validation.IsOver18YO;
import pl.coderslab.validation.PropostiteBookValidate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
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
    @Size(min = 5, groups={PropostiteBookValidate.class, Default.class})
    private String title;
    @Min(1)
    @Max(10)
    private int rating;
    @Column(columnDefinition="TEXT")
    @Size(max=600, groups={PropostiteBookValidate.class, Default.class})
    private String description;
    @Min(value = 2, message = "przynajmniej 2 str nie osmieszaj sie ")
    private int pages;
    @ManyToOne
    private Category category;
  private boolean propostition;

    public Boolean getPropostition() {
        return propostition;
    }

    public void setPropostition(Boolean propostition) {
        this.propostition = propostition;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isPropostition() {
        return propostition;
    }

    public void setPropostition(boolean propostition) {
        this.propostition = propostition;
    }
}

