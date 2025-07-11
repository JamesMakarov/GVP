package GUI.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListaGRControlador implements Initializable {
    @FXML
    private ListView<String> listaDeGR;

    @FXML
    private Button cargar;

    List<String> lista = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}
