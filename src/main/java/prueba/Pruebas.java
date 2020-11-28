package prueba;

import java.util.ArrayList;

public class Pruebas {
    public static void main(String[] args) {

        ReservaDAO rDAO = new ReservaDAO();
        Object[][] tableReservations = new Object[7][rDAO.showReserve().size()];
        ArrayList reservationsList = new ArrayList();
        ArrayList reservationsList2 = new ArrayList();
        Reservas r;
//        System.out.println(rDAO.showReserve().get(1).getNombre());
        /*for(int i=0; i<tableReservations.length; i++) {
            for(int j=0; j<tableReservations[i].length; j++) {
                tableReservations[i][j] = rDAO.showReserve().get(j);
                System.out.println(rDAO.showReserve().get(j));
            }
        }*/

        for(int i=0; i<rDAO.showReserve().size(); i++) {
            r = new Reservas(rDAO.showReserve().get(i).getNombre(), rDAO.showReserve().get(i).getApellido1(), rDAO.showReserve().get(i).getApellido2(), rDAO.showReserve().get(i).getEmpresa(), rDAO.showReserve().get(i).getEmail(), rDAO.showReserve().get(i).getNumAcomp(), rDAO.showReserve().get(i).getObservaciones());
            reservationsList.add(r);
            System.out.println(rDAO.showReserve().get(i).getNumAcomp());
        }
        System.out.println(reservationsList);

//        System.out.println(reservationsList);

        /*for(int i=0; i<tableReservations.length; i++) {
            for (int j=0; j<tableReservations[i].length; j++) {
                reservationsList.add(tableReservations[i][j]);
//                System.out.println(tableReservations[i][j]);
            }
//            System.out.println(reservationsList.get(8));
            r = new Reservas((String) reservationsList.get(1), (String) reservationsList.get(2), (String) reservationsList.get(3), (String) reservationsList.get(4), (String) reservationsList.get(5), Integer.parseInt((String) reservationsList.get(6)), (String) reservationsList.get(7));
            reservationsList2.add(r);
            reservationsList.clear();
        }*/


    }
}