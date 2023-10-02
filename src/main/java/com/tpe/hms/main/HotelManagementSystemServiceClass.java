package com.tpe.hms.main;

import com.tpe.hms.exception.HotelNotFoundException;
import com.tpe.hms.model.Hotel;
import com.tpe.hms.repository.*;
import com.tpe.hms.service.*;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class HotelManagementSystemServiceClass {

    //step 10 : create HotelManagementSystemServiceClass


    private static Scanner scanner;

    public static void displayMenuHotelManagementSystem(){

        //create an instance pf hotel repository and hotel service ;
        HotelRepository hotelRepository= new HotelRepositoryImpl();
        HotelService hotelService= new HotelServiceImpl(hotelRepository);

        //create an instance pf Room repository and Room service ;
        RoomRepository roomRepository= new RoomRepositoryImpl();
        RoomService roomService = new RoomServiceImpl(roomRepository,hotelRepository);


        //create instance of Guest Repository

        GuestRepository guestRepository = new GuestRepositoryImpl();
        GuestService guestService = new GuestServiceImpl(guestRepository);

        //create instance of Reservation  Repository and ReservationService

        ReservationRepository reservationRepository= new ReservationRepositoryImpl();
        ReservationService reservationService= new ReservationServiceImpl(reservationRepository,guestRepository,roomRepository);

      scanner = new Scanner(System.in);

      //menu of HMS

        boolean exist=false;
        while (!exist){

            System.out.println("==== Hotel Management System  Menu ====");
            System.out.println("1. Hotel Operations");
            System.out.println("2. Room Operations");
            System.out.println("3. Guest Operations");
            System.out.println("4. Reservation Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

             int choice=  scanner.nextInt();
             scanner.nextLine();//to consume new line

             switch (choice){
                 case 1:
                    displayHotelOperationMenu(hotelService);
                     break;
                 case 2:
                    displayRoomOperationMenu(roomService);
                     break;
                 case 3:
                    displayGuestOperationMenu(guestService);
                     break;
                 case 4:
                    displayReservationOperationMenu(reservationService);
                     break;
                 case 5:
                     System.out.println("5. Exit");
                     break;
                 default:
                     System.out.println("Invalid Choice . Please Try Again .");
                     break;
             }
        }
      //   scanner.close();
    }

    //step 13[a-b-c-d-e] Hotel Operation

    private static void displayHotelOperationMenu(HotelService hotelService){
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            System.out.println("======Hotel Operations ======");
            System.out.println("1. Add new Hotel  ");
            System.out.println("2. Find  hotel by id  ");
            System.out.println("3. Delete   Hotel  By id ");
            System.out.println("4. Find  All  Hotels  ");
            System.out.println("5. Update   Hotel  by Id ");
            System.out.println("6. Return to  Main Menu  ");
            System.out.print("Enter your Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    //step 13 e: saveHotel
                    System.out.println("---- Add a new Hotel ----");
                    hotelService.saveHotel();
                    break;
                case 2:
                    //step 14 e : findHotelByID
                    System.out.println(" Find  hotel by id  ");
                    Long hotelId=  scanner.nextLong();
                    hotelService.findHotelById(hotelId);
                    break;
                case 3:
                    System.out.println("Enter the hotel Id to Delete  ");
                    Long id=  scanner.nextLong();
                    hotelService.DeleteHotelById(id);
                    break;
                case 4:

                    System.out.println("-----  Find  All  Hotels ----  ");
                    hotelService.findAllHotels();
                    break;
                case 5:
                    System.out.println("======= Update   Hotel  by Id  ======");
                    System.out.println("Enter The Hotel Id To Update : ");
                   Long existId = scanner.nextLong();
                    scanner.nextLine(); //consume new line
                    try {

                      Hotel existHotel =  hotelService.findHotelById(existId);
                        System.out.println("Enter  the Update  hotel Name : ");
                        String name  =scanner.nextLine();
                        System.out.println("Enter the Update Hotel Location : ");
                        String location = scanner.nextLine();

                        //create a new object that we want to update

                        Hotel updateHotel = new Hotel();
                        updateHotel.setId(existId);
                        updateHotel.setName(name);
                        updateHotel.setLocation(location);
                        hotelService.updateHotelById(existId,updateHotel);
                    }catch (HotelNotFoundException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                   exit=true;
                   break;
                default:
                    System.out.println("Invalid choice . please try Again");
                    break;

            }


        }

    }

    //step 18[a-b-c-d-e] : ROOM CRUD OPERATIONS
    private static void displayRoomOperationMenu(RoomService roomService){
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            System.out.println("======Room Operations ======");
            System.out.println("1. Add new Room  ");
            System.out.println("2. Find  Room by id  ");
            System.out.println("3. Delete   Room  By id ");
            System.out.println("4. Find  All  Rooms  ");
            System.out.println("5. Return to  Main Menu  ");
            System.out.print("Enter your Choice :");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    //step 18 e: saveHotel
                    System.out.println("---- Add a new Room ----");
                    roomService.saveRoom();
                    break;
                case 2:

                    //step 19 e: find room by id
                    System.out.println(" Enter the   Room  id to Find:  ");
                    Long  roomId =  scanner.nextLong();
                    roomService.findRoomById(roomId);
                    break;
                case 3:
                    System.out.println("Enter the Room Id to Delete  ");

                    break;
                case 4:

                    System.out.println("-----  Find  All  Rooms ----  ");
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid choice . please try Again");
                    break;
            }


        }

    }


    //step 22{a-b-c-d-e} Guest Operation
    private static void displayGuestOperationMenu(GuestService guestService){
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            System.out.println("======Guest Operations ======");
            System.out.println("1. Add new Guest  ");
            System.out.println("2. Find  Guest by id  ");
            System.out.println("3. Delete   Guest  By id ");
            System.out.println("4. Find  All  Guest  ");
            System.out.println("5. Return to  Main Menu   ");
            System.out.print("Enter your Choice  :");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    //step 18 e: saveHotel
                    System.out.println("---- Add a new Guest ----");
                    guestService.saveGuest();
                    break;
                case 2:

                    System.out.println("Enter  the  Guest  id to Find :   ");
                     Long guestId =  scanner.nextLong();
                     guestService.findGuestByID(guestId);
                    break;
                case 3:
                    System.out.println("Enter the Guest Id to Delete  ");

                    break;
                case 4:

                    System.out.println("-----  Find  All  Guest ----  ");
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid choice . please try Again");
                    break;
            }


        }

    }


    //step 26[a-b-c-d-e] save Reservation

    private static void displayReservationOperationMenu(ReservationService  reservationService){
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit){
            System.out.println("======Reservation   Operations ======");
            System.out.println("1. Add new Reservation ");
            System.out.println("2. Find  Reservation by id  ");
            System.out.println("3. Delete   Reservation  By id ");
            System.out.println("4. Find  All  Reservations  ");
            System.out.println("5. Return to  Main Menu    ");
            System.out.print("Enter  your  Choice  :");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    //step 18 e: saveHotel
                    System.out.println("---- Add a new Reservation ----");
                    reservationService.saveReservation();
                    break;
                case 2:

                    System.out.println("Enter  the  Reservation  id to Find :   ");
                    Long guestId =  scanner.nextLong();
                    //guestService.findGuestByID(guestId);
                    break;
                case 3:
                    System.out.println("Enter the Reservation Id to Delete  ");

                    break;
                case 4:

                    System.out.println("-----  Find  All  Reservation ----  ");
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid choice . please try Again");
                    break;
            }


        }

    }

}
