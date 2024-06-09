package co.develhope.bookexample.DAO;

import co.develhope.bookexample.entities.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    Book deleteBook(Long id);
    void deleteAllBooks();
    List<Book> searchBooks(String title, String author, String isbn);

}
