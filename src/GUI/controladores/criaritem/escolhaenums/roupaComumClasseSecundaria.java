package GUI.controladores.criaritem.escolhaenums;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class roupaComumClasseSecundaria implements Initializable {

    @FXML
    private Button calcado;

    @FXML
    private Button chapelaria;

    @FXML
    private Button roupaInferior;

    @FXML
    private Button roupaSuperior;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calcado.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/calcado.fxml"));
                Parent proximaPagina = loader.load();
                Stage stage = (Stage)calcado.getScene().getWindow();
                stage.setScene(new Scene(proximaPagina));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        chapelaria.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/chapelaria.fxml"));
                Parent proximaPagina = loader.load();
                Stage stage = (Stage)chapelaria.getScene().getWindow();
                stage.setScene(new Scene(proximaPagina));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        roupaInferior.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/roupaInferior.fxml"));
                Parent proximaPagina = loader.load();
                Stage stage = (Stage)roupaInferior.getScene().getWindow();
                stage.setScene(new Scene(proximaPagina));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        roupaSuperior.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/roupaSuperior.fxml"));
                Parent proximaPagina = loader.load();
                Stage stage = (Stage)roupaSuperior.getScene().getWindow();
                stage.setScene(new Scene(proximaPagina));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
