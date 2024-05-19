package co.develhope.bookExampleWithDTO.DTO;

public class BookCreationDTO {
    private String title;
    private String author;
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
