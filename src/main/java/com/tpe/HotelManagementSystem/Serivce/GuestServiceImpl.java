package com.tpe.HotelManagementSystem.Serivce;


import com.tpe.HotelManagementSystem.exception.GuestNotFoundException;

import com.tpe.HotelManagementSystem.model.Address;
import com.tpe.HotelManagementSystem.model.Guest;
import com.tpe.HotelManagementSystem.reposiotry.GuestRepository;


import java.util.List;
import java.util.Scanner;

public class GuestServiceImpl implements GuestService{


    private Scanner scanner;

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    //22d : saveGuest
    @Override
    public Guest saveGuest() {
        scanner = new Scanner(System.in);

        // Create Guest object
        Guest guest = new Guest();
//        System.out.print("Enter guest Id: ");
//        guest.setId(scanner.nextLong());
//        scanner.nextLine();

        System.out.print("Enter guest name: ");
        guest.setName(scanner.nextLine());

        // Create Address object
        Address address = new Address();

        System.out.print("Enter guest Street: ");
        address.setStreet(scanner.nextLine());

        System.out.print("Enter guest City: ");
        address.setCity(scanner.nextLine());

        System.out.print("Enter guest Country: ");
        address.setCountry(scanner.nextLine());

        System.out.print("Enter guest zipCode: ");
        address.setZipCode(scanner.nextInt());

        // Set the Address object to the Guest
        guest.setAddress(address);

        // Save the guest using the GuestRepository
        guestRepository.saveGuest(guest);

        System.out.println("Guest saved successfully! Guest ID: " + guest.getId());

        return guest;
    }

    //23d : findGuestById
    @Override
    public void findGuestById(Long id) throws GuestNotFoundException {
        try {
            Guest foundGuest = guestRepository.findGuestById(id);
            if (foundGuest != null) {
                System.out.println("---------------------------------");
                System.out.println(foundGuest);
            } else {
                throw new GuestNotFoundException("Guest not found with ID: " + id);
            }
        } catch (GuestNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }








    //25c: findALlGuest
    @Override
    public List<Guest> findAllGuest() {
      try {
          List<Guest> guests = guestRepository.findAllGuest();
          if (!guests.isEmpty()) {
              for (Guest guest : guests) {
                  System.out.println(guest);
              }
          } else {
              throw new GuestNotFoundException("Guest  not found");
          }
          return guests;
      }catch (GuestNotFoundException e){
          System.out.println(e.getMessage());
      }
      return null;
    }

    //24d: deleteGuestById
    @Override
    public void deleteGuestId(Long id) {
        try {
            Guest existingGuest = guestRepository.findGuestById(id);
            if (existingGuest == null) {
                throw new GuestNotFoundException("Guest  not found with ID: " + id);
            }
            guestRepository.deleteGuestById(id);
            throw new GuestNotFoundException("Guest  delete successfully  with ID: " + id);
        } catch (GuestNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
