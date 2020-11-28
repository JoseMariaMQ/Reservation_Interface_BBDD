package accessingDataBase;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import prueba.ReservaDAO;
import prueba.Reservas;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements EventHandler<ActionEvent> {

    //Elementos ventana de inserción de reservas
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldLastName1;
    @FXML
    private TextField fieldLastName2;
    @FXML
    private TextField fieldCompany;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldNumberCompanions;
    @FXML
    private TextArea fieldObservations;
    @FXML
    private Button btnReserve;
    @FXML
    private Button btnShow;
    @FXML
    private Label labelMessage1;
    @FXML
    private Label labelMessage2;

    private String name;
    private String lastName1;
    private String lastName2;
    private String company;
    private String email;
    private int numCompanions;
    private String observations;

    public void initialize() {
        btnReserve.setOnAction(this);
        btnShow.setOnAction(this::showReserations);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Acciones cuando se pulsa el botón RESERVAR
        if(actionEvent.getSource() == btnReserve) {
            //Comprobación de campos vacíos
            String[] fields = new String[]{
                    fieldName.getText(),
                    fieldLastName1.getText(),
                    fieldLastName2.getText(),
                    fieldCompany.getText(),
                    fieldEmail.getText(),
                    fieldNumberCompanions.getText(),
                    fieldObservations.getText()
            };
            //Recorremos el array de los campos y comprobamos si alguno está vacío,
            // y comprobamos el correo electrónico
            int cont = 0;
            for (String field : fields) {
                if (field.equals("")) {
                    //Mostramos texto si algún campo está vacío
                    labelMessage1.setText("Tienes que rellenar todos los campos.");
                    cont++;
                } else if(cont == 0) {
                    labelMessage1.setText(null);
                }
                if(!validateMail(fieldEmail.getText())) {
                    labelMessage2.setText("El correo electrónico no es válido.");
                } else {
                    labelMessage2.setText(null);
                }
            }
            //Comprobamos si el contador es 0 y si el correo es correcto,
            // insertamos los datos en la BBDD
            if (cont == 0 && validateMail(fieldEmail.getText())) {
                //Quitamos texto si ha rellenado campos
                labelMessage1.setText(null);

                //Inserción de datos en BBDD
                //Descargamos el texto de los campos y convertimos al tipo de datos de la entidad
                name = fieldName.getText();
                lastName1 = fieldLastName1.getText();
                lastName2 = fieldLastName2.getText();
                company = fieldCompany.getText();
                email = fieldEmail.getText();
                numCompanions = Integer.parseInt(fieldNumberCompanions.getText());
                observations = fieldObservations.getText();

                //Instanciamos reserva e introducimos datos de campos
                Reservas reserva = new Reservas(name, lastName1, lastName2, company, email, numCompanions, observations);
                ReservaDAO reservaDAO = new ReservaDAO();
                reservaDAO.insertReserve(reserva);

                //Mostramos mensaje de reserva con éxito
                labelMessage1.setText("Reserva realizada correctamente.");
            }
        }
    }

    public void showReserations (ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnShow) {
            ReservationsController rc = new ReservationsController();

            rc.nuevaVentana();
        }
    }

    public static boolean validateMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

}
