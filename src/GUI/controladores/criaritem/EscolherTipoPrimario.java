package GUI.controladores.criaritem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EscolherTipoPrimario implements Initializable{
    @FXML
    private Button acessorio;

    @FXML
    private Button roupaIntima;

    @FXML
    private Button roupaComum;

    @Override
    public void initialize(URL url,  ResourceBundle resourceBundle) {
        try {
            acessorio.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/escolhaEnumAcessorios.fxml"));
                    Parent proximaPagina = loader.load();
                    Stage stage = (Stage)acessorio.getScene().getWindow();
                    stage.setScene(new Scene(proximaPagina));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            roupaIntima.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/escolhaEmumRoupaIntima.fxml"));
                    Parent proximaPagina = loader.load();
                    Stage stage = (Stage)roupaIntima.getScene().getWindow();
                    stage.setScene(new Scene(proximaPagina));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            roupaComum.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupaComumClasseSecundaria.fxml"));
                    Parent proximaPagina = loader.load();
                    Stage stage = (Stage)roupaComum.getScene().getWindow();
                    stage.setScene(new Scene(proximaPagina));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
