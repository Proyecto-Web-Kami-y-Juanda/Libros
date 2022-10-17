package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.controller.BookRepository;
import co.edu.javeriana.libreria.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService
{
    @Autowired
    private BookRepository repo;

    public List<Book> listAll()
    {
        return this.repo.findAll();
    }

    public void save(Book product) {
        repo.save(product);
    }

    public Book get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void saveOrUpdate(Book books)
    {
        repo.save(books);
    }

    public List<Book> getByName(String name)
    {
        return repo.findByNameContaining(name);
    }

    public List<Book> getByEditorialId(Integer ediId)
    {
        return repo.findByEditorialId(ediId);
    }
}

