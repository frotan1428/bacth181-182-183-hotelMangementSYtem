package com.tpe.HotelManagementSystem.Serivce;



import com.tpe.HotelManagementSystem.model.Room;

import java.util.List;

public interface RoomService {
     //step 18c:saveRoom
    Room saveRoom();
    //!! Open menu add: step 25d: here
    //step 19c :findRoomById
     Room findRoomById(Long id);

    //step 20c: findAllRoom
    List<Room> findAllRooms();

    //step 21c:deleteRoomById
    void deleteRoomById(Long id);
}
