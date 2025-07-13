package GUI.controladores.paginainicial;

import GUI.controladores.gerarcoisascomenums.StringEnum;
import guardaroupa.autenticacao.SessaoGuardaRoupa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import pessoa.Pessoa;
import pessoa.SessaoPessoa;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static erros.ErrosESucessos.erro;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<String> roupaSuperiorLista = StringEnum.getInstance().listaEnumStringRoupaSuperior();
            List<String> roupaInferiorLista = StringEnum.getInstance().listaEnumStringRoupaInferior();
            List<String> roupaIntimaLista = StringEnum.getInstance().listaEnumStringRoupaIntima();
            List<String> acessorioLista = StringEnum.getInstance().listaEnumStringAcessorio();
            List<String> chapelariaLista = StringEnum.getInstance().listaEnumStringChapelaria();
            List<String> calcadoLista = StringEnum.getInstance().listaEnumStringCalcado();

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


        pessoa.setText("Olá, "+SessaoPessoa.getPessoa().getNome());
        atualGR.setText("Você está no guarda-roupa: "+SessaoGuardaRoupa.getGuardaRoupaAtual().getNome());

        adicionarItem.setOnAction(e -> {
            try {
                FXMLLoader loader =  new FXMLLoader(getClass().getResource("/GUI/fxmls/caminhoparacriaritem/escolherTipoPrimario.fxml"));
                Parent proximaPagina = loader.load();
                Stage stage = (Stage)adicionarItem.getScene().getWindow();
                stage.setScene(new Scene(proximaPagina));
                stage.show();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });

    }
}
