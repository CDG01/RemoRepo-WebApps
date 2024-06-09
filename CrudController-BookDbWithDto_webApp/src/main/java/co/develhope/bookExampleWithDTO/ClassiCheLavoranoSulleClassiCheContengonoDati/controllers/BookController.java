package co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.controllers;

import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookCreationDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookUpdateDTO;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO.BookUpdatePatchDTO;
import co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.Mapper.BookMapper;
import co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.entities.Book;
import co.develhope.bookExampleWithDTO.ClassiCheLavoranoSulleClassiCheContengonoDati.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper mapper;


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
        //return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok().body(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> createBook(@Valid @RequestBody BookCreationDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            // mostro in console i messaggi di errore
            for (FieldError error : bindingResult.getFieldErrors()){
                System.out.println("ERRORE: " + error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else {
            Book createdBook = bookService.createBook(bookDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        }
        /*
        ResponseEntity rappresenta il http response. E' un oggetto con attributi body, status code e header del http response.
        Per questo, questo oggetto ha senso solo se ritornato da controller
        il punto interrogativo indica che il tipo di dato nella response è variabile a seconda del clocco if: questo controoler potrebbe ritornare un ResponseEntity<List<ObjectError>> o un ResponseEntity<BookEntity>
         */
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody BookUpdateDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        } else {
            Book book = mapper.toBook(bookDTO);
            Book updatedBook = bookService.updateBook(book);
            if (updatedBook != null) {
                return ResponseEntity.ok().body(updatedBook);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookUpdatePatchDTO bookDTO,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        } else {
            Book updatedBook = bookService.checkAndUpdateBook(id, bookDTO);
            if (updatedBook != null) {
                return ResponseEntity.ok().body(updatedBook);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteBook() {
        bookService.deleteAllBooks();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.deleteBook(id);
        if (book != null)
            return ResponseEntity.ok().body(book);
        else {
            return ResponseEntity.notFound().build();
        }
    }


}