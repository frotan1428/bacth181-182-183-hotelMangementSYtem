package com.tpe.hms.repository;

import com.tpe.hms.config.HibernateUtils;
import com.tpe.hms.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepositoryImpl implements ReservationRepository{

    //step 26 b : saveReservation
    @Override
    public Reservation saveReservation(Reservation reservation) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
          Transaction transaction =  session.beginTransaction();
          session.save(reservation);

          transaction.commit();
          return  reservation;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
