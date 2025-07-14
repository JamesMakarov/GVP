package GUI.controladores.mostraritem;

import GUI.classesestaticas.novaspaginas.NovaPagina;
import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.ControladorAutenticacao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import modelos.Item;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.lavaveis.ILavavel;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import organizadores.OrganizadorDeEmprestimos;
import organizadores.OrganizadorDeItens;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static erros.ErrosESucessos.Sucesso;
import static java.lang.String.valueOf;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        OrganizadorDeItens organizadorDeItens = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
        Item item =  organizadorDeItens.getItemAtual();

        /* Visibilidade de botões */

        if (item instanceof IEmprestavel) {
            emprestar.setVisible(true);
            devolver.setVisible(true);
        } else {
            emprestar.setVisible(false);
            devolver.setVisible(false);
        }
        lavar.setVisible(item instanceof ILavavel);

        /* Colocando o tipo dentro do Label */

        String tipoString = " ";

        if (item instanceof RoupaInferior roupaInferior) {
            tipoString = valueOf(roupaInferior.getTipo());
        }
        if (item instanceof RoupaSuperior roupaSuperior) {
            tipoString = valueOf(roupaSuperior.getTipo());
        }
        if (item instanceof RoupaIntima roupaIntima) {
            tipoString = valueOf(roupaIntima.getTipo());
        }
        if (item instanceof Calcado calcado) {
            tipoString = valueOf(calcado.getTipo());
        }
        if (item instanceof Chapelaria chapelaria) {
            tipoString = valueOf(chapelaria.getTipo());
        }
        if (item instanceof Acessorio acessorio) {
            tipoString = valueOf(acessorio.getTipo());
        }

        tipo.setText(tipoString);
        /* Fim dos labels */

        nomeLabel.setText(item.getNome());
        corLabel.setText(item.getCor());
        tamanhoLabel.setText(item.getTamanho());
        marcaLabel.setText(item.getMarca());
        estadoLabel.setText(item.getEstado());

        confirmar.setOnMouseClicked(event -> {
            String nomeTemporario = "";
            if (!(nome.getText().trim().isEmpty())) {
                nomeTemporario = nome.getText();
            } else {
                nomeTemporario = organizadorDeItens.getItemAtual().getNome();
            }

            String corTemporario = "";
            if (!(cor.getText().trim().isEmpty())) {
                corTemporario = cor.getText();
            } else {
                corTemporario = organizadorDeItens.getItemAtual().getCor();
            }

            String tamanhoTemporario = "";
            if (!(tamanho.getText().trim().isEmpty())) {
                tamanhoTemporario = tamanho.getText();
            } else {
                tamanhoTemporario = organizadorDeItens.getItemAtual().getTamanho();
            }

            String marcaTemporario = "";
            if (!(marca.getText().trim().isEmpty())) {
                marcaTemporario = marca.getText();
            } else {
                marcaTemporario = organizadorDeItens.getItemAtual().getMarca();
            }

            String estadoTemporario = "";
            if (!(estado.getText().trim().isEmpty())) {
                estadoTemporario = estado.getText();
            } else {
                estadoTemporario = organizadorDeItens.getItemAtual().getEstado();
            }

            OrganizadorDeItens organizadorDeItens1  = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
            organizadorDeItens1.editarItem(organizadorDeItens.getItemAtual(),
                    nomeTemporario,
                    corTemporario,
                    tamanhoTemporario,
                    marcaTemporario,
                    estadoTemporario);
            organizadorDeItens1.setItemAtualParaNull();
            Sucesso("Item editado com sucesso");
            NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", confirmar);
        });

        voltar.setOnMouseClicked(event -> {
            NovaPagina.caminho("/GUI/fxmls/paginainicial/paginaInicial.fxml", voltar);
            OrganizadorDeItens organizadorDeItens2  = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
            organizadorDeItens2.setItemAtualParaNull();
        });

        emprestar.setOnMouseClicked(event -> {
            OrganizadorDeEmprestimos organizadorDeEmprestimos =  new OrganizadorDeEmprestimos(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
            organizadorDeEmprestimos.emprestarItem(item);
        });

        devolver.setOnMouseClicked(event -> {
            OrganizadorDeEmprestimos organizadorDeEmprestimos =  new OrganizadorDeEmprestimos(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
            organizadorDeEmprestimos.devolverItem(item);
        });

        usar.setOnMouseClicked(event -> {
            try {
                OrganizadorDeItens organizadorDeItens1 = new OrganizadorDeItens(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual());
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Ocasião");
                dialog.setHeaderText("Insira a ocasião de uso do item");
                dialog.setContentText("Ocasião: ");
                Optional<String> ocasiao = dialog.showAndWait();
                ocasiao.ifPresent(s -> {
                    organizadorDeItens1.getItemAtual().Usar(ocasiao.get());
                    organizadorDeItens1.usarItem(organizadorDeItens1.getItemAtual(), ocasiao.get());
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        });



    }
}
