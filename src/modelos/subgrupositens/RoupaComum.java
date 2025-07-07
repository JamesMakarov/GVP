package modelos.subgrupositens;

import modelos.Item;
import modelos.Config_DataHora.DataHora;
import modelos.interfaces.IEmprestavel;
import modelos.interfaces.ILavavel;
import utils.DataUtils;
import utils.CalculadoraDias;

public abstract class RoupaComum extends Item implements ILavavel, IEmprestavel {
    //#region Atributos

    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    private DataHora dataLavagem;
    private boolean isLavado;

    //#endregion

    //#region Construtores:

    public RoupaComum(String tipo, String nome, String cor, String tamanho, String marca, String estado) {
        super(tipo, nome, cor, tamanho, marca, estado);
        this.emprestado = false;
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
        this.emprestado = false;
        this.dataDoEmprestimo = null;
    }

    @Override
    public long quantidadeDeDiasDesdeOEmprestimo() {
        if (dataDoEmprestimo == null) {
            return 0;
        }
        int val = CalculadoraDias.CalcularDias(dataDoEmprestimo);
        return val;
    }

    //#endregion

    //#region Métodos ILavavel

    @Override
    public void Lavar() {
        this.dataLavagem = new DataHora(
            DataUtils.diaNow(),
            DataUtils.mesNow(),
            DataUtils.anoNow(),
            DataUtils.horaNow(),
            DataUtils.minutoNow(),
            DataUtils.segundoNow()
        );
        this.isLavado = true;
    }

    @Override
    public int diasDesdeUltimaLavagem() {
        if (dataLavagem == null) {
            return -1;
        }
        int val = CalculadoraDias.CalcularDias(dataLavagem);
        return val;
    }

    @Override
    public boolean isLavado() {
        return isLavado;
    }
    
    @Override
    public void Usar() {
        DataHora var = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        setUltimoUso(var);
        isLavado = false;
    }

    //#endregion
}
