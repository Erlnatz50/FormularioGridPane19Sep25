package es.erlantzg;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controlador para la scena {@code formularioGridPane19Sep.fxml}
 *
 * Esta clase maneja la interaccion del ususario con la interfaz:
 * - Recoge los valores de los campos Nombre y Descripcion.
 * - Valida los datos introducidos.
 * - Actualiza el label de estado acumulando las entradas.
 * - Muestra alertas si faltan datos.
 * Todos los nodos de la itnerfaz estan vinculados mediante {@link FXML}
 *
 * @author Erlantz Garcia
 * @version 1.0
 */
public class GridPaneController {

    /**
     * Label que muestra la informacion introducida en nombres y descripciones.
     */
    @FXML
    private Label lblStatus;

    /**
     * Area de texto donde el usuario introduce la descripcion.
     */
    @FXML
    private TextArea txtDescripcion;

    /**
     * Campo de texto donde el usuario introduce el nombre.
     */
    @FXML
    private TextField txtNombre;

    /**
     * Manejar el evento del boton "Cancel".
     * Limpia los campos de texto Nombre y Descripcion.
     */
    @FXML
    void btnCancel() {
        // Limpiar los campos
        txtNombre.clear();
        txtDescripcion.clear();
    }

    /**
     * Manejar el evento del boton "OK".
     * Valida que los campos no esten vacios. Si faltan datos, muestra una {@link Alert}.
     * Si los datos son correctos, los concatena al {@link #lblStatus} como "Nombre - Descripcion"
     * y limpia los campos para nuevas entradas.
     */
    @FXML
    void btnOk() {
        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        if(nombre.isEmpty() || descripcion.isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos incompletos");
            alerta.setHeaderText("Falta información");
            alerta.setContentText("Debes rellenar el nombre y la descripción.");
            alerta.showAndWait();
            return;
        }

        String actual = lblStatus.getText();
        String nuevo = nombre + " - " + descripcion;

        if(actual.equals("Status: Ready")){
            lblStatus.setText(nuevo);
        } else{
            lblStatus.setText(actual + "\n" + nuevo);
        }

        txtNombre.clear();
        txtDescripcion.clear();
    }

}
