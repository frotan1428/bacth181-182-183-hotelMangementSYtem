package com.tpe.HotelManagementSystem.reposiotry;

import com.tpe.HotelManagementSystem.model.Guest;

import java.util.List;

public interface GuestRepository {

    //22a : saveGuest
    void saveGuest(Guest guest);
    //23a : findGuestById

    Guest findGuestById(Long guestId);

    //24a: deleteGuestById
    void deleteGuestById(Long id);

    //25a: findALlGuest
    List<Guest> findAllGuest();
}