package oc.projet7.bean;

import oc.projet7.Entity.Book;
import oc.projet7.Entity.Booking;
import oc.projet7.Entity.Member;

import java.time.LocalDate;

public class BookingDto {

    private int id;

    private Member member;

    private Book book;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private Boolean renewable;

    private String status;

    public BookingDto(Booking booking) {
        this.id = booking.getId();
        this.member = booking.getMembre();
        this.book = booking.getBook();
        this.borrowingDate = booking.getBorrowing_date();
        this.returnDate = booking.getReturn_date();
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

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
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

    @Override
    public String toString() {
        return "BookingDto{" +
                "id=" + id +
                ", member=" + member +
                ", book=" + book +
                ", borrowing_date=" + borrowingDate +
                ", return_date=" + returnDate +
                ", renewable=" + renewable +
                ", status='" + status + '\'' +
                '}';
    }
}
