package com.tpe.HotelManagementSystem.Serivce;

import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;
import com.tpe.HotelManagementSystem.reposiotry.HotelRepository;
import com.tpe.HotelManagementSystem.reposiotry.RoomRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomServiceImpl implements RoomService {

    private Scanner scanner;

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    // Step 18d :saveRoom
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

    // Step 19d :findRoomById
    @Override
    public Room findRoomById(Long id) {
     try {
         Room foundRoom = roomRepository.findRoomById(id);
         if (foundRoom != null) {
             System.out.println("---------------------------------");
             System.out.println(foundRoom);

             return foundRoom;
         } else {
             throw new RoomNotFoundException(" Room  not found with ID: " + id);
         }
     }catch (RoomNotFoundException e){
         System.out.println(e.getMessage());
         return null;
     }
    }

    //step 20c :findAllRooms

    @Override
    public List<Room> findAllRooms() {
        try {
            List<Room> rooms = roomRepository.findAllRoom();
            if (!rooms.isEmpty()) {
                for (Room room : rooms) {
                    System.out.println(room);
                }
            } else {
                throw new RuntimeException("No rooms found.");
            }
            return rooms;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>(); // Return an empty ArrayList
        }
    }


    //step 21d : deleteRoomById
    @Override
    public void deleteRoomById(Long id) {
        try {
            Room existingRoom = roomRepository.findRoomById(id);
            if (existingRoom == null) {
                throw new RoomNotFoundException("Room not found with ID: " + id);
            }

            roomRepository.deleteRoomById(id);
            System.out.println("Room  deleted successfully. ID: " + id);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
