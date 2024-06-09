package co.develhope.bookexample.services;

import co.develhope.bookexample.DAO.BookDAO;
import co.develhope.bookexample.entities.Book;
import co.develhope.bookexample.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    //@Qualifier("bookRepository") // Specifica il nome del bean
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public Book getBookById(long id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookDAO.createBook(book);
    }

    @Override
    public Book updateBook(long id, Book book) {
        return bookDAO.updateBook(id, book);
    }

    @Override
    public Book deleteBook(long id) {
        return bookDAO.deleteBook(id);
    }

    @Override
    public void deleteAllBooks() {
        bookDAO.deleteAllBooks();
    }

    @Override
    public List<Book> searchBooks(String title, String author, String isbn) {
        // Effettua la ricerca dei libri utilizzando i parametri specificati
        return bookDAO.searchBooks(title, author, isbn);
    }
}