package co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.Mapper;

import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookCreationDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookUpdateDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookCreationDTO toCreationDto(Book book) {
        return new BookCreationDTO(book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.isIsAMasterpiece());
    }

    public Book toBook(BookCreationDTO bookDTO) {
        return new Book(
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.isAMasterpiece());
    }

    public BookUpdateDTO toUpdateDto(Book book) {
        return new BookUpdateDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.isIsAMasterpiece());
    }

    public Book toBook(BookUpdateDTO bookDTO) {
        return new Book(
                bookDTO.getId(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.isAMasterpiece());
    }


}
