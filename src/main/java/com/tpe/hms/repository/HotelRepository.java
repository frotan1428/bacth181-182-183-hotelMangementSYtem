package com.tpe.hms.repository;

import com.tpe.hms.model.Hotel;

import java.util.List;

public interface HotelRepository {


    //step 13a : create Hotel

    Hotel saveHotel(Hotel hotel);

    //step 14 a : find hotel by Id

    Hotel findHotelById(Long id);

    //step 15 a delete hotel by id;

    void deleteHotelById(Long id);

    //step 16a display All hotels
    List<Hotel>   findAllHotels();

    //step 17a update hotel

    void updateHotel(Hotel existHotel);

}
