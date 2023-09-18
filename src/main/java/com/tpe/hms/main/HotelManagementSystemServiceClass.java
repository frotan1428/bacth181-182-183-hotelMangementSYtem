package com.tpe.hms.main;

import java.util.Scanner;

public class HotelManagementSystemServiceClass {

    //step 10 : create HotelManagementSystemServiceClass

    private static Scanner scanner;

    public static void displayMenuHotelManagementSystem(){

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
                     System.out.println("1. Hotel Operations");
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
}
