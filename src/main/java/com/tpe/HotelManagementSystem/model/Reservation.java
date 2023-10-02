package com.tpe.HotelManagementSystem.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

//@Cacheable//these annotations are used to enable caching for a method and specify the caching configuration
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Reservation")
@Table(name = "tbl_reservations")

public class Reservation {

    //step 9d: create reservation Entity
    //step 26 :Fill the filed
    //!!! open main pkg start menu
    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence", //should be matching with @GeneratedValue 'generator
            sequenceName = "reservation_id", //sequence that will be stored in DB
            initialValue = 1000, //optional, it is starting number
            allocationSize = 1) //optional. by default it is 50. allocated numbers in memory
    private Long id;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    // Constructors, getters, and setters

    public Reservation() {
    }

    public Reservation(LocalDate checkInDate, LocalDate checkOutDate, Guest guest, Room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.room = room;
    }

    // Getters and setters

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

    // Other methods, if needed


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
