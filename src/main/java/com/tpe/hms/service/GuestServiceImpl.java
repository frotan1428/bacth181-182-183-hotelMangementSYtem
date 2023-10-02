package com.tpe.hms.service;

import com.tpe.hms.exception.GuestNotFoundException;
import com.tpe.hms.model.Address;
import com.tpe.hms.model.Guest;
import com.tpe.hms.repository.GuestRepository;
import com.tpe.hms.repository.GuestRepositoryImpl;

import java.util.Scanner;

public class GuestServiceImpl implements GuestService{

    //step 22d  : save Guest

    private static Scanner scanner;

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    //
//    GuestRepository guestRepository = new GuestRepositoryImpl();

    @Override
    public Guest saveGuest() {

        scanner = new Scanner(System.in);
        //create Guest Object
        Guest guest = new Guest();
        System.out.println("Enter the Guest Name :");
        guest.setName(scanner.nextLine());
        //Create address

        Address address= new Address();

        System.out.println("Enter Street : ");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter city : ");
        address.setCity(scanner.nextLine());

        System.out.println("Enter Country : ");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter ZipCode : ");
        address.setZipCode(scanner.nextLine());

        //set Address for th Guest
        guest.setAddress(address);

        //save the guest the GuestRepository

        guestRepository.saveGuest(guest);
        System.out.println("Guest saved Successfully +" + guest.getId());

        return guest;

    }


    //step 23 d: findGuestById
    @Override
    public void findGuestByID(Long id) {
        try {
         Guest foundGuest =   guestRepository.findGuestById(id);

         if (foundGuest != null){
             System.out.println("==================================");
             System.out.println(foundGuest);
         }else {
             throw  new GuestNotFoundException("Guest Not found WIth Id "+ id);
         }

        }catch (GuestNotFoundException e){
            System.out.println(e.getMessage());

        }
    }


}
