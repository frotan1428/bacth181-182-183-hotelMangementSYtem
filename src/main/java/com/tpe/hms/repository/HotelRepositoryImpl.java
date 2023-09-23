package com.tpe.hms.repository;

import com.tpe.hms.config.HibernateUtils;
import com.tpe.hms.model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelRepositoryImpl implements HotelRepository{

    //step 13B : saveHotel
    @Override
    public Hotel saveHotel(Hotel hotel) {

        try (Session session =HibernateUtils.getSessionFactory().openSession()){

         Transaction transaction = session.beginTransaction();
         session.save(hotel);
         transaction.commit();
         return hotel;

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
}
