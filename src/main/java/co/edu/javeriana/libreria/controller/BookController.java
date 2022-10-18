package co.edu.javeriana.libreria.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.libreria.entity.Book;
import co.edu.javeriana.libreria.service.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BookController
{
    @Autowired
    private final BookService bookService;
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/books/all")
    public List<Book> list()
    {
        return bookService.listAll();
    }

    @DeleteMapping("/book")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        bookService.delete(bookid);
    }

    //crear libro
    @PostMapping("/book")
    private int saveBook(@RequestBody Book books)
    {
        bookService.saveOrUpdate(books);
        return books.getId();
    }
    //actualizar por id
    @PutMapping("/book/{bookid}")
    private Book update(@RequestBody Book books,@PathVariable("bookid") int bookid)
    {
        bookService.saveOrUpdate(books);
        return books;
    }

    // buscar por nombre
    @GetMapping("/books/nam")
    public List<Book> findByName(@RequestParam("name") String name)
    {
        return bookService.getByName(name);
    }

    // buscar por id
    @GetMapping("/id/{bookId}")
    public Book findById(@PathVariable("bookId")Integer id)
    {
        return bookService.get(id);
    }

    // buscar por id editorial
    @GetMapping("/books/editorial")
    public List<Book> findByEditorial(@RequestParam("editorialId")Integer id)
    {
        return bookService.getByEditorialId(id);
    }

}
