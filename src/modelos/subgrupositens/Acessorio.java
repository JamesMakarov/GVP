package modelos.subgrupositens;

import guardaroupa.autenticacao.ControladorAutenticacao;
import modelos.Item;
import modelos.configdatahora.DataHora;
import modelos.interfaces.emprestaveis.IEmprestavel;
import utils.CalculadoraDias;
import utils.DataUtils;

import java.io.Serial;
import java.io.Serializable;

import static persistencia.Serializer.salvarCADat;

public class Acessorio extends Item implements IEmprestavel, Serializable {

    //#region Abributos
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean emprestado;
    private DataHora dataDoEmprestimo;
    private final Tipo tipo;
    //#endregion

    //#region Tipo enum
    public enum Tipo {
        RELOGIO("Relógio"),
        PULSEIRA("Pulseira"),
        COLAR("Colar"),
        CINTO("Cinto");

        private final String nome;

        Tipo(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
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
        if (emprestado) {
            this.emprestado = false;
            this.dataDoEmprestimo = null;
        }
    }

    @Override
    public int quantidadeDeDiasDesdeOEmprestimo() {
        if (dataDoEmprestimo == null) {
            return -1;
        }
        return CalculadoraDias.CalcularDias(dataDoEmprestimo);
    }

    @Override
    public boolean Usar(String ocasiao) {
        if (!emprestado) {
            DataHora data = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
            setOcasiaoDeUso(ocasiao);
            setUltimoUso(data);
            setListaDataHoraDeUso(data);
            if (ocasiao != null) {setOcasioesDeUso(" Em "+ data + " foi usado para " + ocasiao);}
            if (ocasiao == null) {setOcasioesDeUso("Em " + data + " foi usado para algo não especificado");}
            salvarCADat(ControladorAutenticacao.getInstancia());
            return true;
        }
        return false;
    }
    
    public boolean isEmprestado() {
        return emprestado;
    }
    //#endregion

    @Override
    public String toString() {
        return (getNome() + " : " + tipo.getNome());
    }
}
