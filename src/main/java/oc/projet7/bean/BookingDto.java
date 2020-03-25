package oc.projet7.bean;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.Member;

import java.time.LocalDate;

public class BookingDto {

    private int id;

    private Member member;

    private Book book;

    private LocalDate borrowing_date;

    private LocalDate return_date;

    private Boolean renewable;

    private String status;

    public BookingDto(Booking booking) {
        this.id = booking.getId();
        this.member = booking.getMembre();
        this.book = booking.getBook();
        this.borrowing_date = booking.getBorrowing_date();
        this.return_date = booking.getReturn_date();
        this.renewable = booking.getRenewable();
        this.status = booking.getStatus();
    }

    public BookingDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
