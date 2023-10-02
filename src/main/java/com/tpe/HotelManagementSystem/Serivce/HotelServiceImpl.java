package com.tpe.HotelManagementSystem.Serivce;


import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.reposiotry.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelServiceImpl  implements HotelService {

    private static Scanner scanner;


    /*
         The HotelServiceImpl constructor is responsible for initializing the hotelRepository field.
         It takes a HotelRepository object as a parameter and assigns it to the hotelRepository field
         using the this keyword
     */

    private final HotelRepository hotelRepository;
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
   // HotelRepository hotelRepository1= new HotelRepositoryImpl();


        //step 13d:saveHotel
        @Override
    public Hotel saveHotel() {
         scanner = new Scanner(System.in);

        Hotel hotel = new Hotel();

        System.out.print("Enter hotel Id: ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();//Consume the newline character
        System.out.print("Enter hotel name: ");
        hotel.setName(scanner.nextLine());
        System.out.print("Enter hotel location: ");
        hotel.setLocation(scanner.nextLine());

        // Save the Hotel object using the HotelRepository
        hotelRepository.saveHotel(hotel);

        System.out.println("Hotel saved successfully! Hotel ID: " + hotel.getId());

        return hotel;
    }


    // //step 14d:findHotelById
    @Override
    public Hotel findHotelById(Long id) throws HotelNotFoundException {

    try {
        Hotel foundHotel = hotelRepository.findHotelById(id);
        if (foundHotel != null) {
            System.out.println("---------------------------------");
            System.out.println(foundHotel);

            return foundHotel;
        } else {
            throw new HotelNotFoundException("Hotel not found with ID: " + id);
        }
    }catch (HotelNotFoundException e){
        System.out.println(e.getMessage());
        return null;
    }
  }

    //step 15d :deleteHotelById
    @Override
    public void deleteHotelById(Long id) throws HotelNotFoundException {
        scanner= new Scanner(System.in);
        try {
            Hotel hotelToDelete = hotelRepository.findHotelById(id);
            if (hotelToDelete == null) {
                throw new HotelNotFoundException("Hotel not found with ID: " + id);
            }
            System.out.println(hotelToDelete);

            System.out.println("Are you sure you want to delete the hotel with ID: " + hotelToDelete.getId() + "? (Y/N)");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                hotelRepository.deleteHotelById(hotelToDelete.getId());
                System.out.println("Hotel deleted successfully. ID: " + hotelToDelete.getId());
            } else {
                System.out.println("Delete operation canceled.");
            }
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    //step 16d: findAllHotels
    @Override
    public List<Hotel> findAllHotels() {
        try {
            List<Hotel> hotels = hotelRepository.findAllHotels();
            if (!hotels.isEmpty()) {
                System.out.println("List of Hotels:");
                for (Hotel hotel : hotels) {
                    System.out.println(hotel);
                    System.out.println("-----------------------------");
                }
            } else {
                System.out.println("Hotel list is empty.");
            }

            return hotels;
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving hotels: " + e.getMessage());
            return null;
        }
    }


    //step 17d : updateHotelById
    @Override
    public void updateHotelById(Long id, Hotel updatedHotel) throws HotelNotFoundException {
        try {
            Hotel existingHotel = hotelRepository.findHotelById(id);
            if (existingHotel == null) {
                throw new HotelNotFoundException("Hotel not found with ID: " + id);
            }

            // Perform any validation or business logic before updating the hotel

            existingHotel.setName(updatedHotel.getName());
            existingHotel.setLocation(updatedHotel.getLocation());


            // Perform any other property updates as needed

            hotelRepository.updateHotel(existingHotel);
            System.out.println("Hotel updated successfully!");
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



}
