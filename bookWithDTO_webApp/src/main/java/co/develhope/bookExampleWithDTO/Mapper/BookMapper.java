package co.develhope.bookExampleWithDTO.Mapper;

import co.develhope.bookExampleWithDTO.DTO.BookDTO;
import co.develhope.bookExampleWithDTO.entities.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDTO toDto(BookEntity book) {
        return new BookDTO(book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.isIsAMasterpiece());
    }

    public BookEntity toEntity(BookDTO bookDTO) {
        return new BookEntity(
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.isAMasterpiece());
    }
}
