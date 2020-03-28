package oc.projet7.Controller;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.Member;
import oc.projet7.Service.BookService;
import oc.projet7.Service.BookingService;
import oc.projet7.Service.MemberService;
import oc.projet7.bean.BookingDto;
import oc.projet7.bean.BookingRequest;
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

    @Autowired
    BookService bookService;

    @Autowired
    MemberService memberService;

    @PostMapping("/saveBooking")
    public ResponseEntity<Booking> save(@RequestBody BookingRequest bookingRequest) {
        Member member = memberService.getMemberById(bookingRequest.getMemberId());
        Book book = bookService.findBookById(bookingRequest.getBookId());

       Booking newBooking =  bookingService.save(member, book);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<Booking> changeStatus(@RequestBody Booking booking, String status){
        Booking newBooking = bookingService.changeStatus(booking,status);
        bookingService.update(newBooking);
        return new ResponseEntity<>(newBooking, HttpStatus.OK);
    }

    @GetMapping("/myBooking")
    public ResponseEntity<List<BookingDto>> MyBooking(@RequestBody Member member){
        List<BookingDto> myBooking = bookingService.findMyBooking(member.getEmail());
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
            Booking updatedBooking = bookingService.update(booking);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void checkReturnDate() throws MessagingException {
        List<Booking> bookingList = bookingService.findAllByStatus();
        bookingService.checkDate(bookingList);
    }

}
