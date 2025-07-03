package modelos.subgrupositens;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import modelos.Item;
import modelos.interfaces.ILavavel;
import modelos.interfaces.Config_DataHora.DataHora;
import utils.DataUtils;

public abstract class RoupaIntima extends Item implements ILavavel {
    private DataHora dataLavagem;

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
