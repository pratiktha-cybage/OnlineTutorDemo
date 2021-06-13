package com.app.hibernateUtility;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
 

public class HibernateUtil {
    private static  SessionFactory hibernateSession;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal();
    public static  SessionFactory getSessionInstance()  {
    	try {
    		if(hibernateSession == null) {
//        		configureUsingHibernatePropertiesFile();
        		configureUsingHibernateConfigXMLFile();
        	}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return hibernateSession;
    	
    }
    
    
	
    public static void configureUsingHibernateConfigXMLFile(){
    	System.out.println("in hibernate utility");
    	 // Create configuration instance
    	 Configuration configuration = new Configuration();

    	 // Pass hibernate configuration file
    	 configuration.configure("hibernate.cfg.xml");

    	 // Since version 4.x, service registry is being used
    	 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
    	 applySettings(configuration.getProperties()).build(); 

    	 // Create session factory instance
    	 hibernateSession = configuration.buildSessionFactory(serviceRegistry);

    	 
    	
    	 }
    	
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
          session.close();
        }
      }
    
//	public static void configureUsingHibernatePropertiesFile() throws IOException{
//		 // Create configuration instance
//		 Configuration configuration = new Configuration();
//
//		 // Create properties file
//		 Properties properties = new Properties();
//		 properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
//		 
//		 // Pass hibernate properties file
//		 configuration.setProperties(properties);
//		 
//		 // Since version 4.x, service registry is being used
//		 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//		 applySettings(configuration.getProperties()).build(); 
//		 
//		 MetadataSources metadataSources = new MetadataSources(serviceRegistry);
//		 metadataSources.addAnnotatedClass(Users.class);
//		 Metadata metadata = metadataSources.buildMetadata();
//
//		  // here we build the SessionFactory (Hibernate 5.4)
//		 SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//		 hibernateSession = sessionFactory.getCurrentSession();
//
//		 // Create session factory instance
////		 SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
//		
//               
//		 // Get current session
////		 hibernateSession = session.getCurrentSession();
//
//		 }
		
}