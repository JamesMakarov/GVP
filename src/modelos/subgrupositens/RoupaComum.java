package modelos.subgrupositens;

import modelos.Item;
import modelos.configdatahora.DataHora;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.lavaveis.ILavavel;
import utils.DataUtils;
import utils.CalculadoraDias;

import java.util.List;

public abstract class RoupaComum extends Item implements ILavavel, IEmprestavel {
    //#region Atributos

    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    private DataHora dataLavagem;
    private boolean isLavado;


    //#endregion

    //#region Construtores:

    public RoupaComum(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.emprestado = false;
        this.isLavado = true;
        dataLavagem = null;
        dataDoEmprestimo = null;
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
        if (isEmprestado()) {
            System.out.println("O item já foi emprestado, devolva o para poder emprestar novamente");
            return;
        }
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
        if (isEmprestado()) {
            this.emprestado = false;
            this.dataDoEmprestimo = null;
            return;
        } 
        System.out.println("Erro, item não foi emprestado para que seja devolvido");
        
    }

    @Override
    public int quantidadeDeDiasDesdeOEmprestimo() {
        if (dataDoEmprestimo == null) {
            return 0;
        }
        return CalculadoraDias.CalcularDias(dataDoEmprestimo);
    }

    //#endregion

    //#region Métodos ILavavel
    @Override
    public boolean Lavar() {
        if (!isLavado()) {
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
        } else {
            System.out.println("O item já está lavado!");
            return false;
        }
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
    public void Usar(String ocasiao) {
        if (!isLavado) {
            System.out.println("Não é possível utilizar um item sujo");
            return;
        }
        DataHora var = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        setUltimoUso(var);
        setOcasiaoDeUso(ocasiao);
        isLavado = false;
        DataHora data = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        String dataString = data.toString();
        if (!(ocasiao.trim().isEmpty())) {this.setOcasioesDeUso(" Em "+ dataString + " foi usado para " + ocasiao);}
        if (ocasiao.trim().isEmpty()) {this.setOcasioesDeUso("Em " + dataString + " não foi especificada a ocasião de uso");}
    }

    //#endregion
}
