package com.tpe.HotelManagementSystem.reposiotry;


import com.tpe.HotelManagementSystem.model.Hotel;

import java.util.List;

public interface HotelRepository {
    //step 13a: create  saveHotel() //!!open HotelRepositoryImpl
    Hotel saveHotel(Hotel hotel);
    //step 14a: create  findHotelById() //!!open HotelRepositoryImpl
     Hotel findHotelById(Long id);
    //step 15a: create  deleteHotelById() //!!open HotelRepositoryImpl
    void deleteHotelById(Long id);
    //step 16a: create  findAllHotels() //!!open HotelRepositoryImpl
    List<Hotel> findAllHotels();
    //step 17a:   updateHotel() //!!open HotelRepositoryImpl

    void updateHotel(Hotel existingHotel);

}
