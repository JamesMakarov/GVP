package modelos.subgrupositens;

import modelos.Item;
import modelos.configdatahora.DataHora;
import modelos.interfaces.emprestaveis.IEmprestavel;
import utils.CalculadoraDias;
import utils.DataUtils;

public class Acessorio extends Item implements IEmprestavel {

    //#region Abributos
    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    private final Tipo tipo;
    //#endregion

    //#region Tipo enum
    public enum Tipo {
        RELOGIO,
        PULSEIRA,
        COLAR,
        CINTO
    }
    //#endregion

    //#region Construtores:
    public Acessorio(Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.emprestado = false;
        this.tipo = tipo;
        dataDoEmprestimo = null;
    }
    //#endregion

    //#region Getters e Setters
    public DataHora getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }
    public Tipo getTipo() {
        return tipo;
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
    public int quantidadeDeDiasDesdeOEmprestimo() {
        if (dataDoEmprestimo == null) {
            return 0;
        }
        return CalculadoraDias.CalcularDias(dataDoEmprestimo);
    }
    
    public boolean isEmprestado() {
        return emprestado;
    }
    //#endregion

}
