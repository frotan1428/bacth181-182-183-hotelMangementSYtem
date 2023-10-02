package com.tpe.HotelManagementSystem.Serivce;

import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;

import java.util.List;

public interface HotelService {
    // step 13c:saveHotel
    Hotel saveHotel();
    //step 14a:findHotelById
    Hotel findHotelById(Long id);

    //step 15c :deleteHotelById
    void deleteHotelById(Long id);
   //step16c: findAllHotels
    List<Hotel> findAllHotels();
    //step 17c: updateHotelById
    void updateHotelById(Long id, Hotel updatedHotel) throws HotelNotFoundException;




}
