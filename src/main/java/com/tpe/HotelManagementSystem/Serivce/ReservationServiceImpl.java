package com.tpe.HotelManagementSystem.Serivce;

import com.tpe.HotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.HotelManagementSystem.exception.ReservationNotFoundException;
import com.tpe.HotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.HotelManagementSystem.model.Guest;
import com.tpe.HotelManagementSystem.model.Reservation;
import com.tpe.HotelManagementSystem.model.Room;
import com.tpe.HotelManagementSystem.reposiotry.GuestRepository;
import com.tpe.HotelManagementSystem.reposiotry.ReservationRepository;
import com.tpe.HotelManagementSystem.reposiotry.RoomRepository;



import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;

public class ReservationServiceImpl implements ReservationService {

    private Scanner scanner;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

// In ReservationServiceImpl class

    //step 26d ::saveReservation
    @Override
    public Reservation saveReservation() {
        scanner = new Scanner(System.in);

        System.out.print("Enter guest ID: ");
        Long guestId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter room ID: ");
        Long roomId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter check-in date (yyyy-MM-dd): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter check-out date (yyyy-MM-dd): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        try {
            Guest existingGuest = guestRepository.findGuestById(guestId);
            if (existingGuest == null) {
                throw new GuestNotFoundException("Guest not found with ID: " + guestId);
            }

            Room existingRoom = roomRepository.findRoomById(roomId);
            if (existingRoom == null) {
                throw new RoomNotFoundException("Room not found with ID: " + roomId);
            }

            Reservation reservation = new Reservation();
            reservation.setGuest(existingGuest);
            reservation.setRoom(existingRoom);
            reservation.setCheckInDate(checkInDate);
            reservation.setCheckOutDate(checkOutDate);

            reservationRepository.saveReservation(reservation);

            System.out.println("Reservation saved successfully! Reservation ID: " + reservation.getId());
            return reservation;
        } catch (GuestNotFoundException | RoomNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    //step 27d ::findAllReservations
    @Override
    public List<Reservation> findAllReservations()  {
        List<Reservation> reservations = reservationRepository.findAllReservations();
        return reservations;
    }


    //step 28d ::findReservationById
    @Override
    public void findReservationById(Long id) {
        Reservation foundReservation = reservationRepository.findReservationById(id);

        if (foundReservation != null) {
            System.out.println(foundReservation);
        } else {
            System.out.println("Reservation not found with ID: " + id);
        }
    }


    //step 29d ::deleteReservationById
    @Override
    public void deleteReservationById(Long id) {
        try {
            Reservation existingReservation = reservationRepository.findReservationById(id);
            if (existingReservation == null) {
                throw new ReservationNotFoundException("Reservation not found with ID: " + id);
            }

            reservationRepository.deleteReservationById(id);
            System.out.println("Reservation deleted successfully. ID: " + id);
        } catch (ReservationNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
