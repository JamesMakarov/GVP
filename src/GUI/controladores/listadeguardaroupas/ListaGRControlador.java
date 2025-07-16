package GUI.controladores.listadeguardaroupas;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static erros.ErroSucessoConfirmacao.erro;

public class ListaGRControlador implements Initializable {
    @FXML
    private ListView<GuardaRoupa> lista;

    @FXML
    private Button adicionar;

    @FXML
    private Button remover;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (GuardaRoupa g : ControladorAutenticacao.getInstancia().getGuardaRoupasCadastrados()) {lista.getItems().add(g);}

        lista.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                GuardaRoupa selecao = lista.getSelectionModel().getSelectedItem();
                if (selecao != null) {
                    try {
                        ControladorAutenticacao.getInstancia().Login(selecao.getNome());
                        NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", lista);
                    } catch (Exception e) {
                        erro("Não foi possível entrar neste guarda-roupa");
                        throw new RuntimeException();
                    }
                }
            }
        });

        adicionar.setOnMouseClicked(event -> {NovaPagina.caminho("/GUI/fxmls/listadeguardaroupas/criarguardaroupa/criarGuardaRoupa.fxml", adicionar);});

        remover.setOnMouseClicked(event -> {
            try {
                if (lista.getSelectionModel().getSelectedItem() != null) {
                    GuardaRoupa selecao = lista.getSelectionModel().getSelectedItem();
                    ControladorAutenticacao.getInstancia().removerGuardaRoupa(selecao);
                    lista.getItems().remove(selecao);
                } else {
                    erro("Selecione um guarda-roupa para remover");
                }
            } catch (Exception e) {
                erro("Erro inesperado");
            }
        });
    }
}
