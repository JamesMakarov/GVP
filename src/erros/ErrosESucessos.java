package erros;

import javafx.scene.control.Alert;

public class ErrosESucessos {
    private ErrosESucessos() {}
    public static void Sucesso(String HeaderText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(HeaderText);
        alert.showAndWait();
    }

    public static void erro(String HeaderText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(HeaderText);
        alert.showAndWait();
    }
}
