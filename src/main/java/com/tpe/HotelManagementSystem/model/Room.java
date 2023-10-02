package com.tpe.HotelManagementSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_rooms")
public class Room {
    // step 9b: create Entity
    //!!  step 13 : fill this after Hotel Entity

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    // Constructors, getters, and setters

    //it is optional
    public Room() {
    }

    public Room(Long id, String number, int capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }

// Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

   //to string method



    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
//                ", hotel=" + hotel +
                '}';
    }

    //!! open Guest Entity
}
