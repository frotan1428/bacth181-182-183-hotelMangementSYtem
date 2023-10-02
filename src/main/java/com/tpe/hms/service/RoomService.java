package com.tpe.hms.service;

import com.tpe.hms.model.Room;

public interface RoomService {

    //step 18b save room
    Room saveRoom();

    //step 19 c: find room By Id

    Room findRoomById(Long id);

}
