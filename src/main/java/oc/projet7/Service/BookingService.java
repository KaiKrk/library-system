package oc.projet7.Service;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.BookingStatus;
import oc.projet7.Entity.Member;
import oc.projet7.Repository.BookingRepository;
import oc.projet7.bean.BookingDto;
import oc.projet7.bean.MailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class BookingService {

    @Value("${bookingStatus}")
    private static String bookingStatus;

    @Value("${account}")
    private static String myAccountEmail;

    @Value("${password}")
    private static String password;


    @Autowired
    private MailDetails mailDetails;

    @Autowired
    private MemberService memberService;

    @Autowired
    BookingRepository bookingRepository;

    public List<BookingDto> findAll(){
        List<BookingDto> bookingDtoList = bookingListToDto(bookingRepository.findAll());
        return bookingDtoList;
    }

    public List<Booking> findAllByStatus(){
          List<Booking> activeBookings =  bookingRepository.findAllByStatus(bookingStatus);
          return activeBookings;
    }

    public Booking save(Member member, Book book){
        Booking booking = new Booking();
        LocalDate today =  LocalDate.now();
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        booking.setBorrowing_date(today);
        booking.setReturn_date(futureDate);
        booking.setRenewable(true);
        booking.setMembre(member);
        booking.setBook(book);
        booking.setStatus(BookingStatus.EnCours.toString());
       return bookingRepository.save(booking);
    }

    public Booking update(Booking booking){
        return bookingRepository.save(booking);
    }

    public List<BookingDto> findMyBooking(String email){
    Member member = memberService.getMember(email);
    List<BookingDto> MyBookings = bookingListToDto( bookingRepository.findAllByMember(member));
    return MyBookings;
    }


    public List<BookingDto> bookingListToDto(List<Booking> bookingList){
        List<BookingDto> bookingDtoList = new ArrayList<>();
        for (Booking booking : bookingList) {
            bookingDtoList.add(new BookingDto(booking));
        }
        return bookingDtoList;
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

    
    public void checkDate(List<Booking> bookings) throws MessagingException {
        LocalDate today =  LocalDate.now();
        for (Booking booking: bookings) {
            if (booking.getReturn_date().compareTo(today) > 0){
            sendMail(booking.getMembre().getEmail());
            }
        }
    }
    
    public void extend(Booking booking){
        
    }

    public void sendMail(String recepient) throws MessagingException {



        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailDetails.getMyAccountEmail(), mailDetails.getPassword());
            }
        });
        Message message = prepareMessage(session, mailDetails.getMyAccountEmail(), recepient);

        Transport.send(message);

    }
    private Message prepareMessage (Session session, String myAccountEmail, String recepient ) throws MessagingException {

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(mailDetails.getSubject());
            message.setText(mailDetails.getMessage());
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

}

