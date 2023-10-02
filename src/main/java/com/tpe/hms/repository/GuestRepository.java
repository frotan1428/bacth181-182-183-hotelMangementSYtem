package com.tpe.hms.repository;

import com.tpe.hms.model.Guest;

public interface GuestRepository {

    //22a : save Guest

    void saveGuest(Guest guest);

    //23 a : findGuestById
    Guest findGuestById(Long id);

}
