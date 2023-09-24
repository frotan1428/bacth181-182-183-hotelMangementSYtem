package com.tpe.hms.repository;

import com.tpe.hms.config.HibernateUtils;
import com.tpe.hms.exception.HotelNotFoundException;
import com.tpe.hms.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    //step 14 b find hotel By Id;
    @Override
    public Hotel findHotelById(Long id) {
     Session session= HibernateUtils.getSessionFactory().openSession();
     return session.get(Hotel.class,id);

    }

    @Override
    public void deleteHotelById(Long id) {
            try (Session session = HibernateUtils.getSessionFactory().openSession()){
               Transaction transaction = session.beginTransaction();

             Hotel hotelToDelete  = session.get(Hotel.class,id);
             if (hotelToDelete!=null){
                 session.delete(hotelToDelete);
                 transaction.commit();
             }else {
                 throw  new HotelNotFoundException("Hotel Not Found with Id " + id);
             }
            // HibernateUtils.CloseSession(session);
             session.close();
            }catch (HibernateException e){
                e.printStackTrace();
            }
    }

    //step 16B findAll Hotels
    @Override
    public List<Hotel> findAllHotels() {
     Session session =  HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("FROM Hotel", Hotel.class).getResultList();
    }


}
