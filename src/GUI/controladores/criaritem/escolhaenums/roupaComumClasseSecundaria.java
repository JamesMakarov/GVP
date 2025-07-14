package GUI.controladores.criaritem.escolhaenums;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
        calcado.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/calcado.fxml",  calcado);});
        chapelaria.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/chapelaria.fxml",  chapelaria);});
        roupaInferior.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/roupaInferior.fxml", roupaInferior);});
        roupaSuperior.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolhaenums/roupacomum/roupaSuperior.fxml",roupaSuperior);});
    }
}
