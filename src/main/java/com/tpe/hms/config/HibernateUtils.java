package com.tpe.hms.config;

import com.tpe.hms.model.Hotel;
import com.tpe.hms.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//step 1-6
//step 7: HibernateUtils
public class HibernateUtils {


    private static final SessionFactory  sessionFactory;

    static {
       try {
           Configuration configuration= new Configuration()
                   .configure("hibernate.cfg.xml")
                   .addAnnotatedClass(Hotel.class)
                   .addAnnotatedClass(Room.class);

           sessionFactory =configuration.buildSessionFactory();
       }catch (Throwable ex){

           System.err.println("Initial SessionFactory creation failed: " + ex);
           throw new ExceptionInInitializerError(ex);
       }
    }


    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


    public static void shutdown(){
        getSessionFactory().close();
    }

    public static void CloseSession(Session session){
        if (session!=null && session.isOpen()){
            session.close();
        }

    }



}
