package oc.projet7.Service;

import oc.projet7.Entity.Book;
import oc.projet7.Repository.BookRepository;
import oc.projet7.bean.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> findAll() {
        List<BookDto> bookDtoList = bookListToDto( bookRepository.findAll());
        return bookDtoList;
    }

    public Book save(Book book) {
       return bookRepository.save(book);
    }

    public List<BookDto> bookListToDto(List<Book> bookList){
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book: bookList) {
            bookDtoList.add(new BookDto(book));
        }
        return bookDtoList;
    }

    public Book findBookById( int id){
        return bookRepository.findBookById(id);
    }
}
