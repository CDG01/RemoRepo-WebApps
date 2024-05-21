package co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookEntity {
    private Long id;
    @NotNull(message = "Title may not be null")
    @NotBlank // E' solo per le stringhe: significa che non può essere la stringa ''
    private String title;
    @NotNull
    @NotBlank
    private String author;
    @NotNull
    @NotBlank
    private String isbn;
    private boolean isAMasterpiece;

    public BookEntity() {}

    public BookEntity(Long id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public BookEntity(String title, String author, String isbn, boolean isAMasterpiece) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAMasterpiece = isAMasterpiece;
    }

    public BookEntity(Long id, String title, String author, String isbn, boolean isAMasterpiece) {
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
