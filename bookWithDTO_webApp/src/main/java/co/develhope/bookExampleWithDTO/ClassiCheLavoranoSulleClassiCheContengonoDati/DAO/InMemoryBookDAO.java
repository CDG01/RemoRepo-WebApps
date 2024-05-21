package co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.DAO;

import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InMemoryBookDAO implements BookDAO {
    private final Map<Long, BookEntity> books = new HashMap<>();
    private Long idCounter = 0L;

    @Override
    public List<BookEntity> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public BookEntity getBookById(Long id) {
        return books.get(id);
    }

    @Override
    public BookEntity createBook(BookEntity book) {
        book.setId(++idCounter);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public BookEntity updateBook(Long id, BookEntity book) {
        if (!books.containsKey(id)) {
            return null;
        }
        book.setId(id);
        books.put(id, book);
        return book;
    }

    @Override
    public BookEntity deleteBook(Long id) {
        if (!books.containsKey(id)) {
            return null;
        } else {
            BookEntity book = books.get(id);
            books.remove(id);
            return book;
        }
    }


    @Override
    public void deleteAllBooks() {
        books.clear();
        idCounter = 0L;
    }

    @Override
    public List<BookEntity> searchBooks(String title, String author, String isbn) {
        return books.values().stream()
                .filter(book ->
                        (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                                (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())) &&
                                (isbn == null || book.getIsbn().toLowerCase().contains(isbn.toLowerCase())))
                .collect(Collectors.toList());
    }

}