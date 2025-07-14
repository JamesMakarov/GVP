package GUI.controladores.criaritem;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
        acessorio.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/escolhaEnumAcessorios.fxml", acessorio);});
        roupaIntima.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/escolhaEmumRoupaIntima.fxml", roupaIntima);});
        roupaComum.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupaComumClasseSecundaria.fxml", roupaComum);});
    }
}
