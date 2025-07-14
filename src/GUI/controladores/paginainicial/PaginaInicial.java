package GUI.controladores.paginainicial;

import GUI.classesestaticas.gerarcoisascomenums.StringEnum;
import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.ControladorAutenticacao;
import guardaroupa.autenticacao.SessaoGuardaRoupa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import modelos.Item;
import organizadores.OrganizadorDeItens;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PaginaInicial implements Initializable {

    @FXML
    private Label atualGR;

    @FXML
    private Label pessoa;

    @FXML
    private ListView<String> roupaSuperiorListView;

    @FXML
    private ListView<String> roupaInferiorListView;

    @FXML
    private ListView<String> roupaIntimaListView;

    @FXML
    private ListView<String> chapelariaListView;

    @FXML
    private ListView<String> acessoriosListView;

    @FXML
    private ListView<String> calcadoListView;

    @FXML
    private Button adicionarItem;

    @FXML
    private Button removerItem;

    @FXML
    private Button estatisticas;

    @FXML
    private Label listaItensLabel;

    @FXML
    private ListView<Item> listaItens;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            OrganizadorDeItens organizadorDeItens = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
            List<Item> todosItens = organizadorDeItens.listarTodosOsItens();

            List<String> roupaSuperiorLista = StringEnum.listaEnumStringRoupaSuperior();
            List<String> roupaInferiorLista = StringEnum.listaEnumStringRoupaInferior();
            List<String> roupaIntimaLista = StringEnum.listaEnumStringRoupaIntima();
            List<String> acessorioLista = StringEnum.listaEnumStringAcessorio();
            List<String> chapelariaLista = StringEnum.listaEnumStringChapelaria();
            List<String> calcadoLista = StringEnum.listaEnumStringCalcado();

            for (Item item : todosItens) {
                listaItens.getItems().add(item);
            }

            for (String string : roupaSuperiorLista) {
                roupaSuperiorListView.getItems().add(string);
            }

            for (String string : roupaInferiorLista) {
                roupaInferiorListView.getItems().add(string);
            }

            for (String string : roupaIntimaLista) {
                roupaIntimaListView.getItems().add(string);
            }

            for (String string : acessorioLista) {
                acessoriosListView.getItems().add(string);
            }

            for (String string : chapelariaLista) {
                chapelariaListView.getItems().add(string);
            }

            for (String string : calcadoLista) {
                calcadoListView.getItems().add(string);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        listaItens.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Item item = listaItens.getSelectionModel().getSelectedItem();
                if (item != null) {
                    try {
                        OrganizadorDeItens organizadorDeItens = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
                        organizadorDeItens.setItemAtual(item);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    NovaPagina.caminho("/GUI/fxmls/mostraritem/mostrarItem.fxml", listaItens);

                }
            }
            if (event.getClickCount() == 1) {
                removerItem.setOnAction(e -> {
                    Item item = listaItens.getSelectionModel().getSelectedItem();
                    if (item != null) {
                        try {
                            OrganizadorDeItens organizadorDeItens =  new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
                            organizadorDeItens.removerItem(item);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }
        });


        pessoa.setText("Olá, " + SessaoPessoa.getPessoa().getNome());
        atualGR.setText("Você está no guarda-roupa: " + SessaoGuardaRoupa.getGuardaRoupaAtual().getNome());

        adicionarItem.setOnAction(e -> {NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolherTipoPrimario.fxml", adicionarItem);});



    }
}
