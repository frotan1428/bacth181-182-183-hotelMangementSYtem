package com.tpe.hms.main;

import com.tpe.hms.repository.HotelRepository;
import com.tpe.hms.repository.HotelRepositoryImpl;
import com.tpe.hms.service.HotelService;
import com.tpe.hms.service.HotelServiceImpl;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class HotelManagementSystemServiceClass {

    //step 10 : create HotelManagementSystemServiceClass


    private static Scanner scanner;

    public static void displayMenuHotelManagementSystem(){

        //create an instance pf hotel repository and hotel service ;
        HotelRepository hotelRepository= new HotelRepositoryImpl();
        HotelService hotelService= new HotelServiceImpl(hotelRepository);

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
                     System.out.println("2. Room Operations");
                     break;
                 case 3:
                     System.out.println("3. Guest Operations");
                     break;
                 case 4:
                     System.out.println("4. Reservation Operations");
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

                    System.out.println("5. Update   Hotel  by Id ");
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
}
