package GUI.classesestaticas.novaspaginas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static erros.ErroSucessoConfirmacao.erro;

public class NovaPagina {
    public static void caminho(String caminho, Node node) {
        try {
            // Primeiro carregamos a página fxml com o FXMLLoader
            FXMLLoader loader = new FXMLLoader(NovaPagina.class.getResource(caminho));
            // Criamos uma raiz
            Parent root = loader.load();
            // O node é algum componente do JavaFx, aí, pegamos ele como base
            Stage stage = (Stage) node.getScene().getWindow();
            double largura = stage.getScene().getWidth();
            double altura = stage.getScene().getHeight();
            // Criamos a cena com a raiz que carregamos, e também com o tamanho das telas né
            Scene scene = new  Scene(root,  largura, altura);
            stage.setScene(scene);
            stage.setMinHeight(600);
            stage.setMinWidth(800);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            erro("Erro ao carregar a próxima página");
        }
    }
}
