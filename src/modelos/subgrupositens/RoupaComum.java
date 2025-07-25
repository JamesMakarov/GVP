package modelos.subgrupositens;

import guardaroupa.autenticacao.ControladorAutenticacao;
import modelos.Item;
import modelos.configdatahora.DataHora;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.lavaveis.ILavavel;
import utils.DataUtils;
import utils.CalculadoraDias;

import java.io.Serial;
import java.io.Serializable;

import static persistencia.Serializer.salvarCADat;

public abstract class RoupaComum extends Item implements ILavavel, IEmprestavel, Serializable {
    //#region Atributos
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    private DataHora dataLavagem;
    private boolean isLavado;


    //#endregion

    //#region Construtores:

    public RoupaComum(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.emprestado = false;
        this.isLavado = true;
        dataLavagem = null;
        dataDoEmprestimo = null;
    }

    //#endregion

    //#region Getters e Setters

    public boolean isEmprestado() {
        return emprestado;
    }

    public DataHora getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public DataHora getDataLavagem() {
        return dataLavagem;
    }

    //#endregion

    //#region Métodos IEmprestavel

    @Override
    public void Emprestar() {
        if (isEmprestado()) {
            System.out.println("O item já foi emprestado, devolva o para poder emprestar novamente");
            return;
        }
        this.dataDoEmprestimo = new DataHora(
            DataUtils.diaNow(),
            DataUtils.mesNow(),
            DataUtils.anoNow(),
            DataUtils.horaNow(),
            DataUtils.minutoNow(),
            DataUtils.segundoNow()
        );
        this.emprestado = true;
    }

    @Override
    public void Devolver() {
        if (isEmprestado()) {
            this.emprestado = false;
            this.dataDoEmprestimo = null;
            return;
        } 
        System.out.println("Erro, item não foi emprestado para que seja devolvido");
        
    }

    @Override
    public int quantidadeDeDiasDesdeOEmprestimo() {
        if (dataDoEmprestimo == null) {
            return -1;
        }
        return CalculadoraDias.CalcularDias(dataDoEmprestimo);
    }

    //#endregion

    //#region Métodos ILavavel
    @Override
    public boolean Lavar() {
        if (!isLavado && !emprestado) {
            this.dataLavagem = new DataHora(
                    DataUtils.diaNow(),
                    DataUtils.mesNow(),
                    DataUtils.anoNow(),
                    DataUtils.horaNow(),
                    DataUtils.minutoNow(),
                    DataUtils.segundoNow()
            );
            this.isLavado = true;
            return true;
        } else {
            System.out.println("O item já está lavado ou emprestado!");
            return false;
        }
    }

    @Override
    public int diasDesdeUltimaLavagem() {
        if (dataLavagem == null) {
            return -1;
        }
        return CalculadoraDias.CalcularDias(dataLavagem);
    }

    @Override
    public boolean isLavado() {
        return isLavado;
    }

    public void setIsLavado(boolean isLavado) {
        if (this.isLavado != isLavado) this.isLavado = isLavado;
    }

    @Override
    public boolean Usar(String ocasiao) {
        if (!isLavado || emprestado) {
            return false;
        }
        isLavado = false;
        DataHora var = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        setUltimoUso(var);
        setOcasiaoDeUso(ocasiao);
        String dataString = var.toString();
        if (!(ocasiao.trim().isEmpty())) {this.setOcasioesDeUso(" Em "+ dataString + " foi usado para " + ocasiao);}
        if (ocasiao.trim().isEmpty()) {this.setOcasioesDeUso("Em " + dataString + " não foi especificada a ocasião de uso");}
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
        }



    //#endregion
}
