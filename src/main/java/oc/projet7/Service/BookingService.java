package oc.projet7.Service;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.BookingStatus;
import oc.projet7.Entity.Member;
import oc.projet7.Repository.BookingRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class BookingService {

    String EmailFrom = "libraryOc@gmail.fr";


    String host;

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

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

    
    public List<Booking> checkDate(List<Booking> bookings) throws MessagingException {
        LocalDate today =  LocalDate.now();
        for (Booking booking: bookings) {
            if (booking.getReturn_date().compareTo(today) > 0){
            sendMail(booking.getMembre().getEmail());
            }
        }
        return null;
    }
    
    public void extend(Booking booking){
        
    }

    public static void sendMail(String recepient) throws MessagingException {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "annalibraryoc@gmail.com";
        String password = "12345LibraryOC";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("ca maaaaarche");

    }
    private static Message prepareMessage (Session session, String myAccountEmail, String recepient ) throws MessagingException {

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("mon sujet");
            message.setText("mon text");
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

}

