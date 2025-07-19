package GUI.controladores.criaritem.escolhaenums.roupacomumenums;

import GUI.classesestaticas.gerarcoisascomenums.StringEnum;
import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.SessaoGuardaRoupa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import organizadores.OrganizadorDeItens;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static GUI.classesestaticas.instanciasnecessias.Instancia.getInstanceOrgItens;
import static erros.ErroSucessoConfirmacao.erro;
import static erros.ErroSucessoConfirmacao.Sucesso;

public class RoupaSuperiorEnums implements Initializable {

    @FXML
    private ListView<String> enumRoupaSuperior;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<String> listaEnumStringRoupaSuperior = StringEnum.listaEnumStringRoupaSuperior();
        for (String i : listaEnumStringRoupaSuperior) {
            enumRoupaSuperior.getItems().add(i);
        }

        enumRoupaSuperior.setOnMouseClicked(event1 -> {
            if (event1.getClickCount() == 1) {
                String selecao = enumRoupaSuperior.getSelectionModel().getSelectedItem();
                if (selecao != null) {
                    confirmar.setOnAction(event2 -> {
                        if (nome.getText().trim().isEmpty()         ||
                                cor.getText().trim().isEmpty()      ||
                                tamanho.getText().trim().isEmpty()  ||
                                marca.getText().trim().isEmpty()    ||
                                estado.getText().trim().isEmpty()) {
                            erro("Não é permitido campos nulos");
                            return;
                        }
                        String name = nome.getText();
                        String color = cor.getText();
                        String size  = tamanho.getText();
                        String type = marca.getText();
                        String status = estado.getText();

                        RoupaSuperior acessorio = getInstanceOrgItens().criarItem(StringEnum.stringParaEnumRoupaSuperior(selecao),name,color,size,type,status );

                        if (acessorio == null) {
                            erro("Houve um erro ao criar o acessório");
                        } else {
                            Sucesso("Objeto criado com Sucesso");
                        }

                        NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml",  confirmar);

                    });
                }
            }
        });

    }
}
