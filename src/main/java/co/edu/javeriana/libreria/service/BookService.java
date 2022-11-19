package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.controller.BookRepository;
import co.edu.javeriana.libreria.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository repo;

    public BookService(BookRepository bookRepository){
        this.repo = bookRepository;
    }
    public List<Book> listAll() {
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

    public void saveOrUpdate(Book books) {
        repo.save(books);
    }

    public List<Book> getByName(String name) {
        return this.repo.findByNameContaining(name);
    }

    public List<Book> getByEditorialId(Integer id) {
        return repo.findByEditorialId(id);
    }

    public Page<Book> paginas(Pageable pageable){
        return repo.findAll(pageable);
    }

}

