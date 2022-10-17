package co.edu.javeriana.libreria.controller;

import co.edu.javeriana.libreria.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>
{
    List<Book> findByNameContaining(String name);
    List<Book> findByEditorialId(Integer id);
}
