package com.tpe.HotelManagementSystem.reposiotry;

import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;

import java.util.List;

public interface RoomRepository {

    //step 18a: saveRoom
    Room saveRoom(Room room);
    //step 19a : findRoomById
    Room findRoomById(Long roomId);

    //step 20a: findAllRoom
    List<Room> findAllRoom();

    //step 21a:deleteRoomById
    void deleteRoomById(Long id);

}
