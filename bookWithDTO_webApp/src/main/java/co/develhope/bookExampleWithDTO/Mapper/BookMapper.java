package co.develhope.bookExampleWithDTO.Mapper;

import co.develhope.bookExampleWithDTO.DTO.BookCreationDTO;
import co.develhope.bookExampleWithDTO.entities.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookCreationDTO toDto(BookEntity book) {
        return new BookCreationDTO(book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.isIsAMasterpiece());
    }

    public BookEntity toBook(BookCreationDTO bookDTO) {
        return new BookEntity(
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.isAMasterpiece());
    }
}
