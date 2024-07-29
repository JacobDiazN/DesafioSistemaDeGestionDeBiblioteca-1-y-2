package cl.praxis.GestorBiblioteca.controller;

import cl.praxis.GestorBiblioteca.GestorBibliotecaApplication;
import cl.praxis.GestorBiblioteca.model.dto.Author;
import cl.praxis.GestorBiblioteca.model.dto.Book;
import cl.praxis.GestorBiblioteca.model.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);
    AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){//Model sirve para poder enviarle datos o información a la vista
        logger.info("Ejecutando findAll() de AuthorController");
        model.addAttribute("authors", service.findAll());
        return "authorsList";//aca se coloca el nombre del HTML donde será redirigido
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        logger.info("Ejecutando findOne() de AuthorController");
        model.addAttribute("author", service.findOne(id));//este es el nombre del atributo que le colocamos en bookEdit.html
        return "authorEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Author author){
        logger.info(author.getName());
        boolean result = service.update(author);
        if(result){
            logger.info("Autor actualizado correctamente");
        }else{
            logger.error("Error al actualizar el Autor");
        }
        return "redirect:/authors";
    }

    @GetMapping("/new")
    public ModelAndView create(){
        logger.info("Ejecutando create() de AuthorController con ModelAndView");
        return new ModelAndView("authorNew");
    }

    /*@GetMapping("/new")
    public String create2(){
        return "authorNew";
    }*/

    @PostMapping("/new")
    public String save(@ModelAttribute Author author){
        logger.info(author.getName());
        boolean result = service.create(author);
        if(result){
            logger.info("Autor creado exitosamente");
        }else{
            logger.error("Error al crear el Autor");
        }
        return "redirect:/authors";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id){
        logger.info("Ejecutando delete() de AuthorController");
        boolean result = service.delete(id);
        if(result){
            logger.info("Autor eliminado exitosamente");
        }else{
            logger.error("Error al eliminar el Autor");
        }
        return "redirect:/authors";
    }
}
