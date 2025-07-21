package GUI.controladores.criarpessoa;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pessoa.Pessoa;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.ResourceBundle;

import static erros.ErroSucessoConfirmacao.erro;

public class ControladorPessoa implements Initializable {
    // declaração de variáveis, lembrar que precisamos deixe os nomes das variáveis iguais aos ID's dados
    @FXML
    private TextField campoNome;

    @FXML
    private Button criarPessoa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criarPessoa.setOnAction(event -> {
            try {
                if (campoNome.getText().trim().isEmpty()) {
                    erro("Campo obrigatorio");
                    return;
                }

                String nome = campoNome.getText();

                Pessoa pessoa = new Pessoa(nome);
                SessaoPessoa.setPessoa(pessoa); // criei essa função porque deu erro ao dar get em pessoa diretamente

            } catch (Exception e) {
                erro("Não foi possível criar uma pessoa.");
            }

            NovaPagina.caminho("/GUI/fxmls/listadeguardaroupas/listaDeGuardaRoupas.fxml", criarPessoa);

        });
    }
}
