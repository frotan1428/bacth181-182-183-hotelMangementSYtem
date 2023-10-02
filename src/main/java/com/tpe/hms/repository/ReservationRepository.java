package com.tpe.hms.repository;

import com.tpe.hms.model.Reservation;

public interface ReservationRepository {

    //step 26 a : save reservation
    Reservation saveReservation(Reservation reservation);
}
