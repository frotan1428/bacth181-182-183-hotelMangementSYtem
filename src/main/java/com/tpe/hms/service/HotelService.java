package com.tpe.hms.service;

import com.tpe.hms.exception.HotelNotFoundException;
import com.tpe.hms.model.Hotel;

import java.util.List;

public interface HotelService {

    //step 13C : saveHotel

    Hotel saveHotel();

    //step 13C : find hotel  By Id;

    Hotel findHotelById(Long id);

    //step 15 C : delete hot by id:
    void  DeleteHotelById(Long id);

    //step16 findALl Hotels
    List<Hotel> findAllHotels();

    //step 17C : update hotel by id

    void updateHotelById(Long id, Hotel updateHotel) throws HotelNotFoundException;

}
