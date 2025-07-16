package GUI.controladores.paginainicial;

import GUI.classesestaticas.gerarcoisascomenums.StringEnum;
import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.autenticacao.ControladorAutenticacao;
import guardaroupa.autenticacao.SessaoGuardaRoupa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import modelos.Item;
import organizadores.OrganizadorDeEmprestimos;
import organizadores.OrganizadorDeItens;
import organizadores.OrganizadorDeLavagens;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static GUI.classesestaticas.gerarcoisascomenums.StringEnum.*;
import static erros.ErroSucessoConfirmacao.erro;

public class PaginaInicial implements Initializable {

    //#region Declaração de nodes
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

    @FXML
    private ListView<Item> listaEmprestados;

    @FXML
    private ListView<Item> listaSujos;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button clicarPesquisa;

    @FXML
    private Button cancelarPesquisa;

    @FXML
    private Button retornarLista;

    @FXML
    private Button abrirListaTipo;

    @FXML
    private Button fecharListaTipo;

    @FXML
    private VBox containerListaTipo;

    @FXML



    //#endregion

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //#region Configuração de itens estáticos e variáveis que devem iniciar com valores

        listaItensLabel.setText("Lista de Itens");
        pessoa.setText("Olá, " + SessaoPessoa.getPessoa().getNome());
        atualGR.setText(", você está no guarda-roupa: " + SessaoGuardaRoupa.getGuardaRoupaAtual().getNome());
        cancelarPesquisa.setVisible(false);
        retornarLista.setVisible(false);
        containerListaTipo.setVisible(false);
        containerListaTipo.setManaged(false);

        //#endregion

        try {
            List<Item> todosItens = InstanciaOrgItem().listarTodosOsItens();
            List<Item> listaEmprestadosParcial = InstanciaOrgEmp().itensEmprestados();
            List<Item> listaSujosParcial = InstanciaOrgLav().listaItensSujos();
            List<String> roupaSuperiorLista = StringEnum.listaEnumStringRoupaSuperior();
            List<String> roupaInferiorLista = StringEnum.listaEnumStringRoupaInferior();
            List<String> roupaIntimaLista = StringEnum.listaEnumStringRoupaIntima();
            List<String> acessorioLista = StringEnum.listaEnumStringAcessorio();
            List<String> chapelariaLista = StringEnum.listaEnumStringChapelaria();
            List<String> calcadoLista = StringEnum.listaEnumStringCalcado();

            for (Item item : todosItens) {
                listaItens.getItems().add(item);
            }

            for (Item item : listaEmprestadosParcial) {
                listaEmprestados.getItems().add(item);
            }

            for (Item item : listaSujosParcial) {
                listaSujos.getItems().add(item);
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
                        InstanciaOrgItem().setItemAtual(item);
                    } catch (Exception e) {
                        erro("Comportamento inesperado");
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
                            if (InstanciaOrgItem().removerItem(item)) {
                                listaItens.getItems().remove(item);
                            }
                        } catch (Exception ex) {
                            erro("Comportamento inesperado");
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }
        });

        listaEmprestados.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    LEmprestadosLSujos(listaEmprestados);
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }

            }
        });

        listaSujos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    LEmprestadosLSujos(listaSujos);
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        adicionarItem.setOnAction(e -> {
            try {
                NovaPagina.caminho("/GUI/fxmls/caminhoparacriaritem/escolherTipoPrimario.fxml", adicionarItem);
            } catch (Exception ex) {
                erro("Comportamento inesperado");
                throw new RuntimeException(ex);
            }
        });

        // O método já testa dentro dele com try então não é necessário para os proximos 4
        clicarPesquisa.setOnMouseClicked(event -> Pesquisar());

        pesquisa.setOnAction(event -> {
            Pesquisar();
        });

        cancelarPesquisa.setOnMouseClicked(event -> CancelarPesquisa());

        retornarLista.setOnMouseClicked(event -> CancelarPesquisa());

        roupaSuperiorListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = roupaSuperiorListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = InstanciaOrgItem().listarItensPorTipo(stringParaEnumRoupaSuperior(valor));

                        for (Item item : parcial) {
                            listaItens.getItems().add(item);
                        }

                        listaItensLabel.setText("Itens do tipo: " + stringParaEnumRoupaSuperior(valor));
                    }
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        roupaInferiorListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = roupaInferiorListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = InstanciaOrgItem().listarItensPorTipo(stringParaEnumRoupaInferior(valor));

                        for (Item item : parcial) {
                            listaItens.getItems().add(item);
                        }

                        listaItensLabel.setText("Itens do tipo: " + stringParaEnumRoupaInferior(valor));
                    }
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        roupaIntimaListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = roupaIntimaListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = InstanciaOrgItem().listarItensPorTipo(stringParaEnumRoupaIntima(valor));

                        for (Item item : parcial) {
                            listaItens.getItems().add(item);
                        }

                        listaItensLabel.setText("Itens do tipo: " + stringParaEnumRoupaIntima(valor));
                    }
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        chapelariaListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = chapelariaListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = InstanciaOrgItem().listarItensPorTipo(stringParaEnumChapelaria(valor));

                        for (Item item : parcial) {
                            listaItens.getItems().add(item);
                        }

                        listaItensLabel.setText("Itens do tipo: " + stringParaEnumChapelaria(valor));
                    }
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        acessoriosListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = acessoriosListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = InstanciaOrgItem().listarItensPorTipo(stringParaEnumAcessorio(valor));

                        for (Item item : parcial) {
                            listaItens.getItems().add(item);
                        }

                        listaItensLabel.setText("Itens do tipo: " + stringParaEnumAcessorio(valor));
                    }
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        calcadoListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = calcadoListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = InstanciaOrgItem().listarItensPorTipo(stringParaEnumCalcado(valor));

                        for (Item item : parcial) {
                            listaItens.getItems().add(item);
                        }

                        listaItensLabel.setText("Itens do tipo: " + stringParaEnumCalcado(valor));
                    }
                } catch (Exception e) {
                    erro("Comportamento inesperado");
                    throw new RuntimeException(e);
                }
            }
        });

        abrirListaTipo.setOnMouseClicked(event -> {
            abrirListaTipo.setManaged(false);
            abrirListaTipo.setVisible(false);
            containerListaTipo.setVisible(true);
            containerListaTipo.setManaged(true);
        });

        fecharListaTipo.setOnMouseClicked(event -> {
            abrirListaTipo.setManaged(true);
            abrirListaTipo.setVisible(true);
            containerListaTipo.setVisible(false);
            containerListaTipo.setManaged(false);
        });
    }

    //#region Funções repetidas que o IntelliJ vivia reclamando
    private OrganizadorDeItens InstanciaOrgItem() {
        return new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
    }

    private OrganizadorDeEmprestimos InstanciaOrgEmp() {
        return new OrganizadorDeEmprestimos(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
    }

    private OrganizadorDeLavagens InstanciaOrgLav() {
        return new OrganizadorDeLavagens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
    }

    private void Pesquisar() {
        try {
            String valor = pesquisa.getText();
            listaItensLabel.setText("Resultados para pesquisa: " + valor);
            if (valor.isEmpty()) {
                erro("Digite alguma coisa para pesquisar");
                return;
            }
            List<Item> resultados = InstanciaOrgItem().buscarItensPorNome(valor);
            if (resultados == null || resultados.isEmpty()) {
                erro("Não encontramos nenhum item com o nome " + valor);
            } else {
                clicarPesquisa.setVisible(false);
                clicarPesquisa.setManaged(false);
                cancelarPesquisa.setVisible(true);
                retornarLista.setVisible(true);
                listaItens.getItems().clear();
                listaItens.getItems().addAll(resultados);
            }
        } catch (Exception e) {
            erro("Comportamento inesperado");
            throw new RuntimeException(e);
        }

    }

    private void CancelarPesquisa() {
        try {
            listaItens.getItems().clear();
            List<Item> todosItens = InstanciaOrgItem().listarTodosOsItens();
            for (Item i :  todosItens) {
                listaItens.getItems().add(i);
            }
            cancelarPesquisa.setVisible(false);
            retornarLista.setVisible(false);
            clicarPesquisa.setVisible(true);
            clicarPesquisa.setManaged(true);
            listaItensLabel.setText("Lista de Itens");
        } catch (Exception e) {
            erro("Comportamento inesperado");
            throw new RuntimeException(e);
        }

    }

    private void LEmprestadosLSujos(ListView<Item> listView) {
        Item item = listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            try {
                InstanciaOrgItem().setItemAtual(item);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                NovaPagina.caminho("/GUI/fxmls/mostraritem/mostrarItem.fxml", listaSujos);
            } catch (Exception e) {
                erro("Comportamento inesperado");
                throw new RuntimeException(e);
            }
        }
    }

    //#endregion
}
