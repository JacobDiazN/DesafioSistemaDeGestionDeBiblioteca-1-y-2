package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Author;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    private List<Book> bookList;
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);


    private AuthorService authorService = new AuthorServiceImpl();

    public BookServiceImpl() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "8410", "El Alquimista", 101, new Author(101, "Paulo", "Coelho", 1947), "El Alquimista es una novela alegórica del escritor brasileño Paulo Coelho.", "Libro Disponible"));
        bookList.add(new Book(2, "8423", "1984", 102, new Author(102, "George", "Orwell", 1903), "1984 es una novela distópica escrita por George Orwell en 1949.", "Libro Disponible"));
        bookList.add(new Book(3, "7356", "Cien Años de Soledad", 103, new Author(103, "Gabriel", "García Márquez", 1927), "Cien Años de Soledad es una novela del escritor colombiano Gabriel García Márquez.", "Libro Disponible"));
        bookList.add(new Book(4, "2008", "Matar a un Ruiseñor", 104, new Author(104, "Harper", "Lee", 1926), "Matar a un Ruiseñor es una novela de Harper Lee publicada en 1960.", "Libro Disponible"));
        bookList.add(new Book(5, "8425", "Orgullo y Prejuicio", 105, new Author(105, "Jane", "Austen", 1775), "Orgullo y Prejuicio es una novela romántica de Jane Austen, publicada en 1813.", "Libro Disponible"));
        bookList.add(new Book(6, "1311", "El Señor de los Anillos", 106, new Author(106, "J.R.R.", "Tolkien", 1892), "El Señor de los Anillos es una serie de novelas de fantasía épica escritas por J.R.R. Tolkien.", "Libro Disponible"));
        bookList.add(new Book(7, "7357", "El Gran Gatsby", 107, new Author(107, "F. Scott", "Fitzgerald", 1896), "El Gran Gatsby es una novela del escritor estadounidense F. Scott Fitzgerald publicada en 1925.", "Libro Disponible"));
        bookList.add(new Book(8, "3723", "Moby Dick", 108, new Author(108, "Herman", "Melville", 1819), "Moby Dick es una novela del escritor estadounidense Herman Melville publicada en 1851.", "Libro Disponible"));
        bookList.add(new Book(9, "8426", "Crimen y Castigo", 109, new Author(109, "Fiódor", "Dostoyevski", 1821), "Crimen y Castigo es una novela del escritor ruso Fiódor Dostoyevski publicada en 1866.", "Libro Disponible"));
        bookList.add(new Book(10, "9180", "El Juego de Ender", 110, new Author(110, "Orson Scott", "Card", 1951), "El Juego de Ender es una novela de ciencia ficción escrita por Orson Scott Card publicada en 1985.", "Libro Disponible"));
        bookList.add(new Book(11, "2345", "El Código Da Vinci", 111, new Author(111, "Dan", "Brown", 1964), "El Código Da Vinci es una novela de misterio escrita por Dan Brown.", "Libro Disponible"));
        bookList.add(new Book(12, "4523", "Don Quijote de la Mancha", 112, new Author(112, "Miguel", "de Cervantes", 1547), "Don Quijote de la Mancha es una novela escrita por Miguel de Cervantes.", "Libro Disponible"));
        bookList.add(new Book(13, "8765", "Harry Potter y la Piedra Filosofal", 113, new Author(113, "J.K.", "Rowling", 1965), "Harry Potter y la Piedra Filosofal es la primera novela de la serie Harry Potter escrita por J.K. Rowling.", "Libro Disponible"));
        bookList.add(new Book(14, "5678", "El Hobbit", 114, new Author(114, "J.R.R.", "Tolkien", 1892), "El Hobbit es una novela de fantasía escrita por J.R.R. Tolkien.", "Libro Disponible"));
        bookList.add(new Book(15, "2346", "La Sombra del Viento", 115, new Author(115, "Carlos", "Ruiz Zafón", 1964), "La Sombra del Viento es una novela escrita por Carlos Ruiz Zafón.", "Libro Disponible"));
        bookList.add(new Book(16, "9783", "La Historia Interminable", 116, new Author(116, "Michael", "Ende", 1929), "La Historia Interminable es una novela de fantasía escrita por Michael Ende.", "Libro Disponible"));
        bookList.add(new Book(17, "4352", "El Principito", 117, new Author(117, "Antoine", "de Saint-Exupéry", 1900), "El Principito es una novela escrita por Antoine de Saint-Exupéry.", "Libro Disponible"));
        bookList.add(new Book(18, "7654", "Orgullo y Prejuicio", 118, new Author(118, "Jane", "Austen", 1775), "Orgullo y Prejuicio es una novela romántica de Jane Austen.", "Libro Disponible"));
        bookList.add(new Book(19, "3421", "La Metamorfosis", 119, new Author(119, "Franz", "Kafka", 1883), "La Metamorfosis es una novela escrita por Franz Kafka.", "Libro Disponible"));
        bookList.add(new Book(20, "9123", "Los Juegos del Hambre", 120, new Author(120, "Suzanne", "Collins", 1962), "Los Juegos del Hambre es una novela distópica escrita por Suzanne Collins.", "Libro Disponible"));
        bookList.add(new Book(21, "7823", "El Perfume", 121, new Author(121, "Patrick", "Süskind", 1949), "El Perfume es una novela escrita por Patrick Süskind.", "Libro Disponible"));
        bookList.add(new Book(22, "8956", "El Retrato de Dorian Gray", 122, new Author(122, "Oscar", "Wilde", 1854), "El Retrato de Dorian Gray es una novela escrita por Oscar Wilde.", "Libro Disponible"));
        bookList.add(new Book(23, "1234", "Anna Karenina", 123, new Author(123, "León", "Tolstói", 1828), "Anna Karenina es una novela escrita por León Tolstói.", "Libro Disponible"));
        bookList.add(new Book(24, "4567", "La Divina Comedia", 124, new Author(124, "Dante", "Alighieri", 1265), "La Divina Comedia es una obra escrita por Dante Alighieri.", "Libro Disponible"));
        bookList.add(new Book(25, "7890", "Frankenstein", 125, new Author(125, "Mary", "Shelley", 1797), "Frankenstein es una novela escrita por Mary Shelley.", "Libro Disponible"));
        bookList.add(new Book(26, "2347", "El Viejo y el Mar", 126, new Author(126, "Ernest", "Hemingway", 1899), "El Viejo y el Mar es una novela escrita por Ernest Hemingway.", "Libro Disponible"));
        bookList.add(new Book(27, "3456", "Drácula", 127, new Author(127, "Bram", "Stoker", 1847), "Drácula es una novela escrita por Bram Stoker.", "Libro Disponible"));
        bookList.add(new Book(28, "6789", "El Nombre de la Rosa", 128, new Author(128, "Umberto", "Eco", 1932), "El Nombre de la Rosa es una novela escrita por Umberto Eco.", "Libro Disponible"));
        bookList.add(new Book(29, "4321", "Alicia en el País de las Maravillas", 129, new Author(129, "Lewis", "Carroll", 1832), "Alicia en el País de las Maravillas es una novela escrita por Lewis Carroll.", "Libro Disponible"));
        bookList.add(new Book(30, "5432", "El Señor de las Moscas", 130, new Author(130, "William", "Golding", 1911), "El Señor de las Moscas es una novela escrita por William Golding.", "Libro Disponible"));

    }

    public BookServiceImpl(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public List<Book> findAll() {
        logger.info("Ejecutando findAll() de BookServiceImpl");
        return bookList;
    }

    @Override
    public Book findOne(int id) {
        logger.info("Ejecutando findOne() de BookServiceImpl");
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(Book b) {
        logger.info("Ejecutando create() de BookServiceImpl");
       bookList.add(b);
       return true;
    }

    @Override
    public boolean update(Book b) {
        logger.info("Ejecutando update() de BookServiceImpl");
        Book bookUp = findOne(b.getId());
        bookUp.setIsbn(b.getIsbn());
        bookUp.setTitle(b.getTitle());
        bookUp.setExtract(b.getExtract());
        bookUp.setEstado(b.getEstado());
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Ejecutando delete() de BookServiceImpl");
        Book b = findOne(id);
        if(b != null){
            bookList.remove(b);
            return true;
        }
        return false;
    }

    @Override
    public List<Book> searchBooks(String search) {
        logger.info("Ejecutando searchBooks() de BookServiceImpl");
        return bookList.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(search.toLowerCase()) ||
                        book.getExtract().toLowerCase().contains(search.toLowerCase()) ||
                        book.getAuthor().getName().toLowerCase().contains(search.toLowerCase()) ||
                        book.getAuthor().getLastName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }

    /*private String normalizeString(String input) {
        if (input == null) {
            return "";
        }
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }*/

    /*@Override
    public Book bookAvailable(String estado){
        logger.info("Ejecutando bookAvailable() de BookServiceImpl");
        return bookList.stream()
                .filter(book -> book.getEstado() == "Libro Disponible")
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book bookNotAvailable(String estado){
        logger.info("Ejecutando bookNotAvailable() de BookServiceImpl");
        return bookList.stream()
                .filter(book -> book.getEstado() == "Libro Prestado")
                .findFirst()
                .orElse(null);
    }*/

    @Override
    public List<Book> findBooksByEstado(String estado) {
        logger.info("Ejecutando findBooksByEstado() de BookServiceImpl");
        return bookList.stream()
                .filter(book -> book.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }
}
