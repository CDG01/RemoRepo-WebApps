package co.develhope.bookExampleWithDTO.DAO;

import co.develhope.bookExampleWithDTO.entities.BookEntity;

import java.util.List;

public interface BookDAO {
    List<BookEntity> getAllBooks();
    BookEntity getBookById(Long id);
    BookEntity createBook(BookEntity book);
    BookEntity updateBook(Long id, BookEntity book);
    BookEntity deleteBook(Long id);
    void deleteAllBooks();
    List<BookEntity> searchBooks(String title, String author, String isbn);

}
