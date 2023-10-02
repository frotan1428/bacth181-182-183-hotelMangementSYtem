package com.tpe.HotelManagementSystem.reposiotry;


import com.tpe.HotelManagementSystem.config.HibernateUtil;

import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelRepositoryImpl implements HotelRepository {
//step 13b: implement HotelRepository

    @Override
    public Hotel saveHotel(Hotel hotel) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(hotel);
            transaction.commit();

            return hotel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //!!!open service pk

//step 14b: findHotelById()
    @Override
    public Hotel findHotelById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Hotel.class, id);
    }
    //step 15b: deleteHotelById()

    @Override
    public void deleteHotelById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Hotel hotelToDelete = session.get(Hotel.class, id);
            // Delete the associated rooms first
            if (hotelToDelete != null) {
                session.delete(hotelToDelete);
                transaction.commit();

            } else {
                throw new HotelNotFoundException("Hotel not found with ID: " + id);
            }
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }





    //step 16b:findAllHotels
    @Override
    public List<Hotel> findAllHotels() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Hotel", Hotel.class).getResultList();
    }


    //step 17b: updateHotel()
    @Override
    public void updateHotel(Hotel hotel) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Load the hotel entity using the same session
            Hotel existingHotel = session.get(Hotel.class, hotel.getId());
            if (existingHotel != null) {
                existingHotel.setName(hotel.getName());
                existingHotel.setLocation(hotel.getLocation());
                // Update other properties as needed

                session.update(existingHotel);
            }

            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
