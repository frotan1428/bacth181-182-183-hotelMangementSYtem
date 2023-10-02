package com.tpe.hms.repository;

import com.tpe.hms.config.HibernateUtils;
import com.tpe.hms.model.Address;
import com.tpe.hms.model.Guest;
import com.tpe.hms.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuestRepositoryImpl implements GuestRepository{

    //step 22 b ; save guest
    @Override
    public void saveGuest(Guest guest) {
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
           Transaction transaction = session.beginTransaction();

           //Create a new objet from Adress

            Address address= new Address();
            address.setStreet(guest.getAddress().getStreet());
            address.setCity(guest.getAddress().getCity());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            //set address for the user
            session.save(guest);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //step 22 B: find Guest By id;
    @Override
    public Guest findGuestById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
          Guest foundGuest = session.get(Guest.class,id);
        //  return  session.get(Guest.class,id);
          return foundGuest;
    }
}
