package co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookUpdateDTO {
    @NotNull
    private Long id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String author;
    @NotNull
    @NotBlank
    private String isbn;
    @NotNull
    private boolean isAMasterpiece;

    public BookUpdateDTO(Long id, String title, String author, String isbn, boolean isAMasterpiece) {
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

    public boolean isAMasterpiece() {
        return isAMasterpiece;
    }

    public void setIsAMasterpiece(boolean isAMasterpiece) {
        this.isAMasterpiece = isAMasterpiece;
    }
}
