package co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.services;

import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookCreationDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookUpdatePatchDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book createBook(BookCreationDTO book);
    Book checkAndUpdateBook(Long id, BookUpdatePatchDTO book);
    Book updateBook(Book book);
    Book deleteBook(long id);
    void deleteAllBooks();
    List<Book> searchBooks(String title, String author, String isbn);

}