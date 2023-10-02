package com.tpe.HotelManagementSystem.Serivce;

import com.tpe.HotelManagementSystem.model.Reservation;

import java.util.List;

public interface ReservationService {

    //step 26c ::saveReservation
    Reservation saveReservation();





    //step 27c ::findReservationById
    void findReservationById(Long id);

    //step 28c ::findAllReservations
    List<Reservation> findAllReservations();


    //step 29c ::deleteReservationById
    void deleteReservationById(Long id);

}
