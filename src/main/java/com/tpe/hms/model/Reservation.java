package com.tpe.hms.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

@Table(name = "tbl_reservation")
public class Reservation {

    //step 9d : create reservation Tbale

    //  step 26 : fill the filed .

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
    sequenceName = "reservation_id",
    initialValue = 4000,
    allocationSize = 1)//4000-4001-4002
    private Long id;


    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "guest_id",nullable = false)
    private Guest guest;


    @ManyToOne
    @JoinColumn(name = "room_id",nullable = false)
    private Room room;


    //getter and setter

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation() {
    }

    public Reservation(LocalDate checkInDate, LocalDate checkOutDate, Guest guest, Room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
//                ", guest=" + guest +
                ", room=" + room +
                '}';
    }
}
