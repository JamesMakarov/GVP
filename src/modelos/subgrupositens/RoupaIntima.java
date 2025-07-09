package modelos.subgrupositens;

import modelos.Item;
import modelos.configdatahora.DataHora;
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
        this.isLavado = true;
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
    public boolean Lavar() {
        if (isLavado()) {
            System.out.println("O item já está lavado!");
            return false;
        }
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
    public void Usar(String ocasiao) {
        if (!(isLavado)) {
            System.out.println("Não é possível utilizar um item sujo");
            return;
        }
        DataHora var = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        setUltimoUso(var);
        setOcasiaoDeUso(ocasiao);
        isLavado = false;
    }

    //#endregion
}
