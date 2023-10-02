package com.tpe.HotelManagementSystem.reposiotry;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository{

     //step 18b: saveRoom
    @Override
    public Room saveRoom(Room room) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
            return room;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //!!! open service pk step 24C here

    //step 19b : findRoomById
    @Override
    public Room findRoomById(Long roomId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Room.class, roomId);
    }

    //step 20b: findAllRoom
    @Override
    public List<Room> findAllRoom() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Room";
            List<Room> rooms = session.createQuery(hql, Room.class).getResultList();
           // System.out.println(rooms);
            return rooms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //step 21b:deleteRoomById
    @Override
    public void deleteRoomById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Room room = session.get(Room.class, id);
            if (room != null) {
                // Remove the room from the associated hotel's room list
                Hotel hotel = room.getHotel();
                if (hotel != null) {
                    hotel.getRooms().remove(room);
                }
                // Delete the room
                session.delete(room);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
