package GUI.controladores.listadeguardaroupas.criarguardaroupas;


import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static erros.ErrosESucessos.erro;

public class CriarGuardaRoupa implements Initializable {

    @FXML
    private Button criarGR;

    @FXML
    private TextField nomeGR;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        criarGR.setOnAction(event -> {
            try {
                if (nomeGR.getText().trim().isEmpty()) {
                    erro("Campo obrigatorio");
                    return;
                }

                String nome = nomeGR.getText();
                ControladorAutenticacao.getInstancia().Cadastro(nome);

                try {
                    FXMLLoader loader  = new FXMLLoader(getClass().getResource("/GUI/fxmls/listadeguardaroupas/listaDeGuardaRoupas.fxml"));
                    Parent proximaPagina = loader.load();
                    Stage stage = (Stage) criarGR.getScene().getWindow();
                    stage.setScene(new Scene(proximaPagina));
                    stage.show();
                } catch (Exception e) {
                    erro("Erro ao retornar para a pagina de lista de guarda-roupas");
                }

            } catch (Exception e) {
                erro("Não foi possível criar um usuário");
            }
        });
    }
}
