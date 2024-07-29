package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
    BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){//Model sirve para poder enviarle datos o información a la vista
        logger.info("Ejecutando findAll() de BookController");
        model.addAttribute("books", service.findAll());
        return "booksList";//este es el template donde sera dirigido
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        logger.info("Ejecutando findOne() de BookController");
        model.addAttribute("book", service.findOne(id));//este es el nombre del atributo que le colocamos en bookEdit.html
        return "bookEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Book book){
        logger.info(book.getTitle());
        boolean result = service.update(book);
        if(result){
            logger.info("Libro actualizado correctamente");
        }else{
            logger.error("Error al actualizar el libro");
        }
        return "redirect:/books";
    }

    @GetMapping("/new")
    public ModelAndView create(){
        logger.info("Ejecutando create() de BookController con ModelAndView");
        return new ModelAndView("bookNew");
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Book book){
        logger.info(book.getTitle());
        boolean result = service.create(book);
        if(result){
            logger.info("Libro creado exitosamente");
        }else{
            logger.error("Error al crear el libro");
        }
        return "redirect:/books";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id){
        logger.info("Ejecutando delete() de BookController");
        boolean result = service.delete(id);
        if(result){
            logger.info("Libro eliminado exitosamente");
        }else{
            logger.error("Error al eliminar el libro");
        }
        return "redirect:/books";
    }

    // Método para buscar libros por título o autor
    @GetMapping("/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        logger.info("Ejecutando searchBooks() de BookController");
        List<Book> books = service.searchBooks(query);
        model.addAttribute("books", books);
        return "booksList";
    }

    @GetMapping("/solicitar/{id}")
    public String solicitarLibro(@PathVariable("id") int id) {
        Book book = service.findOne(id);
        if (book != null && "Libro Disponible".equalsIgnoreCase(book.getEstado())) {
            book.setEstado("Libro Prestado");
            service.update(book);
            logger.info("Libro solicitado exitosamente");
        } else {
            logger.error("Error al solicitar el libro o el libro no está disponible");
        }
        return "redirect:/books";
    }

    @GetMapping("/devolver/{id}")
    public String devolverLibro(@PathVariable("id") int id) {
        Book book = service.findOne(id);
        if (book != null && "Libro Prestado".equalsIgnoreCase(book.getEstado())) {
            book.setEstado("Libro Disponible");
            service.update(book);
            logger.info("Libro devuelto exitosamente");
        } else {
            logger.error("Error al devolver el libro o el libro ya está disponible");
        }
        return "redirect:/books";
    }

    @GetMapping("/available")
    public String booksAvailable(Model model) {
        logger.info("Ejecutando booksAvailable() de BookController");
        model.addAttribute("books", service.findBooksByEstado("Libro Disponible"));
        return "booksAvailable";
    }

    @GetMapping("/not-available")
    public String booksNotAvailable(Model model) {
        logger.info("Ejecutando booksNotAvailable() de BookController");
        model.addAttribute("books", service.findBooksByEstado("Libro Prestado"));
        return "booksNotAvailable";
    }

}
