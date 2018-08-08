package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Publisher entity) {
        entityManager.persist(entity);
    }
    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public  void romoveById(long id){
        entityManager.remove(entityManager.find(Publisher.class, id));

    }
    public List<Publisher> readAll(){
        Query q = this.entityManager
                .createQuery("select p from Publisher p");
        return q.getResultList();
    }
}