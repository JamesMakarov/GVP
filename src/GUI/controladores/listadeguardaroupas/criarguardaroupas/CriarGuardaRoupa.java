package GUI.controladores.listadeguardaroupas.criarguardaroupas;


import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static erros.ErroSucessoConfirmacao.erro;

public class CriarGuardaRoupa implements Initializable {

    @FXML
    private Button criarGR;

    @FXML
    private TextField nomeGR;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        criarGR.setOnAction(event -> {
            try {
                // o trim remove os espaços do inicio e do fim da string
                if (nomeGR.getText().trim().isEmpty()) {
                    erro("Campo obrigatorio");
                    return;
                }
                String nome = nomeGR.getText();
                ControladorAutenticacao.getInstancia().Cadastro(nome);
                NovaPagina.caminho("/GUI/fxmls/listadeguardaroupas/listaDeGuardaRoupas.fxml", criarGR);
            } catch (Exception e) {
                erro("Não foi possível criar um usuário");
            }
        });
    }
}
