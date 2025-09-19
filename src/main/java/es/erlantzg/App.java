package es.erlantzg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaFX App
 */
public class App extends Application {

    // Logger para esta clase
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    public void start(Stage stage) {
        try{
            logger.debug("Intentando cargar el FXML: /fxml/flowpane12Sep.fxml");
            FXMLLoader loaded = new FXMLLoader(getClass().getResource("/fxml/formularioGridPane19Sep.fxml"));
            Scene scene = new Scene(loaded.load());
            logger.info("FXML cargado correctamente");

            // Comprobar que el archivo de css existe y sino mostrar una alerta
            logger.debug("Buscando el archivo CSS");
            var archivoCSS = getClass().getResource("/css/estilo.css");
            if(archivoCSS != null){
                logger.info("CSS cargado correctamente");
                scene.getStylesheets().add(archivoCSS.toExternalForm());
            } else{
                logger.error("No se ha podido cargar el CSS");
                new Alert(Alert.AlertType.INFORMATION, "No se ha podido cargar el CSS").showAndWait();
            }

            logger.info("Cargar la aplicación");
            stage.setTitle("FlowPane Alignment");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            logger.error("Error al intentar cargar la aplicación", e);
            new Alert(Alert.AlertType.ERROR, "Error al intentar cargar la aplicación").showAndWait();
        }
    }

    @Override
    public void stop(){
        logger.info("Aplicación finalizada correctamente");
    }

    public static void main(String[] args) {
        logger.info("Iniciando aplicacion JavaFX...");
        launch();
    }

}