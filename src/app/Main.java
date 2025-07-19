package app;

import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static persistencia.Serializer.lerCADat;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            ControladorAutenticacao controladorAutenticacao = lerCADat();
            if (controladorAutenticacao != null) {
                ControladorAutenticacao.getInstancia().getGuardaRoupasCadastrados().addAll(controladorAutenticacao.getGuardaRoupasCadastrados());
            }
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/fxmls/criarpessoa/pessoa.fxml"));
            stage.setTitle("GVP");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
