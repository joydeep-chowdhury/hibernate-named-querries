package com.joydeep.hibernate.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        int minUserId=5;
        String minuId="5 or 1=1";
        String parameterSubstitute="5";
      //  Query query=session.createQuery("select userName from UserDetails where userId > ?0");
    //    Query query=session.getNamedQuery("UserDetails.byId");
        Query query=session.getNamedNativeQuery("UserDetails.byName");
        query.setString(0,"User Name 10");
        
        List<UserDetails> users=query.list();
        
        session.getTransaction().commit();
        session.close();
       for(UserDetails u:users)
       {
    	   System.out.println(u);
       }
      
	}

}
