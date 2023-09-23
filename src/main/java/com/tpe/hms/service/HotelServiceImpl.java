package com.tpe.hms.service;

import com.tpe.hms.model.Hotel;
import com.tpe.hms.repository.HotelRepository;

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


}
