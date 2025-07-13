package GUI.controladores.criarpessoa;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pessoa.Pessoa;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.ResourceBundle;

import static erros.ErrosESucessos.erro;

public class ControladorPessoa implements Initializable {
    // declaração de variáveis, lembrar que precisamos deixe os nomes das variáveis iguais aos ID's dados
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoAltura;

    @FXML
    private TextField campoIdade;

    @FXML
    private Button criarPessoa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criarPessoa.setOnAction(event -> {
            try {
                if (campoNome.getText().trim().isEmpty() ||
                    campoIdade.getText().trim().isEmpty() ||
                    campoAltura.getText().trim().isEmpty()) {
                    erro("Campo obrigatorio");
                    return;
                }

                String nome = campoNome.getText();
                String altura = campoAltura.getText();
                String idade = campoIdade.getText();

                Pessoa pessoa = new Pessoa(nome, altura, idade);
                SessaoPessoa.setPessoa(pessoa); // criei essa função porque deu erro ao dar get em pessoa diretamente

            } catch (Exception e) {
                erro("Não foi possível criar uma pessoa.");
            }

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/listadeguardaroupas/listaDeGuardaRoupas.fxml"));

                Parent proximaPagina = loader.load();
                Stage stage = (Stage) criarPessoa.getScene().getWindow();
                stage.setScene(new Scene(proximaPagina));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                erro("Comportamento Inesperado");
            }

        });
    }
}
