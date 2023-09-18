package com.tpe.hms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//step 9a : Entity hotel and room
@Entity
@Table(name = "tbl_hotel")
public class Hotel {//hotel

    //step 12 : add some filed about hotel

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false )
    private String location;

    //Constructors-getter and setter


    public Hotel() {
    }

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

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

    //to String method


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
