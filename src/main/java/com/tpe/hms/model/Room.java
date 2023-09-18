package com.tpe.hms.model;


import javax.persistence.Column;
import javax.persistence.Id;

//step 9b : room entity
public class Room {
    //step 13 : add some filed about Room

    @Id
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private int capacity;

    //getter and setter


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

    //constructor


    public Room(Long id, String number, int capacity) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public Room() {
    }

    //to String Method


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
