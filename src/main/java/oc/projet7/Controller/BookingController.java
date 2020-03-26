package oc.projet7.Controller;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.Member;
import oc.projet7.Service.BookingService;
import oc.projet7.bean.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;


@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/saveBooking")
    public ResponseEntity<Booking> save(@RequestBody Book book, @RequestBody Booking booking, @RequestBody Member member) {
        LocalDate today =  LocalDate.now();
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        booking.setBorrowing_date(today);
        booking.setReturn_date(futureDate);
        booking.setRenewable(true);
        booking.setMembre(member);
        booking.setBook(book);
       Booking newBooking =  bookingService.save(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<Booking> changeStatus(@RequestBody Booking booking, String status){
        bookingService.changeStatus(booking,status);

        Booking newBooking = bookingService.save(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.OK);
    }

    @GetMapping("/myBooking")
    public ResponseEntity<List<BookingDto>> MyBooking(@RequestBody Member member){
        List<BookingDto> myBooking = bookingService.findMyBooking(member);
        if (myBooking.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myBooking, HttpStatus.OK);
    }

    @GetMapping("/extendBooking")
    public ResponseEntity<Booking> extendDate(@RequestBody Booking booking){
        if (booking.getRenewable().equals(true)){
            LocalDate futureDate = LocalDate.now().plusMonths(1);
            booking.setReturn_date(futureDate);
            booking.setRenewable(false);
            bookingService.save(booking);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void checkReturnDate() throws MessagingException {
        List<Booking> bookingList = bookingService.findAllByStatus();
        bookingService.checkDate(bookingList);
    }

}
