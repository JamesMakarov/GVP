package GUI.controladores.mostraritem;

import GUI.classesestaticas.novaspaginas.NovaPagina;
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
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.lavaveis.ILavavel;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static GUI.classesestaticas.instanciasnecessias.Instancia.*;
import static erros.ErroSucessoConfirmacao.Sucesso;
import static erros.ErroSucessoConfirmacao.erro;
import static erros.ErroSucessoConfirmacao.textInputDialog;

public class MostrarItem implements Initializable {

    @FXML
    private TextField nome;

    @FXML
    private TextField cor;

    @FXML
    private TextField tamanho;

    @FXML
    private TextField marca;

    @FXML
    private TextField estado;

    @FXML
    private Button confirmar;

    @FXML
    private Button voltar;

    @FXML
    private Label tipo;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label corLabel;

    @FXML
    private Label tamanhoLabel;

    @FXML
    private Label marcaLabel;

    @FXML
    private Label estadoLabel;

    @FXML
    private Button emprestar;

    @FXML
    private Button devolver;

    @FXML
    private Button lavar;

    @FXML
    private Button usar;

    @FXML
    private Label seEmprestado;

    @FXML
    private Label estaLavado;

    @FXML
    private Label dataUso;

    @FXML
    private Label diasDesdeLavagem;

    @FXML
    private Label diasDesdeEmprestimo;

    @FXML
    private Label dataAquisicao;

    @FXML
    private ListView<String> listaOcasioesUso;

    @FXML
    private VBox vBoxDireito;

    @FXML
    private VBox vBoxEsquerdo;

    @FXML
    private Label diasDesdeUltimoUso;

    @FXML
    private VBox vBoxCentroDireito;

    @FXML
    private VBox vBoxCentroEsquerdo;

    @FXML
    private HBox hBoxCenter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Item item = getInstanceOrgItens().getItemAtual();

        HBox.setHgrow(vBoxDireito, Priority.ALWAYS);
        HBox.setHgrow(vBoxEsquerdo, Priority.ALWAYS);

        vBoxDireito.setMaxWidth(Double.MAX_VALUE);
        vBoxEsquerdo.setMaxWidth(Double.MAX_VALUE);

        vBoxCentroDireito.minWidthProperty().bind((hBoxCenter.widthProperty().divide(2)).subtract(50));
        vBoxCentroEsquerdo.minWidthProperty().bind((hBoxCenter.widthProperty().divide(2)).subtract(50));

        /* Atualizar lista de ocasioes de uso */
        listaOcasioesUso.getItems().addAll((item.getListaOcasioes() != null) ? item.getListaOcasioes() : new ArrayList<>());

        /* Visibilidade de botões */
        deixarTodosInvisiveis();
        if (item instanceof IEmprestavel) {

            seEmprestado.setVisible(true);
            seEmprestado.setManaged(true);

            diasDesdeEmprestimo.setVisible(true);
            diasDesdeEmprestimo.setManaged(true);

            emprestar.setVisible(true);
            emprestar.setManaged(true);

            devolver.setVisible(true);
            devolver.setManaged(true);

        }

        if (item instanceof ILavavel) {
            lavar.setVisible(true);
            lavar.setManaged(true);

            estaLavado.setVisible(true);
            estaLavado.setManaged(true);

            diasDesdeLavagem.setVisible(true);
            diasDesdeLavagem.setManaged(true);
        }
        atualizarCamposDaPagina(item);

        /* Colocando o tipo dentro do Label */

        String tipoString = " ";

        if (item instanceof RoupaInferior roupaInferior) {
            tipoString = roupaInferior.getTipo().getNome();
        }
        if (item instanceof RoupaSuperior roupaSuperior) {
            tipoString = roupaSuperior.getTipo().getNome();
        }
        if (item instanceof RoupaIntima roupaIntima) {
            tipoString = roupaIntima.getTipo().getNome();
        }
        if (item instanceof Calcado calcado) {
            tipoString = calcado.getTipo().getNome();
        }
        if (item instanceof Chapelaria chapelaria) {
            tipoString = chapelaria.getTipo().getNome();
        }
        if (item instanceof Acessorio acessorio) {
            tipoString = acessorio.getTipo().getNome();
        }

        tipo.setText(tipoString);

        /* Fim dos labels */

        nomeLabel.setText(item.getNome());
        corLabel.setText(item.getCor());
        tamanhoLabel.setText(item.getTamanho());
        marcaLabel.setText(item.getMarca());
        estadoLabel.setText(item.getEstado());

        confirmar.setOnMouseClicked(event -> {
            // Pegando TextField de nome
            String nomeTemporario = "";
            if (!(nome.getText().trim().isEmpty())) {
                nomeTemporario = nome.getText();
            } else {
                nomeTemporario = getInstanceOrgItens().getItemAtual().getNome();
            }

            //Pegando TextField de cor
            String corTemporario = "";
            if (!(cor.getText().trim().isEmpty())) {
                corTemporario = cor.getText();
            } else {
                corTemporario = getInstanceOrgItens().getItemAtual().getCor();
            }

            //Pegando TextField de tamanho
            String tamanhoTemporario = "";
            if (!(tamanho.getText().trim().isEmpty())) {
                tamanhoTemporario = tamanho.getText();
            } else {
                tamanhoTemporario = getInstanceOrgItens().getItemAtual().getTamanho();
            }

            //Pegando TextField de marca
            String marcaTemporario = "";
            if (!(marca.getText().trim().isEmpty())) {
                marcaTemporario = marca.getText();
            } else {
                marcaTemporario = getInstanceOrgItens().getItemAtual().getMarca();
            }

            // Pegando TextField estado
            String estadoTemporario = "";
            if (!(estado.getText().trim().isEmpty())) {
                estadoTemporario = estado.getText();
            } else {
                estadoTemporario = getInstanceOrgItens().getItemAtual().getEstado();
            }

            // Editando e vendo se dá certo, se não der, volta
            try {
                boolean result = getInstanceOrgItens().editarItem(getInstanceOrgItens().getItemAtual(),
                        nomeTemporario,
                        corTemporario,
                        tamanhoTemporario,
                        marcaTemporario,
                        estadoTemporario);
                if (!result) {
                    erro("Houve um erro ao alterar os dados do item " + item);
                    return;
                }
            } catch (Exception e) {
                erro("Comportamento inesperado");
            }

            Sucesso("Item editado com sucesso");
            getInstanceOrgItens().setItemAtualParaNull();
            NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", confirmar);
        });

        voltar.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", voltar);
            getInstanceOrgItens().setItemAtualParaNull();
        });

        emprestar.setOnMouseClicked(event -> {

            if (getInstanceOrgEmp().emprestarItem(item)) {
                Sucesso("Item emprestado com sucesso");
                atualizarCamposDaPagina(item);
            } else {
                erro("Houve um erro ao emprestar o item, talvez esteja emprestado");
            }
        });

        devolver.setOnMouseClicked(event -> {
            if (getInstanceOrgEmp().devolverItem(item)) {
                Sucesso("Item devolvido com sucesso");
                atualizarCamposDaPagina(item);
            } else {
                erro("Houve um erro ao devolver o item, talvez não esteja emprestado");
            }
        });

        usar.setOnMouseClicked(event -> {
            Optional<String> ocasiao = textInputDialog(item, "Ocasião", "Insira a ocasião de uso do item", "Ocasião: ");
            ocasiao.ifPresent(s -> {
                if (getInstanceOrgItens().usarItem(item, ocasiao.get())) {
                    Sucesso("Item usado com sucesso");
                    atualizarCamposDaPagina(item);
                } else {
                    erro("Item não foi usado, provavelmente está sujo ou emprestado");
                }
            });

        });

        lavar.setOnMouseClicked(event -> {
            if (item instanceof ILavavel iLavavel) {
                if (iLavavel.Lavar()) {
                    Sucesso("Item lavado com sucesso");
                    atualizarCamposDaPagina(item);
                }
                else {
                    erro("A roupa não foi lavada, provavelmente ou está emprestava ou já foi lavada");
                }
            }
        });
    }

    // Vamos tentar centralizar as atualizações dos labels, pq tava dando muito dor de cabeça (eu vou fidar maluco)
    public void atualizarCamposDaPagina(Item item) {
        try {
            nomeLabel.setText(item.getNome());
            corLabel.setText(item.getCor());
            tamanhoLabel.setText(item.getTamanho());
            marcaLabel.setText(item.getMarca());
            estadoLabel.setText(item.getEstado());
            dataAquisicao.setText(item.getDataDeAquisicao().toString());
            listaOcasioesUso.getItems().clear();
            listaOcasioesUso.getItems().addAll((item.getListaOcasioes() != null) ? item.getListaOcasioes() : new ArrayList<>());
        } catch (Exception e) {
            erro("Comportamento inesperado ao preencher dados do item");
        }

        // Labels de funções de empréstimo
        if (item instanceof IEmprestavel iEmprestavel) {
            //Essa forma compactada que tinha no C pode ser usada aqui também eu do futuro? Sim, funcionou!!!! Alegria!!!!
            try {
                emprestar.setDisable(iEmprestavel.isEmprestado());
                devolver.setDisable(!iEmprestavel.isEmprestado());
                seEmprestado.setText(iEmprestavel.isEmprestado() ? "Status empréstimo: ✅" : "Status empréstimo: ❎");
            } catch (Exception e) {
                erro("Comportamento inesperado ao verificar status de empréstimo");
            }

            try {
                if (iEmprestavel.quantidadeDeDiasDesdeOEmprestimo() >= 0) {
                    diasDesdeEmprestimo.setVisible(true);
                    diasDesdeEmprestimo.setManaged(true);
                    diasDesdeEmprestimo.setText("Faz " + iEmprestavel.quantidadeDeDiasDesdeOEmprestimo() + " dias desde o último empréstimo!");
                } else {
                    diasDesdeEmprestimo.setVisible(false);
                    diasDesdeEmprestimo.setManaged(false);
                }
            } catch (Exception e) {
                erro("Comportamento inesperado ao verificar dias desde o último empréstimo");
            }

        }

        // Labels de funções Laváveis
        if (item instanceof ILavavel iLavavel) {

            try {
                lavar.setDisable(iLavavel.isLavado());
                estaLavado.setText(iLavavel.isLavado() ? "Status lavagem: ✅" : "Status lavagem: ❎");
                usar.setDisable(!iLavavel.isLavado());
            } catch (Exception e) {
                erro("Comportamento inesperado ao verificar status de lavagem");
            }

            try {
                if (iLavavel.diasDesdeUltimaLavagem() >= 0) {
                    diasDesdeLavagem.setVisible(true);
                    diasDesdeLavagem.setManaged(true);
                    diasDesdeLavagem.setText("Faz " + iLavavel.diasDesdeUltimaLavagem() + " dias desde a última lavagem");
                } else {
                    diasDesdeLavagem.setVisible(false);
                    diasDesdeLavagem.setManaged(false);
                }
                diasDesdeLavagem.setText(iLavavel.diasDesdeUltimaLavagem() >= 0 ? ("Faz " + iLavavel.diasDesdeUltimaLavagem() + " dias desde a última lavagem") : (""));
            } catch (Exception e) {
                erro("Comportamento inesperado ao verificar os dias desde o último empréstimo");
            }
        }

        // Label Data de uso
        if (item.getUltimoUso() != null) {
            dataUso.setVisible(true);
            dataUso.setManaged(true);
            diasDesdeUltimoUso.setVisible(true);
            diasDesdeUltimoUso.setManaged(true);
            diasDesdeUltimoUso.setText("Faz " + item.diasDesdeOUltimoUso() + " desde o ultimo uso");
            dataUso.setText("Ultimo uso: " +  item.getUltimoUso());
        } else {
            dataUso.setVisible(true);
            dataUso.setManaged(true);
            dataUso.setText("Nunca usado");
        }

    }

    public void deixarTodosInvisiveis() {
        // No início tudo é invisível e não managed
        dataAquisicao.setVisible(false);
        dataAquisicao.setManaged(false);
        seEmprestado.setVisible(false);
        seEmprestado.setManaged(false);
        diasDesdeEmprestimo.setManaged(false);
        diasDesdeEmprestimo.setVisible(false);
        estaLavado.setVisible(false);
        estaLavado.setManaged(false);
        diasDesdeLavagem.setVisible(false);
        diasDesdeLavagem.setManaged(false);
        dataUso.setVisible(false);
        dataUso.setManaged(false);
        emprestar.setVisible(false);
        emprestar.setManaged(false);
        devolver.setVisible(false);
        devolver.setManaged(false);
        lavar.setVisible(false);
        lavar.setManaged(false);
        diasDesdeUltimoUso.setManaged(false);
        diasDesdeUltimoUso.setVisible(false);
    }

}
