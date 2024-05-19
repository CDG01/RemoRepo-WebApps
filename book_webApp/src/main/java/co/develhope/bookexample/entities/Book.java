package co.develhope.bookexample.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique=true, name = "title")
    @NotNull(message = "Title may not be null")
    @NotBlank(message = "Title may not be blank")
    private String title;

    @Column(nullable = false, name = "author")
    @NotNull(message = "Author may not be null")
    @NotBlank(message = "Author may not be blank")
    private String author;

    @Column(nullable = false, name = "isbn")
    @NotNull(message = "ISBN may not be null")
    @NotBlank(message = "ISBN may not be blank")
    private String isbn;

    @Column(nullable = false, name = "isAMasterpiece")
    private boolean isAMasterpiece;

    public Book() {}

    public Book(Long id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(Long id, String title, String author, String isbn, boolean isAMasterpiece) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAMasterpiece = isAMasterpiece;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public boolean isIsAMasterpiece() {
        return isAMasterpiece;
    }

    public void setIsAMasterpiece(boolean isAMasterpiece) {
        this.isAMasterpiece = isAMasterpiece;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isAMasterpiece=" + isAMasterpiece +
                '}';
    }
}
