package GUI.controladores.estatisticas;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modelos.Item;
import modelos.Look;
import pessoa.Pessoa;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.ResourceBundle;

import static erros.ErroSucessoConfirmacao.erro;
import static estatisticas.Estatisticas.*;

public class Estatisticas implements Initializable {

    @FXML
    private Label pessoa;

    @FXML
    private Label atualGR;

    @FXML
    private Label totalItensCadastrados;

    @FXML
    private Label itensLavados;

    @FXML
    private Label totalLooksCriados;

    @FXML
    private Label totalItensEmprestados;

    @FXML
    private Label itemMaisEmprestado;

    @FXML
    private Label lookMaisUsado;

    @FXML
    private ListView<Item> itensMaisUsados;

    @FXML
    private ListView<Look> looksMaisUsados;

    @FXML
    private Button voltar;

    @FXML
    private VBox vBoxEstat;

    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarListas();
        atualizarLabels();
        vBoxEstat.minWidthProperty().bind(scrollPane.widthProperty().subtract(16));

        voltar.setOnMouseClicked( event -> {
            NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", voltar);
        });

    }

    public void atualizarListas() {
        try {
            itensMaisUsados.getItems().clear();
            itensMaisUsados.getItems().addAll(itensMaisUsados());
            looksMaisUsados.getItems().clear();
            looksMaisUsados.getItems().addAll(looksMaisUsados());
        } catch (Exception e) {
            erro("Comportamento inesperado ao atualizar listas");
        }
    }

    public void atualizarLabels() {

        if (SessaoPessoa.getPessoa().getNome() != null) pessoa.setText(SessaoPessoa.getPessoa().getNome());

        if (ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().getNome() != null) atualGR.setText(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().getNome());

        totalItensCadastrados.setText("Foram cadastrados " + totalDeItensCadastrados() + " itens");

        try {
            if (!(percentualDeItensLavados() < 0)) {
                itensLavados.setText("Foram lavados " + percentualDeItensLavados() +  "% dos itens");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        totalLooksCriados.setText("Foram criados " + totalDeLooksCriados() + " looks");

        totalItensEmprestados.setText("Foram emprestados " + totalDeItensEmprestados() + " itens");

        if (itemMaisEmprestado() != null && itemMaisEmprestado().getNome() != null) itemMaisEmprestado.setText("O item mais emprestado foi: " + itemMaisEmprestado().getNome());

        if (lookMaisUsado() != null && lookMaisUsado().getNome() != null) lookMaisUsado.setText("O look mais usado foi:  " + lookMaisUsado().getNome());


    }
}
