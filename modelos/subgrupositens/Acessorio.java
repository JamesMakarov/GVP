package modelos.subgrupositens;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import modelos.Item;
import modelos.interfaces.IEmprestavel;
import modelos.interfaces.Config_DataHora.DataHora;
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
    public boolean estaEmprestado() {
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
            return 0L;
        }
        return ChronoUnit.DAYS.between(dataDoEmprestimo.toLocalDate(), LocalDate.now());
    }
    //#endregion

    //#region Métodos Abstratos

     public abstract String getTipo();

     //#endregion
}
