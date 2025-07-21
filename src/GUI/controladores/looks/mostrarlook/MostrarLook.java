package GUI.controladores.looks.mostrarlook;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelos.Look;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.*;


import java.net.URL;
import java.util.ResourceBundle;

import static GUI.classesestaticas.instanciasnecessias.Instancia.*;
import static erros.ErroSucessoConfirmacao.*;

public class MostrarLook implements Initializable {

    @FXML
    private Label nomeLabel;

    @FXML
    private Label roupaSuperiorAtual;

    @FXML
    private Label roupaInferiorAtual;

    @FXML
    private Label roupaIntimaAtual;

    @FXML
    private Label acessorioAtual;

    @FXML
    private Label calcadoAtual;

    @FXML
    private Label chapelariaAtual;

    @FXML
    private Label dataUso;

    @FXML
    private Label estaLavado;

    @FXML
    private TextField nome;

    @FXML
    private ListView<RoupaSuperior> listaRoupaSuperior;

    @FXML
    private ListView<RoupaInferior> listaRoupaInferior;

    @FXML
    private ListView<RoupaIntima> listaRoupaIntima;

    @FXML
    private ListView<Acessorio> listaAcessorio;

    @FXML
    private ListView<Calcado> listaCalcado;

    @FXML
    private ListView<Chapelaria> listaChapelaria;

    @FXML
    private Button lavar;

    @FXML
    private Button usar;

    @FXML
    private Button confirmar;

    @FXML
    private Button voltar;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLabels();
        atualizarListas();

        confirmar.setOnMouseClicked( event -> {
            try {
                if (!(nome.getText().isEmpty())) {
                    if (!(nome.getText().trim().equals(getInstanceOrgLoo().getLookAtual().getNome()))) {
                        getInstanceOrgLoo().getLookAtual().setNome(nome.getText());
                    }
                }
                if ((listaRoupaSuperior.getSelectionModel().getSelectedItem() != null) && getInstanceOrgLoo().getLookAtual().getRoupaSuperior() != listaRoupaSuperior.getSelectionModel().getSelectedItem()) {
                    getInstanceOrgLoo().getLookAtual().setLook(listaRoupaSuperior.getSelectionModel().getSelectedItem());
                }
                if ((listaRoupaIntima.getSelectionModel().getSelectedItem() != null) && getInstanceOrgLoo().getLookAtual().getRoupaIntima() != listaRoupaIntima.getSelectionModel().getSelectedItem()) {
                    getInstanceOrgLoo().getLookAtual().setLook(listaRoupaIntima.getSelectionModel().getSelectedItem());
                }
                if ((listaRoupaInferior.getSelectionModel().getSelectedItem() != null) && getInstanceOrgLoo().getLookAtual().getRoupaInferior() != listaRoupaInferior.getSelectionModel().getSelectedItem()) {
                    getInstanceOrgLoo().getLookAtual().setLook(listaRoupaInferior.getSelectionModel().getSelectedItem());
                }
                if ((listaAcessorio.getSelectionModel().getSelectedItem() != null) && getInstanceOrgLoo().getLookAtual().getAcessorio() != listaAcessorio.getSelectionModel().getSelectedItem()) {
                    getInstanceOrgLoo().getLookAtual().setLook(listaAcessorio.getSelectionModel().getSelectedItem());
                }
                if ((listaCalcado.getSelectionModel().getSelectedItem() != null) && getInstanceOrgLoo().getLookAtual().getCalcado() != listaCalcado.getSelectionModel().getSelectedItem()) {
                    getInstanceOrgLoo().getLookAtual().setLook(listaCalcado.getSelectionModel().getSelectedItem());
                }
                if ((listaChapelaria.getSelectionModel().getSelectedItem() != null) && getInstanceOrgLoo().getLookAtual().getChapeu() != listaChapelaria.getSelectionModel().getSelectedItem()) {
                    getInstanceOrgLoo().getLookAtual().setLook(listaChapelaria.getSelectionModel().getSelectedItem());
                }
                getInstanceOrgLoo().setLookParaNull();
            } catch (Exception e) {
                erro("Comportamente inesperado ao preencher os dados alterados");
            }
            NovaPagina.caminho("/GUI/fxmls/looks/looks.fxml", confirmar);
        });

        voltar.setOnMouseClicked( event ->  {
            NovaPagina.caminho("/GUI/fxmls/looks/looks.fxml", voltar);
            getInstanceOrgLoo().setLookParaNull();
        });

        lavar.setOnMouseClicked( event -> {
            try {
                if (getInstanceOrgLav().lavarLook(getInstanceOrgLoo().getLookAtual())) {
                    Sucesso("Look lavado, mesmo que seja apenas um item sujo, agora você pode usar");
                } else {
                    erro("O look já está lavado");
                }
                atualizarLabels();
            } catch (Exception e) {
                erro("Comportamento inesperado ao lavar o item");
            }
        });

        usar.setOnMouseClicked(event -> {
            try {
                if (getInstanceOrgLoo().getLookAtual().UsarLook()) {
                    Sucesso("Look usado");
                } else {
                    erro("Não podem haver roupas sujas ou emprestadas");
                }
                atualizarLabels();
            } catch (Exception e) {
                erro("Comportamento inesperado ao usar o look");
            }
        });
    }

    public void atualizarListas() {
        try {
            listaRoupaSuperior.getItems().clear();
            listaRoupaInferior.getItems().clear();
            listaAcessorio.getItems().clear();
            listaCalcado.getItems().clear();
            listaRoupaIntima.getItems().clear();
            listaChapelaria.getItems().clear();
            addItens(listaRoupaSuperior, listaRoupaInferior, listaRoupaIntima, listaAcessorio, listaChapelaria, listaCalcado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addItens(ListView<RoupaSuperior> listaRoupaSuperior, ListView<RoupaInferior> listaRoupaInferior, ListView<RoupaIntima> listaRoupaIntima, ListView<Acessorio> listaAcessorio, ListView<Chapelaria> listaChapelaria, ListView<Calcado> listaCalcado) {
        listaRoupaSuperior.getItems().addAll(getInstanceOrgItens().listaDeRoupaSuperior());
        listaRoupaInferior.getItems().addAll(getInstanceOrgItens().listaDeRoupaInferior());
        listaRoupaIntima.getItems().addAll(getInstanceOrgItens().listaDeRoupaIntima());
        listaAcessorio.getItems().addAll(getInstanceOrgItens().listaDeAcessorio());
        listaChapelaria.getItems().addAll(getInstanceOrgItens().listaDeChapelaria());
        listaCalcado.getItems().addAll(getInstanceOrgItens().listaDeCalcado());
    }

    public void atualizarLabels() {
         try {
             Look lookAtual = getInstanceOrgLoo().getLookAtual();
             nomeLabel.setText(lookAtual.getNome());
             roupaSuperiorAtual.setText(lookAtual.getRoupaSuperior().getNome() + " : " + lookAtual.getRoupaSuperior().getTipo().getNome());
             roupaInferiorAtual.setText(lookAtual.getRoupaInferior().getNome() + " : " + lookAtual.getRoupaInferior().getTipo().getNome());
             roupaIntimaAtual.setText(lookAtual.getRoupaIntima().getNome() + " : " + lookAtual.getRoupaIntima().getTipo().getNome());
             acessorioAtual.setText(lookAtual.getAcessorio().getNome() + " : " + lookAtual.getAcessorio().getTipo().getNome());
             calcadoAtual.setText(lookAtual.getCalcado().getNome() + " : " + lookAtual.getCalcado().getTipo().getNome());
             chapelariaAtual.setText(lookAtual.getChapeu().getNome() + " : " + lookAtual.getChapeu().getTipo().getNome());
             if (lookAtual.getUltimoUso() != null) {
                 dataUso.setText(lookAtual.getUltimoUso().toString() + " : " + lookAtual.getChapeu().getTipo().getNome());
             } else {
                 dataUso.setText("Nunca usado");
             }
             estaLavado.setText((lookAtual.lookLavado()) ? "Está lavado" : "Está sujo");
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

}
