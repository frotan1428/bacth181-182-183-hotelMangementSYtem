package com.tpe.HotelManagementSystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_guests")
public class Guest {

    //step 9c: create guest entity


    //step 22: filed the guest  filed
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //First Create Address Class :
    @Embedded  //22-Guest Entity
    private Address address;


    private LocalDateTime createdDate; // we want to see persisted/saved date

    @PrePersist //when you save obj to DB this method will work
    public void prePersist(){
        createdDate = LocalDateTime.now();
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    //First Create Room Entity

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    // Constructors, getters, and setters

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // Other methods, if needed

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
//                ", reservations=" + reservations +
                '}';
    }


    //!!! open Reservation Enity
}
