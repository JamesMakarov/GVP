package GUI.controladores.looks;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.autenticacao.SessaoGuardaRoupa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import modelos.Look;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static GUI.classesestaticas.instanciasnecessias.Instancia.*;
import static erros.ErroSucessoConfirmacao.*;
import static pessoa.SessaoPessoa.getPessoa;

public class Looks implements Initializable {

    @FXML
    private Button addLook;

    @FXML
    private Button voltar;

    @FXML
    private Button fecharPesquisa;

    @FXML
    private Button pesquisar;

    @FXML
    private ListView<Look> listaLooks;

    @FXML
    private Button removerLook;

    @FXML
    private TextField digitarPesquisa;

    @FXML
    private Label pessoa;

    @FXML
    private Label atualGR;

    @FXML
    private Label listaLooksLabel;

    @FXML
    private ToolBar toolBar;

    @FXML
    private HBox hBoxToolBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hBoxToolBar.minWidthProperty().bind(toolBar.widthProperty());
        fecharPesquisa.setVisible(false);
        fecharPesquisa.setManaged(false);
        pessoa.setText("Olá, " + getPessoa().getNome());
        atualGR.setText(", você está no guarda-roupa: " + SessaoGuardaRoupa.getGuardaRoupaAtual().getNome());

        IniciarListaLooks();

        digitarPesquisa.setOnAction(event -> {
            Pesquisar();
        });

        pesquisar.setOnMouseClicked(event -> {
            Pesquisar();
        });

        fecharPesquisa.setOnMouseClicked(event -> {
            IniciarListaLooks();
        });

        listaLooks.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                removerLook.setOnMouseClicked(event1 -> {
                    try {
                        getInstanceOrgLoo().removerLook(listaLooks.getSelectionModel().getSelectedItem());
                        listaLooks.getItems().remove(listaLooks.getSelectionModel().getSelectedItem());
                    } catch (Exception e) {
                        erro("Comportamento inesperado ao remover look");
                    }
                });
            }

            if (event.getClickCount() == 2) {
                try {
                    getInstanceOrgLoo().setLookAtual(listaLooks.getSelectionModel().getSelectedItem());
                    NovaPagina.caminho("/GUI/fxmls/looks/mostrarlook/mostrarLook.fxml", listaLooks);
                } catch (Exception e) {
                    erro("Comportamento ao abrir Look");
                }

            }
        });

        voltar.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", voltar);
        });
        // mudei isso de lugar, se der erro, já sabe
        addLook.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/looks/criarlook/criarLook.fxml", addLook);
        });

    }

    public void Pesquisar() {
        String string = digitarPesquisa.getText();
        List<Look> listaParcial;
        fecharPesquisa.setManaged(true);
        fecharPesquisa.setVisible(true);
        try {
            listaParcial = getInstanceOrgLoo().buscarLookPorNome(string);
            if (listaParcial != null) {
                listaLooks.getItems().clear();
                listaLooks.getItems().addAll(listaParcial);
                listaLooksLabel.setText("Retorno da pesquisa: " + string);
            }
        } catch (Exception e) {
            erro("Erro ao listar Looks após pesquisa");
        }
    }

    public void IniciarListaLooks() {
        List<Look> lista;
        listaLooksLabel.setText("Lista de Looks");
        listaLooks.getItems().clear();
        fecharPesquisa.setManaged(false);
        fecharPesquisa.setVisible(true);
        try {
            if (getInstanceOrgLoo().listarLooks() != null) {
                lista = getInstanceOrgLoo().listarLooks();
                listaLooks.getItems().addAll(lista);
            }
        } catch (Exception e) {
            erro("Erro ao listar Looks");
        }
    }

}
