package com.tpe.HotelManagementSystem.Serivce;

import com.tpe.HotelManagementSystem.model.Guest;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;

import java.util.List;

public interface GuestService {
    //22c : saveGuest
    Guest saveGuest();
    //23c : findGuestById
    void findGuestById(Long id);

    //25c: findALlGuest
    List<Guest> findAllGuest();


    //24c: deleteGuestById
    void deleteGuestId(Long id);



}
