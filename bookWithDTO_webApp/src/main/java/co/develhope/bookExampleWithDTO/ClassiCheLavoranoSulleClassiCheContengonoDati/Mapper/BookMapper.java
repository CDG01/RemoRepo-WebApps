package co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.Mapper;

import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.entities.BookEntity;
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
