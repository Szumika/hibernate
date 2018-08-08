package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public  void romoveById(long id){
        entityManager.remove(entityManager.find(Book.class, id));

    }
    public List<Book> getRatingList(int rating){
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b where rating =:rating");
        queryp.setParameter("rating",rating);

        return queryp.getResultList();
    }
    public List<Book> readAll(){
        Query q = this.entityManager
                .createQuery("select k from Book k");
        return q.getResultList();
    }
    public List<Book> readProp(){
        Query q = this.entityManager
                .createQuery("select u from Book  u where propostition=true");
//        q.setParameter("prop",true);
        return q.getResultList();
    }

}