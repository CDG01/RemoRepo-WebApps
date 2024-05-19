package co.develhope.bookExampleWithDTO.services;

import co.develhope.bookExampleWithDTO.entities.BookEntity;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<BookEntity> getAllBooks();
    BookEntity getBookById(long id);
    BookEntity createBook(BookEntity book);
    BookEntity updateBook(long id, BookEntity book);

    BookEntity updateBook(Long id, Map<String, String> updates);

    BookEntity deleteBook(long id);
    void deleteAllBooks();

    List<BookEntity> searchBooks(String title, String author, String isbn);

}