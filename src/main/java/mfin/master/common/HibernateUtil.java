package mfin.master.common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;

import mfin.master.model.MstKota;

public class HibernateUtil 
{
	
//	private static final SessionFactory sessionFactory = buildSessionFactory();
//	 
//    private static SessionFactory buildSessionFactory() 
//    {
//        try 
//        {
//            // Create the SessionFactory from hibernate.cfg.xml
//            return new AnnotationConfiguration().configure(new File("hibernate.cgf.xml")).buildSessionFactory();
//        }
//        catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
// 
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
// 
//    public static void closeSession() {
//    	// Close caches and connection pools
//    	getSessionFactory().close();
//    }
	
	final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
	static SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	static Session session = factory.openSession();
	static Transaction transaction = session.beginTransaction();
	 
	public static SessionFactory getFactory() {
		return factory;
		 	 
	}
	
	public static Session getSession() {
		return session;
		
	}
	 
	public static Transaction getTransaction() {
		return transaction; 
	}
}