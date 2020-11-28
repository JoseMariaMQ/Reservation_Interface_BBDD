package prueba;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManagement {

    private static final SessionFactory myFactory;
    static {
        try {
            myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reservas.class).buildSessionFactory();
        } catch(Throwable th){
            System.err.println("Error en la creación inicial de SessionFactory"+th);
            throw new ExceptionInInitializerError(th);
        }
    }
    public static SessionFactory getMyFactory(){
        return myFactory;
    }
}