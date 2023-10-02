package com.tpe.HotelManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//step 9a: Entity hotel and Room
@Entity
@Table(name = "tbl_hotels")
public class Hotel {


    //!!!  step 12: add filed after main class finished menu

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();

    // Constructors, getters, and setters

    public Hotel() {
    }

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    //to string method

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }

    //!! open Room Entity

}
