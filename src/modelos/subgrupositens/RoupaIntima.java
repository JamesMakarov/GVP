package modelos.subgrupositens;

import modelos.Item;
import modelos.Config_DataHora.DataHora;
import modelos.interfaces.ILavavel;
import utils.CalculadoraDias;
import utils.DataUtils;

public abstract class RoupaIntima extends Item implements ILavavel {
    private DataHora dataLavagem;
    private boolean isLavado;

    //#region Construtores:
    public RoupaIntima(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }
    //#endregion

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
        this.ultimoUso = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        isLavado = false;
    }

    //#endregion
}
