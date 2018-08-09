package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> , ResetRatingInteface  {

     List<Book>findAllByTitle(String title);
     List<Book>findAllByCategory(Category category);
     List<Book>findAllByAuthors(Author author);
     List<Book>findAllByPublisher(Publisher publisher);
     List<Book>findAllByCategoryId(long id);
     List<Book> findByRating(Integer rating);
     Book findFirstByOrderByTitleAsc(List<Book> book);
@Query("SELECT b FROM Book b where b.title = ?1")
    List<Book> findAllBYJpqlTtile(String title);
@Query("SELECT b FROM Book b where b.category = :categ")
    List<Book> findAllByJpqlCategory(@Param("categ") Category cat);
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:part%")
    List<Book> findAllWhereTitleContains(@Param("part") String part);
    @Query("SELECT b FROM Book b where b.rating >:min and b.rating <:max")
    List<Book> findAleWhereRatingIsGre3Les5(@Param("min")  int min, @Param("max") int max);
    @Query("SELECT b FROM Book b where b.publisher.id = :param1")
    List<Book> poid(@Param("param1")long param1);
    @Query(value = "SELECT * FROM test.books where category_id=:param1 order by myTitle ASC limit 1;",nativeQuery = true)
    Book firstorderedBytitle(@Param("param1") long id);
}
