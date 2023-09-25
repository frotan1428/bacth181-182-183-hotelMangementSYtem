package com.tpe.hms.repository;

import com.tpe.hms.config.HibernateUtils;
import com.tpe.hms.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public Room saveRoom(Room room) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
           Transaction tx = session.beginTransaction();
           session.save(room);
           tx.commit();
           return room;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
