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
import javafx.scene.layout.VBox;
import modelos.Item;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static GUI.classesestaticas.gerarcoisascomenums.StringEnum.*;
import static GUI.classesestaticas.instanciasnecessias.Instancia.*;
import static erros.ErroSucessoConfirmacao.erro;

public class PaginaInicial implements Initializable {

    //#region Declaração de nodes
    @FXML
    private Button logout;

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
    private Button looks;


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

            listaItens.getItems().addAll(getInstanceOrgItens().listarTodosOsItens());
            listaEmprestados.getItems().addAll(getInstanceOrgEmp().itensEmprestados());
            listaSujos.getItems().addAll(getInstanceOrgLav().listaItensSujos());
            roupaSuperiorListView.getItems().addAll(StringEnum.listaEnumStringRoupaSuperior());
            roupaInferiorListView.getItems().addAll(StringEnum.listaEnumStringRoupaInferior());
            roupaIntimaListView.getItems().addAll(StringEnum.listaEnumStringRoupaIntima());
            acessoriosListView.getItems().addAll(StringEnum.listaEnumStringAcessorio());
            chapelariaListView.getItems().addAll(StringEnum.listaEnumStringChapelaria());
            calcadoListView.getItems().addAll(StringEnum.listaEnumStringCalcado());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        listaItens.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Item item = listaItens.getSelectionModel().getSelectedItem();
                if (item != null) {
                    try {
                        getInstanceOrgItens().setItemAtual(item);
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
                            if (getInstanceOrgItens().removerItem(item)) {
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

        estatisticas.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/estatisticas/estatisticas.fxml", estatisticas);
        });

        roupaSuperiorListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                try {
                    String valor = roupaSuperiorListView.getSelectionModel().getSelectedItem();
                    if (valor != null) {
                        listaItens.getItems().clear();
                        retornarLista.setVisible(true);
                        List<Item> parcial = getInstanceOrgItens().listarItensPorTipo(stringParaEnumRoupaSuperior(valor));

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
                        List<Item> parcial = getInstanceOrgItens().listarItensPorTipo(stringParaEnumRoupaInferior(valor));

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
                        List<Item> parcial = getInstanceOrgItens().listarItensPorTipo(stringParaEnumRoupaIntima(valor));

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
                        List<Item> parcial = getInstanceOrgItens().listarItensPorTipo(stringParaEnumChapelaria(valor));

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
                        List<Item> parcial = getInstanceOrgItens().listarItensPorTipo(stringParaEnumAcessorio(valor));

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
                        List<Item> parcial = getInstanceOrgItens().listarItensPorTipo(stringParaEnumCalcado(valor));

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

        looks.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/looks/looks.fxml", looks);
        });

        logout.setOnMouseClicked( event -> {
            ControladorAutenticacao.getInstancia().Loggout();
            NovaPagina.caminho("/GUI/fxmls/listadeguardaroupas/listaDeGuardaRoupas.fxml", logout);
        });
    }

    private void Pesquisar() {
        try {
            String valor = pesquisa.getText();

            if (valor.isEmpty()) {
                erro("Digite alguma coisa para pesquisar");
                return;
            }
            listaItensLabel.setText("Resultados para pesquisa: " + valor);

            List<Item> resultados = getInstanceOrgItens().buscarItensPorNome(valor);
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
            List<Item> todosItens = getInstanceOrgItens().listarTodosOsItens();
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
                getInstanceOrgItens().setItemAtual(item);
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
