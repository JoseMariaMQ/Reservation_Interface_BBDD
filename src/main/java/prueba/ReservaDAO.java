package prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ReservaDAO {

    public void insertReserve(Reservas reserva) {
        try {
            SessionFactory myFactory = SessionManagement.getMyFactory();
            Session mySession = myFactory.openSession();
            //Escritura de registro
            mySession.beginTransaction();
            mySession.save(reserva);
            mySession.getTransaction().commit();
            System.out.println("Reserva insertada correctamente.");

            //Lectura del registro
            mySession.beginTransaction();
            System.out.println("Lectura del registro con Id: " + reserva.getId());
            Reservas reservaInsertada = mySession.get(Reservas.class, reserva.getId());
            System.out.println("Registro: " + reservaInsertada);
            mySession.getTransaction().commit();
            System.out.println("Terminado.");

            mySession.close();
            myFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Reservas> showReserve() {
        try {
            SessionFactory myFactory = SessionManagement.getMyFactory();
            Session mySession = myFactory.openSession();

            //Obtenemos todos los registros de la tabla
            mySession.beginTransaction();
            Query query = mySession.createQuery("FROM Reservas");
            ArrayList<Reservas> reservas = (ArrayList<Reservas>) query.list();
            mySession.getTransaction().commit();

            /*System.out.println(reservas.size());
            for(Reservas reserva : reservas) {
                System.out.println(reserva.getNombre());
            }*/
            return reservas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}