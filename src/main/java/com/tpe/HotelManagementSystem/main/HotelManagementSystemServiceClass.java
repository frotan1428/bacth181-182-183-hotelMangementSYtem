package com.tpe.HotelManagementSystem.main;

import com.tpe.HotelManagementSystem.Serivce.*;
import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.reposiotry.*;

import java.util.Scanner;

public class HotelManagementSystemServiceClass {
    //step 10 :create HotelManagementSystemServiceClass call this in main class


    private static Scanner scanner;
    public static void displayMenuHotelManagementSystem() {


        // Create an instance of hotelRepository and hotelService
        HotelRepository hotelRepository = new HotelRepositoryImpl();
        HotelService hotelService = new HotelServiceImpl(hotelRepository);

        // Create an instance of RoomRepository and RoomService
        RoomRepository roomRepository = new RoomRepositoryImpl();
        RoomService roomService = new RoomServiceImpl(roomRepository, hotelRepository);

        // Create an instance of Guest Repository
        GuestRepository guestRepository = new GuestRepositoryImpl();
        GuestService guestService = new GuestServiceImpl(guestRepository);

        // Create an instance of Reservation Repository
        ReservationRepository reservationRepository = new ReservationRepositoryImpl();
        ReservationService reservationService = new ReservationServiceImpl(reservationRepository, guestRepository, roomRepository);

        // Create a Scanner for user input
       scanner = new Scanner(System.in);

        // Menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Management System  Menu ====");
            System.out.println("1. Hotel Operations");
            System.out.println("2. Room Operations");
            System.out.println("3. Guest Operations");
            System.out.println("4. Reservation Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            /*
            The reason for using scanner.nextLine() after scanner.nextInt() is
            to consume the newline character (\n) that is left in the input stream
             */

            int choice = scanner.nextInt();
             scanner.nextLine(); // to consume the newline character (\n):

            switch (choice) {
                case 1:
                    displayHotelOperationsMenu(hotelService);
                    break;
                case 2:
                    displayRoomOperationsMenu(roomService);
                    break;
                case 3:
                    displayGuestOperationsMenu(guestService);
                    break;
                case 4:
                    displayReservationOperationsMenu(reservationService);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }

    //step 13[a-b-c-d-e]:  Hotel operation

    private static void displayHotelOperationsMenu(HotelService hotelService) {
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    //step 13e:saveHotel
                    System.out.println("==== Add a new hotel ====");
                    hotelService.saveHotel();
                    break;
                case 2:
                    // //step 14e:findHotelById
                    System.out.println("Enter the hotel ID: ");
                    Long hotelId = scanner.nextLong();
                    hotelService.findHotelById(hotelId);
                    break;
                case 3:
                    ////step 15e :deleteHotelById
                    System.out.print("Enter the hotel ID to delete: ");
                    Long id = scanner.nextLong();
                    hotelService.deleteHotelById(id);
                    break;
                case 4:
                    //step 16e: findAllHotels
                    System.out.println("==== Find All Hotels ====");
                    hotelService.findAllHotels();
                    break;
                case 5:
                    //step 17 e: updateHotelById
                    System.out.println("==== Update Hotel By ID ====");
                    System.out.print("Enter the hotel ID to update: ");
                    Long hotelId1 = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    try {
                        Hotel existingHotel = hotelService.findHotelById(hotelId1);
                        System.out.print("Enter the updated hotel name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the updated hotel location: ");
                        String location = scanner.nextLine();
                        Hotel updatedHotel = new Hotel();
                        updatedHotel.setId(hotelId1);
                        updatedHotel.setName(name);
                        updatedHotel.setLocation(location);
                        hotelService.updateHotelById(hotelId1, updatedHotel);
                    } catch (HotelNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    //step 18[a-b-c-d-e]: Room Crud operation
    //!!! open RoomRepository
    private static void displayRoomOperationsMenu(RoomService roomService) {
         scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    //step 18e: saveRoom
                    System.out.println("==== Add New Room ====");
                    roomService.saveRoom();
                    break;
                case 2:
                    //step 19e : findRoomById
                    System.out.print("Enter the Room ID to Find: ");
                    Long roomId = scanner.nextLong();
                    roomService.findRoomById(roomId);
                    break;
                case 3:
                    //step 20e: findAllRoom
                    System.out.println("==== Delete Room By ID ====");
                    System.out.print("Enter the room ID to delete: ");
                    Long roomIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    roomService.deleteRoomById(roomIdToDelete);
                    break;
                case 4:
                    //step 21e:deleteRoomById
                    System.out.println("==== Find All Rooms ====");
                    roomService.findAllRooms();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    //step 22[a-b-c-d-e]: Guest Operation
    //!!! open Guest Entity -reservation

    private static void displayGuestOperationsMenu(GuestService guestService) {
       scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    //step 22e : saveGuest
                    System.out.println("==== Add New Guest ====");
                    guestService.saveGuest();
                    break;
                case 2:
                    //step 23e : findGuestById
                    System.out.print("Enter the Guest ID to Find: ");
                    Long guestId = scanner.nextLong();
                    guestService.findGuestById(guestId);
                    break;
                case 3:

                    //step 24e DeleteGuestById
                    System.out.println("==== Delete Guest By ID ====");
                    System.out.print("Enter the Guest ID to delete: ");
                    Long guestIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    guestService.deleteGuestId(guestIdToDelete);
                    break;
                case 4:
                    //step 25e :FindAllGuest
                    System.out.println("==== Find All Guests ====");
                    guestService.findAllGuest();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // //step 26[a-b-c-d-e]: Reservation Operation

    private static void displayReservationOperationsMenu(ReservationService reservationService) {
      scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation By ID");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("==== Add a new reservation ====");
                    //step 26e ::saveReservation
                    reservationService.saveReservation();
                    break;
                case 2:
                    //step 27e ::findReservationById
                    System.out.print("Enter the reservation ID: ");
                    Long reservationId = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    reservationService.findReservationById(reservationId);
                    break;
                case 3:
                    //step 28e ::findAllReservations
                    System.out.println("==== Find All Reservations ====");
                    reservationService.findAllReservations();
                    break;
                case 4:
                    //step 29e ::deleteReservationById
                    System.out.print("Enter the reservation ID to delete: ");
                    Long reservationIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    reservationService.deleteReservationById(reservationIdToDelete);
                    break;

                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


}
