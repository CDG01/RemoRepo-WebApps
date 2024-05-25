package co.develhope.bookExampleWithDTO.ClassiCheContengonoDati.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookCreationDTO {
    @NotNull(message = "Attento a non dimenticarti il campo title")
    @NotBlank(message = "Non fare il furbo, riempi il campo title")
    private String title;
    @NotNull(message = "Attento a non dimenticarti il campo author")
    @NotBlank(message = "Non fare il furbo, riempi il campo author")
    private String author;
    @NotNull(message = "Attento a non dimenticarti il campo isbn")
    @NotBlank(message = "Non fare il furbo, riempi il campo isbn")
    private String isbn;
    private boolean isAMasterpiece;

    public BookCreationDTO(String title, String author, String isbn, boolean isAMasterpiece) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAMasterpiece = isAMasterpiece;
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
