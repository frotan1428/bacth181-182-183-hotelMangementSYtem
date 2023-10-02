package com.tpe.hms.service;

import com.tpe.hms.exception.GuestNotFoundException;
import com.tpe.hms.exception.RoomNotFoundException;
import com.tpe.hms.model.Guest;
import com.tpe.hms.model.Reservation;
import com.tpe.hms.model.Room;
import com.tpe.hms.repository.GuestRepository;
import com.tpe.hms.repository.ReservationRepository;
import com.tpe.hms.repository.RoomRepository;

import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.Scanner;

public class ReservationServiceImpl implements  ReservationService {


    private Scanner scanner;
    private final ReservationRepository reservationRepository;

    private final GuestRepository guestRepository;

   private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }


    //step 26 d:  saveReservation
    @Override
    public Reservation saveReservation() {

        scanner = new Scanner(System.in);
        //find Guest  by id
        //find Room by Id;

         System.out.println("Enter the Guest Id :");
         Long guestId = scanner.nextLong();
         scanner.nextLine();//consume a new line


        System.out.println("Enter the Room  Id :");
        Long roomId = scanner.nextLong();
        scanner.nextLine();//consume a new line

        System.out.println("Enter the check-in Date (yyyy-MM-dd) :  ");//2023-10-02
        LocalDate checkInDate= LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the check-out Date (yyyy-MM-dd) :  ");//2023-10-02
        LocalDate checkOutDate= LocalDate.parse(scanner.nextLine());


        try {
           Guest existGuest = guestRepository.findGuestById(guestId);
           if (existGuest==null){
               throw  new GuestNotFoundException("Guest not found With id  : "+guestId);
           }


            Room existRoom = roomRepository.findRoomById(roomId);
            if (existRoom==null){
                throw  new RoomNotFoundException("Room  not found With id  : " +roomId);
            }


            Reservation reservation = new Reservation();

            reservation.setGuest(existGuest);
            reservation.setRoom(existRoom);
            reservation.setCheckInDate(checkInDate);
            reservation.setCheckOutDate(checkOutDate);

            reservationRepository.saveReservation(reservation);

            System.out.println("Reservation saved successfully   ! Reservation Id :  " + reservation.getId());

            return reservation;

        }catch (GuestNotFoundException | RoomNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
