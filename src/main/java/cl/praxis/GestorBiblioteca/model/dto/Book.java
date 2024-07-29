package cl.praxis.GestorBiblioteca.model.dto;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private int autorId;
    private Author author;
    private String extract;
    private String estado;

    public Book() {
    }

    /*public Book(int id, String isbn, String title, int autorId, String extract) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.autorId = autorId;
        this.extract = extract;
    }

    public Book(int id, String isbn, String title, int autorId, Author author, String extract) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.autorId = autorId;
        this.author = author;
        this.extract = extract;
    }*/

    public Book(int id, String isbn, String title, int autorId, Author author, String extract, String estado) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.autorId = autorId;
        this.author = author;
        this.extract = extract;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
