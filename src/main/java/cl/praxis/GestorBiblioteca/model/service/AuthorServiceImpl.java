package cl.praxis.GestorBiblioteca.model.service;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Author;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);


    List<Author> authorList;

    public AuthorServiceImpl() {
        authorList = new ArrayList<>();
        authorList.add(new Author(101, "Paulo", "Coelho", 1947));
        authorList.add(new Author(102, "George", "Orwell", 1903));
        authorList.add(new Author(103, "Gabriel", "García Márquez", 1927));
        authorList.add(new Author(104, "Harper", "Lee", 1926));
        authorList.add(new Author(105, "Jane", "Austen", 1775));
        authorList.add(new Author(106, "J.R.R.", "Tolkien", 1892));
        authorList.add(new Author(107, "F. Scott", "Fitzgerald", 1896));
        authorList.add(new Author(108, "Herman", "Melville", 1819));
        authorList.add(new Author(109, "Fiódor", "Dostoyevski", 1821));
        authorList.add(new Author(110, "Orson", "Scott Card", 1951));
        authorList.add(new Author(111, "Dan", "Brown", 1964));
        authorList.add(new Author(112, "Miguel", "de Cervantes", 1547));
        authorList.add(new Author(113, "J.K.", "Rowling", 1965));
        authorList.add(new Author(114, "J.R.R.", "Tolkien", 1892));
        authorList.add(new Author(115, "Carlos", "Ruiz Zafón", 1964));
        authorList.add(new Author(116, "Michael", "Ende", 1929));
        authorList.add(new Author(117, "Antoine", "de Saint-Exupéry", 1900));
        authorList.add(new Author(118, "Jane", "Austen", 1775));
        authorList.add(new Author(119, "Franz", "Kafka", 1883));
        authorList.add(new Author(120, "Suzanne", "Collins", 1962));
        authorList.add(new Author(121, "Patrick", "Süskind", 1949));
        authorList.add(new Author(122, "Oscar", "Wilde", 1854));
        authorList.add(new Author(123, "León", "Tolstói", 1828));
        authorList.add(new Author(124, "Dante", "Alighieri", 1265));
        authorList.add(new Author(125, "Mary", "Shelley", 1797));
        authorList.add(new Author(126, "Ernest", "Hemingway", 1899));
        authorList.add(new Author(127, "Bram", "Stoker", 1847));
        authorList.add(new Author(128, "Umberto", "Eco", 1932));
        authorList.add(new Author(129, "Lewis", "Carroll", 1832));
        authorList.add(new Author(130, "William", "Golding", 1911));

    }

    public AuthorServiceImpl(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public List<Author> findAll() {
        logger.info("Ejecutando findAll() de AuthorServiceImpl");
        return authorList;
    }

    @Override
    public Author findOne(int id) {
        logger.info("Ejecutando findOne() de AuthorServiceImpl");
        return authorList.stream().filter(author -> author.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean create(Author a) {
        logger.info("Ejecutando create() de AuthorServiceImpl");
        authorList.add(a);
        return true;
    }

    @Override
    public boolean update(Author a) {
        logger.info("Ejecutando update() de AuthorServiceImpl");
        Author authorUp = findOne(a.getId());
        authorUp.setName(a.getName());
        authorUp.setLastName(a.getLastName());
        authorUp.setYearOfBirth(a.getYearOfBirth());
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Ejecutando delete() de AuthorServiceImpl");
        Author a = findOne(id);
        if(a != null){
            authorList.remove(a);
            return true;
        }
        return false;
    }

}
