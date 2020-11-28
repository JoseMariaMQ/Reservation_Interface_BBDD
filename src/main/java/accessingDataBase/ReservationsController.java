package accessingDataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import prueba.ReservaDAO;
import prueba.Reservas;

import java.io.IOException;
import java.util.ArrayList;

public class ReservationsController {

    //Elementos ventana lectura de BBDD
    @FXML
    private TableView<Reservas> table = new TableView<>();
    @FXML
    private TableColumn<Reservas, String> columnName = new TableColumn<>();
    @FXML
    private TableColumn<Reservas, String> columnLastName1 = new TableColumn<>();
    @FXML
    private TableColumn<Reservas, String> columnLastName2 = new TableColumn<>();
    @FXML
    private TableColumn<Reservas, String> columnCompany = new TableColumn<>();
    @FXML
    private TableColumn<Reservas, String> columnEmail = new TableColumn<>();
    @FXML
    private TableColumn<Reservas, Integer> columnNumAcomp = new TableColumn<>();
    @FXML
    private TableColumn<Reservas, String> columnObservations = new TableColumn<>();

    public void initialize() {

    }

    public void nuevaVentana() {
        ReservaDAO rDAO = new ReservaDAO();

        ArrayList reservationsList = new ArrayList();

        Reservas r;


        for(int i=0; i<rDAO.showReserve().size(); i++) {
            r = new Reservas(rDAO.showReserve().get(i).getNombre(), rDAO.showReserve().get(i).getApellido1(), rDAO.showReserve().get(i).getApellido2(), rDAO.showReserve().get(i).getEmpresa(), rDAO.showReserve().get(i).getEmail(), rDAO.showReserve().get(i).getNumAcomp(), rDAO.showReserve().get(i).getObservaciones());
            reservationsList.add(r);
        }

        System.out.println(reservationsList.get(1));

        ObservableList listReservations = FXCollections.observableArrayList(reservationsList);
        columnName.setCellValueFactory(new PropertyValueFactory<Reservas, String>("nombre"));
        columnLastName1.setCellValueFactory(new PropertyValueFactory<Reservas, String>("apellido1"));
        columnLastName2.setCellValueFactory(new PropertyValueFactory<Reservas, String>("apellido2"));
        columnCompany.setCellValueFactory(new PropertyValueFactory<Reservas, String>("empresa"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Reservas, String>("email"));
        columnNumAcomp.setCellValueFactory(new PropertyValueFactory<Reservas, Integer>("numAcomp"));
        columnObservations.setCellValueFactory(new PropertyValueFactory<Reservas, String>("observaciones"));

        table.setItems(listReservations);


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservations.fxml"));
            Parent root1 = fxmlLoader.load();
            Scene scene = new Scene(root1, 900, 450);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
