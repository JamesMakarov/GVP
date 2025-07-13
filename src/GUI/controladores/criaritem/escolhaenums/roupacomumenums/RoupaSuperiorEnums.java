package GUI.controladores.criaritem.escolhaenums.roupacomumenums;

import GUI.controladores.gerarcoisascomenums.StringEnum;
import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.SessaoGuardaRoupa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import organizadores.OrganizadorDeItens;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static erros.ErrosESucessos.erro;
import static erros.ErrosESucessos.Sucesso;

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
        List<String> listaEnumStringRoupaSuperior = StringEnum.getInstance().listaEnumStringRoupaSuperior();
        for (String i : listaEnumStringRoupaSuperior) {
            enumRoupaSuperior.getItems().add(i);
        }

        enumRoupaSuperior.setOnMouseClicked(event1 -> {
            if (event1.getClickCount() == 1) {
                GuardaRoupa guardaRoupa = SessaoGuardaRoupa.getGuardaRoupaAtual();
                OrganizadorDeItens organizadorDeItens = new OrganizadorDeItens(guardaRoupa);
                String selecao = enumRoupaSuperior.getSelectionModel().getSelectedItem();
                if (selecao != null) {
                    confirmar.setOnAction(event2 -> {
                        if (nome.getText().trim().isEmpty()         ||
                                cor.getText().trim().isEmpty()      ||
                                tamanho.getText().trim().isEmpty()  ||
                                marca.getText().trim().isEmpty()    ||
                                estado.getText().trim().isEmpty()) {
                            erro("Não é permitido campos nulos");
                        }
                        String name = nome.getText();
                        String color = cor.getText();
                        String size  = tamanho.getText();
                        String type = marca.getText();
                        String status = estado.getText();

                        RoupaSuperior acessorio = organizadorDeItens.criarItem(StringEnum.getInstance().stringParaEnumRoupaSuperior(selecao),name,color,size,type,status );

                        if (acessorio == null) {
                            erro("Houve um erro ao criar o acessório");
                        } else {
                            Sucesso("Objeto criado com Sucesso");
                        }

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fxmls/paginainicial/paginaInicial.fxml"));
                            Parent proximaPagina = loader.load();
                            Stage stage = (Stage)confirmar.getScene().getWindow();
                            stage.setScene(new Scene(proximaPagina));
                            stage.show();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }


                    });
                }
            }
        });

    }
}
