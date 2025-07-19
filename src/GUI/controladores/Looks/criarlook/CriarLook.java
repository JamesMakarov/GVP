package GUI.controladores.Looks.criarlook;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import GUI.controladores.Looks.mostrarlook.MostrarLook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modelos.Item;
import modelos.Look;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

import java.net.URL;
import java.util.ResourceBundle;

import static GUI.classesestaticas.instanciasnecessias.Instancia.getInstanceOrgItens;
import static GUI.classesestaticas.instanciasnecessias.Instancia.getInstanceOrgLoo;
import static erros.ErroSucessoConfirmacao.Sucesso;
import static erros.ErroSucessoConfirmacao.erro;

public class CriarLook implements Initializable {

    @FXML
    private Button voltar;

    @FXML
    private TextField nome;

    @FXML
    private ListView<RoupaSuperior> listaRoupaSuperior;

    @FXML
    private ListView<RoupaInferior> listaRoupaInferior;

    @FXML
    private ListView<RoupaIntima> listaRoupaIntima;

    @FXML
    private ListView<Chapelaria>  listaChapelaria;

    @FXML
    private ListView<Acessorio> listaAcessorio;

    @FXML
    private ListView<Calcado> listaCalcado;

    @FXML
    private Button confirmar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarListas();
        confirmar.setOnMouseClicked(event -> {
            if (nome.getText().trim().isEmpty() ||
            listaRoupaSuperior.getSelectionModel().isEmpty() ||
            listaRoupaInferior.getSelectionModel().isEmpty() ||
            listaRoupaIntima.getSelectionModel().isEmpty()   ||
            listaChapelaria.getSelectionModel().isEmpty()    ||
            listaAcessorio.getSelectionModel().isEmpty()     ||
            listaCalcado.getSelectionModel().isEmpty()) {
                erro("Por favor, preencha todos os campos e selecione os itens devidos");
                return;
            } else {
                RoupaSuperior roupaSuperior = listaRoupaSuperior.getSelectionModel().getSelectedItem();
                RoupaInferior roupaInferior = listaRoupaInferior.getSelectionModel().getSelectedItem();
                RoupaIntima roupaIntima = listaRoupaIntima.getSelectionModel().getSelectedItem();
                Acessorio acessorio = listaAcessorio.getSelectionModel().getSelectedItem();
                Calcado calcado = listaCalcado.getSelectionModel().getSelectedItem();
                Chapelaria chapelaria = listaChapelaria.getSelectionModel().getSelectedItem();
                getInstanceOrgLoo().criarLook(nome.getText(), roupaSuperior, roupaInferior, acessorio,
                chapelaria, calcado, roupaIntima);

                Sucesso("Look criado com sucesso");

                NovaPagina.caminho("/GUI/fxmls/looks/looks.fxml", confirmar);
            }
        });

        voltar.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/looks/looks.fxml", confirmar);
        });
    }

    public void atualizarListas() {
        try {
            MostrarLook.addItens(listaRoupaSuperior, listaRoupaInferior, listaRoupaIntima, listaAcessorio, listaChapelaria, listaCalcado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
