package erros;

import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import modelos.Item;
import organizadores.OrganizadorDeItens;

import java.util.Optional;

public class ErroSucessoConfirmacao {
    private ErroSucessoConfirmacao() {}
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

    public static Optional<String> textInputDialog(Item item, String title, String headerText, String contentText) {
        try {
            OrganizadorDeItens organizadorDeItens = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle(title);
            dialog.setHeaderText(headerText);
            dialog.setContentText(contentText);
            Optional<String> ocasiao = dialog.showAndWait();
            return ocasiao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
