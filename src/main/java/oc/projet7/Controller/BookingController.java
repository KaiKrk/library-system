package oc.projet7.Controller;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.Member;
import oc.projet7.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/saveBooking")
    public ResponseEntity<Booking> save(@RequestBody Book book, @RequestBody Booking booking, @RequestBody Member member) {
        bookingService.save(booking, member, book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<Booking> changeStatus(@RequestBody Booking booking, String status){
        bookingService.changeStatus(booking,status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/myBooking")
    public ResponseEntity<List<Booking>> MyBooking(@RequestBody Member member){
        List<Booking> myBooking = bookingService.findMyBooking(member);
        if (myBooking.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myBooking, HttpStatus.OK);
    }

}
