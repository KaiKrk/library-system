package oc.projet7.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    @Column(name = "borrowing_date")
    private LocalDate borrowing_date;

    @Column(name = "return_date")
    private LocalDate return_date;

    @Column(name = "renewable")
    private Boolean renewable;

    @Column(name = "status")
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMembre() {
        return member;
    }

    public void setMembre(Member membre) {
        this.member = membre;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowing_date() {
        return borrowing_date;
    }

    public void setBorrowing_date(LocalDate borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public Boolean getRenewable() {
        return renewable;
    }

    public void setRenewable(Boolean renewable) {
        this.renewable = renewable;
    }

    public Booking() {
    }

    public Booking(Member membre, Book book, LocalDate borrowing_date, LocalDate return_date, Boolean renewable) {
        this.member = membre;
        this.book = book;
        this.borrowing_date = borrowing_date;
        this.return_date = return_date;
        this.renewable = renewable;
    }
}
