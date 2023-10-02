package com.tpe.HotelManagementSystem.reposiotry;

import com.tpe.HotelManagementSystem.model.Reservation;

import java.util.List;

public interface ReservationRepository {

    //step 26a : saveReservation
    Reservation saveReservation(Reservation reservation);

    //step 27a : FindReservation bY id :
    Reservation findReservationById(Long id);

    //step 28a : FindAll Reservation
    List<Reservation> findAllReservations();


    //Step 29a :DeleteReservationById
    void deleteReservationById(Long id);
}
