package modelos.subgrupositens;

import java.time.temporal.ChronoUnit;

import modelos.Item;
import modelos.interfaces.IEmprestavel;
import modelos.interfaces.ILavavel;
import modelos.interfaces.Config_DataHora.DataHora;
import java.time.LocalDate;
import utils.DataUtils;

public abstract class RoupaComum extends Item implements ILavavel, IEmprestavel {
    //#region Atributos

    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    private DataHora dataLavagem;

    //#endregion

    //#region Construtores:

    public RoupaComum(String nome, String cor, String tamanho, String marca, String estado) {
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

    public DataHora getDataLavagem() {
        return dataLavagem;
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
    }

    @Override
    public long diasDesdeUltimaLavagem() {
        if (dataLavagem == null) {
            return 0L;
        }
        return ChronoUnit.DAYS.between(dataLavagem.toLocalDate(), LocalDate.now());
    }

    //#endregion

    //#region Métodos Abstratos

    public abstract String getTipo();

    //#endregion
}
