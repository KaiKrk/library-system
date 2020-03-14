package oc.projet7.Service;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.BookingStatus;
import oc.projet7.Entity.Member;
import oc.projet7.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public void save(Booking booking, Member member, Book book){
        booking.setMembre(member);
        booking.setBook(book);
        bookingRepository.save(booking);
    }

    public List<Booking> findMyBooking(Member member){
    List<Booking> MyBookings =  bookingRepository.findAllByMember(member);
    return MyBookings;
    }

    public Booking changeStatus(Booking booking,String status){

        if (status.equalsIgnoreCase(BookingStatus.EnCours.toString())){
            booking.setStatus(status);
        } else if (status.equalsIgnoreCase(BookingStatus.Prolongee.toString())){
            booking.setStatus(status);
        } else if (status.equalsIgnoreCase(BookingStatus.Terminee.toString())){
            booking.setStatus(status);
        }
        return booking;
    }
}
