package oc.projet7.Controller;
import oc.projet7.Entity.Book;
import oc.projet7.Service.BookService;
import oc.projet7.bean.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> books(){
        List<BookDto> booksList = bookService.findAll();
        if (booksList.isEmpty()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(booksList, HttpStatus.OK);
        }


    @PostMapping("/saveBook")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        Book newBook = bookService.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);

    }


}
