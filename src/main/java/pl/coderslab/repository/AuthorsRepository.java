package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
    Author findOneByFirstname(String name);
    Author findOneByPesel(String pesel);
    Author findOneByEmail(String email);
    List<Author> findAllByLastname(String surname);
    @Query(value = "SELECT * FROM test.authors WHERE email LIKE :param1% ;",nativeQuery = true)
    List<Author> emailzazynasieod(@Param("param1") String param1);

}
