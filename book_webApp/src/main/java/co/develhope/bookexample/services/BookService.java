package co.develhope.bookexample.services;

import co.develhope.bookexample.entities.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book createBook(Book book);
    Book updateBook(long id, Book book);
    Book deleteBook(long id);
    void deleteAllBooks();
    List<Book> searchBooks(String title, String author, String isbn);

}