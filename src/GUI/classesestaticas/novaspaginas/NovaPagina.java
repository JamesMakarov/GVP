package GUI.classesestaticas.novaspaginas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NovaPagina {
    public static void caminho(String caminho, Node node) {
        try {
            FXMLLoader loader = new FXMLLoader(NovaPagina.class.getResource(caminho));
            Parent proximaPagina = loader.load();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(proximaPagina));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
