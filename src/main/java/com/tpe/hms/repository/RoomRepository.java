package com.tpe.hms.repository;

import com.tpe.hms.model.Room;

public interface RoomRepository {
    //step 18a save room
    Room saveRoom(Room room);

    //step 19 a : FindRoomById
    Room findRoomById(Long roomId);
}
