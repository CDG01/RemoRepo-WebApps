package co.develhope.bookexample.repositories;

import co.develhope.bookexample.DAO.BookDAO;
import co.develhope.bookexample.entities.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleOrAuthorOrIsbn(String title, String author, String isbn);

}
