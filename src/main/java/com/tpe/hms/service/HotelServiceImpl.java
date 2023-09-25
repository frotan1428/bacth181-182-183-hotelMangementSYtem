package com.tpe.hms.service;

import com.tpe.hms.exception.HotelNotFoundException;
import com.tpe.hms.model.Hotel;
import com.tpe.hms.repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelServiceImpl implements HotelService{



    private static Scanner scanner;
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // HotelRepository hotelRepository = new HotelRepositoryImpl();

    @Override
    public Hotel saveHotel() {
        scanner = new Scanner(System.in);//1
        Hotel hotel = new Hotel();

        System.out.print("Enter the Hotel ID: ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();//consume new line
        System.out.print("Enter Hotel Name : ");
        hotel.setName(scanner.nextLine());
        System.out.println("Enter Hotel Location : ");
        hotel.setLocation(scanner.nextLine());

        //save the hotel object using Repository
        hotelRepository.saveHotel(hotel);
        System.out.println("Hotel saved successfully ! Hotel ID  "+ hotel.getId());//1
        return hotel;
    }

    //step 14 D : find Hotel By id;
    @Override
    public Hotel findHotelById(Long id) {

       try {
         Hotel foundHotel =  hotelRepository.findHotelById(id);
         if (foundHotel!=null){
             System.out.println("--------------------------");
             System.out.println(foundHotel);
             return foundHotel;
         }else {
             throw new HotelNotFoundException("Hotel not Found With ID : " +id);
         }
       }catch (HotelNotFoundException e){
           System.out.println(e.getMessage());
           return null;
       }
    }



    //step 15 D : Delete hotel By id;
    @Override
    public void DeleteHotelById(Long id) {
        scanner = new Scanner(System.in);
     try {
       Hotel hotelToDelete =  hotelRepository.findHotelById(id);//1
       if (hotelToDelete==null){
         throw  new HotelNotFoundException("Hotel not found with ID: "+id);
       }
       System.out.println(hotelToDelete);

         System.out.println("Are you Sure you want to delete Hotel By Id : " +hotelToDelete.getId() + "? (Y/N)");
         String confirmation  = scanner.nextLine();
         if (confirmation.equalsIgnoreCase("Y")){
             hotelRepository.deleteHotelById(hotelToDelete.getId());
             System.out.println("Hotel deleted Successfully  by  Id :  " +hotelToDelete.getId());
         }else {
             System.out.println("Delete Operation is Cancelled ....");
         }
       }catch (HotelNotFoundException e){
         System.out.println(e.getMessage());

     }

    }

    //step 16d : find All hotels
    @Override
    public List<Hotel> findAllHotels() {
      // return hotelRepository.findAllHotels();
        try {
         List<Hotel>   hotels =   hotelRepository.findAllHotels();
         if (!hotels.isEmpty()){
             System.out.println("List of the Hotels");
             for (Hotel hotel:hotels){
                 System.out.println(hotel);
                 System.out.println("------------------------------------------------------------");
             }
         }else {
             System.out.println("Hotel List is Empty ...");
         }
         return hotels;
        }catch (Exception e){
            System.out.println("An error occurred while retrieving  hotels + "+ e.getMessage());
            return null;
        }
    }


    //step 17d updateHotelById
    @Override
    public void updateHotelById(Long id, Hotel updateHotel) throws HotelNotFoundException {

        try {
          Hotel existHotel =  hotelRepository.findHotelById(id);
          if (existHotel==null){
              throw  new HotelNotFoundException("Hotel Not Found WIth ID : "+id);
          }


          //perform an validation or  business logic class before updating hotel
            existHotel.setName(updateHotel.getName());
          existHotel.setLocation(updateHotel.getLocation());

          hotelRepository.updateHotel(existHotel);
            System.out.println("Hotel updated successfully .....");
        }catch (HotelNotFoundException e){
            System.out.println(e.getMessage());
        }
    }



}
