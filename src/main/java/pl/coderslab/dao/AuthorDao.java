package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Author entity) {
        entityManager.persist(entity);
    }
    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public  void romoveById(long id){
        entityManager.remove(entityManager.find(Author.class, id));

    }
    public List<Author> readAll(){
        Query q = this.entityManager
                .createQuery("select e from Author e");
        return q.getResultList();
    }
}