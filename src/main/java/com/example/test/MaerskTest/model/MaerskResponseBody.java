package com.example.test.MaerskTest.model;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.Size;

public class MaerskResponseBody {

    private boolean available;

    @Size(min = 9, max = 9)
    private String bookingRef;

    private String exceptionMessage;

    public MaerskResponseBody() {
    }

    public MaerskResponseBody(boolean available, @Size(min = 9, max = 9) String bookingRef) {
        this.available = available;
        this.bookingRef = bookingRef;
    }

    public MaerskResponseBody(boolean b) {
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
