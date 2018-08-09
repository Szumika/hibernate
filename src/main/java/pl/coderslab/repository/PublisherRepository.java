package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findOneByName(String name);
    Publisher findOneByNip(String nip);
    Publisher findOneByRegon(String regon);
    @Query("SELECT b.id FROM Book b where name= :name")
    long findOne(@Param("name") String string);
}
