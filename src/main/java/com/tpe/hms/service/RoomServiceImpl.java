package com.tpe.hms.service;

import com.tpe.hms.exception.HotelNotFoundException;
import com.tpe.hms.exception.RoomNotFoundException;
import com.tpe.hms.model.Hotel;
import com.tpe.hms.model.Room;
import com.tpe.hms.repository.HotelRepository;
import com.tpe.hms.repository.RoomRepository;

import java.util.Scanner;

public class RoomServiceImpl  implements RoomService{

    //create Scanner Object
    private static Scanner scanner;

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }


    //step 18D : save room
    @Override
    public Room saveRoom() {
        scanner = new Scanner(System.in);

        Room room = new Room();
        System.out.print("Enter room Id: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Enter room number: ");
        room.setNumber(scanner.nextLine());
        System.out.print("Enter room capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character

        // Prompt the user to enter the hotel id
        System.out.print("Enter hotel ID: ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        try {
            // Find the existing hotel by ID
            Hotel existingHotel = hotelRepository.findHotelById(hotelId);
            if (existingHotel == null) {
                throw new HotelNotFoundException("Hotel not found with ID: " + hotelId);
            }

            // Associate the room with the hotel
            room.setHotel(existingHotel);

            // Save the room using the room repository
            Room savedRoom = roomRepository.saveRoom(room);

            // Add the room to the hotel's room collection
            existingHotel.getRooms().add(savedRoom);

            // Update the hotel in the hotel repository
            //  hotelRepository.updateHotel(existingHotel);

            System.out.println("Room saved successfully! Room ID: " + savedRoom.getId());
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return room;
    }


    //step 19 d: find Room By Id;
    @Override
    public Room findRoomById(Long id) {

      try {
          Room foundRoom=  roomRepository.findRoomById(id);
          if (foundRoom!=null){
              System.out.println("===========================");
               System.out.println(foundRoom);
              return  foundRoom;

          }else {
              throw  new RoomNotFoundException("Room Not Found WIth Id : "+id);
          }
      }catch (RoomNotFoundException e){
          System.out.println(e.getMessage());

      }
        return  null;
    }
}

