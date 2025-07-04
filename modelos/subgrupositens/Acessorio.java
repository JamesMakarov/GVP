package modelos.subgrupositens;

import modelos.Item;
import modelos.Config_DataHora.DataHora;
import modelos.interfaces.IEmprestavel;
import utils.CalculadoraDias;
import utils.DataUtils;

public abstract class Acessorio extends Item implements IEmprestavel {
    
    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    
    //#region Construtores:
    public Acessorio(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.emprestado = false;
    }
    //#endregion

    //#region Getters e Setters
    public boolean foiEmprestado() {
        return emprestado;
    }

    public DataHora getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }
    //#endregion

    //#region Métodos IEmprestavel
    @Override
    public void Emprestando() {
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
    public void Devolvendo() {
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

    //#region Métodos Abstratos

     public abstract String getTipo();

     //#endregion
}
