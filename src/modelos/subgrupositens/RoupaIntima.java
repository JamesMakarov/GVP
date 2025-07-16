package modelos.subgrupositens;

import modelos.Item;
import modelos.configdatahora.DataHora;
import modelos.interfaces.lavaveis.ILavavel;
import utils.CalculadoraDias;
import utils.DataUtils;

public class RoupaIntima extends Item implements ILavavel {

    //#region Tipos
    public enum Tipo {
    CUECA,
    CALCINHA,
    SUTIA
    }
    //#endregion

    //#region Atributos
    private DataHora dataLavagem;
    private boolean isLavado;
    private Tipo tipo;
    //#endregion

    //#region Construtores:
    public RoupaIntima(Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
        super( nome, cor, tamanho, marca, estado);
        this.tipo = tipo;
        this.isLavado = true;
        dataLavagem = null;
    }
    //#endregion

    //#region Getter e Setter Tipo
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    //#endregion

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
            return -1;
        }
        return CalculadoraDias.CalcularDias(dataLavagem);
    }

    @Override
    public boolean isLavado() {
        return isLavado;
    }

    @Override
    public boolean Usar(String ocasiao) {
        if (!isLavado) {
            return false;
        }
        isLavado = false;
        DataHora var = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        setUltimoUso(var);
        setOcasiaoDeUso(ocasiao);
        String dataString = var.toString();
        if (!(ocasiao.trim().isEmpty())) {this.setOcasioesDeUso(" Em "+ dataString + " foi usado para " + ocasiao);}
        if (ocasiao.trim().isEmpty()) {this.setOcasioesDeUso("Em " + dataString + " não foi especificada a ocasião de uso");}
        return true;
    }

    //#endregion
}
