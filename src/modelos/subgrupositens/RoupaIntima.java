package modelos.subgrupositens;

import modelos.Item;
import modelos.Config_DataHora.DataHora;
import modelos.interfaces.lavaveis.ILavavel;
import utils.CalculadoraDias;
import utils.DataUtils;

public class RoupaIntima extends Item implements ILavavel {

    public enum Tipo {
    CUECA,
    CALCINHA,
    SUTIA
    }

    private DataHora dataLavagem;
    private boolean isLavado;
    private Tipo tipo;

    //#region Construtores:
    public RoupaIntima(Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
        super( nome, cor, tamanho, marca, estado);
        this.tipo = tipo;
    }
    //#endregion

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    //#region Métodos Ilavavel

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
            return 0;
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
