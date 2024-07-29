package cl.praxis.GestorBiblioteca.model.service;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import java.util.List;


public interface BookService {

    List<Book> findAll();
    Book findOne(int id);
    boolean create(Book b);
    boolean update(Book b);
    boolean delete(int id);
    List<Book> searchBooks(String query);
    List<Book> findBooksByEstado(String estado);


}
