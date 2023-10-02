package com.tpe.HotelManagementSystem.reposiotry;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.exception.ReservationNotFoundException;
import com.tpe.HotelManagementSystem.model.Reservation;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {


    //step 26b ::saveReservation
    @Override
    public Reservation saveReservation(Reservation reservation) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(reservation);

            transaction.commit();
            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




   //step 27b findReservationById
   @Override
   public Reservation findReservationById(Long id) {
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           Reservation reservation = session.get(Reservation.class, id);
           Hibernate.initialize(reservation); // Explicitly initialize the proxy object
           return reservation;
       } catch (Exception e) {
           e.printStackTrace();
           throw new ReservationNotFoundException("Issue occurred during fetching Reservation");
       }
   }


//    @Override
//    public Reservation findReservationById(Long id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Reservation foundReservation = session.get(Reservation.class, id);
//            Hibernate.initialize(foundReservation); // Initialize the proxy object
//            if (Hibernate.isInitialized(foundReservation)) {
//                System.out.println("---------------------------------");
//                System.out.println(foundReservation);
//            } else {
//                throw new ReservationNotFoundException("Reservation not found with ID: " + id);
//            }
//
//            return foundReservation;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw  new ReservationNotFoundException("issue occur during fetch reservation");
//        }
//    }


    //step 28b ::findAllReservations
    @Override
    public List<Reservation> findAllReservations()  {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Reservation";
            List<Reservation> reservations = session.createQuery(hql, Reservation.class).getResultList();
            if (reservations.isEmpty()) {
                System.out.println("Reservation is empty");
            }
            //System.out.println(reservations);
            return reservations;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReservationNotFoundException("Failed to fetch reservations.");
        }
    }



    //step 28b deleteReservationById
    @Override
    public void deleteReservationById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Reservation reservation = session.get(Reservation.class, id);
            if (reservation != null) {
                session.delete(reservation);
                transaction.commit();
            } else {
                System.out.println("Reservation not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    @Override
    public Reservation findReservationById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Reservation.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

 */
}
