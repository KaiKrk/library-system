package oc.projet7.Service;

import oc.projet7.Entity.Book;
import oc.projet7.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
       return bookRepository.save(book);
    }

}
