package modelos;

import java.util.ArrayList;
import java.util.List;

import modelos.configdatahora.DataHora;
import utils.CalculadoraDias;
import utils.DataUtils;

public abstract class Item {
    //#region Atributos
    private String nome;
    private String cor;
    private String tamanho;
    private String marca;
    private String estado;
    private DataHora dataDeAquisicao;
    private DataHora ultimoUso; 
    private List<DataHora> listaDataHoraDeUso;
    private int numeroDeUsos;
    private String ocasiaoDeUso;
    private final List<String> ocasioesDeUso;
    //#endregion

    //#region Construtor
    public Item(String nome, String cor, String tamanho, String marca, String estado) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.estado = estado;
        this.numeroDeUsos = 0;
        this.dataDeAquisicao = new DataHora(
            DataUtils.diaNow(),
            DataUtils.mesNow(),
            DataUtils.anoNow(),
            DataUtils.horaNow(),
            DataUtils.minutoNow(),
            DataUtils.segundoNow()
        );
        this.ultimoUso = null;
        this.ocasioesDeUso = new ArrayList<>();
        this.listaDataHoraDeUso = new ArrayList<>();
    }
    //#endregion

    //#region Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DataHora getDataDeAquisicao() {
        return dataDeAquisicao;
    }

    public void setDataDeAquisicao(DataHora dataDeAquisicao) {
        this.dataDeAquisicao = dataDeAquisicao;
    }

    public DataHora getUltimoUso() {
        return ultimoUso;
    }

    public void setUltimoUso(DataHora ultimoUso) {
        this.ultimoUso = ultimoUso;
    }

    public int getNumeroDeUsos() {
        return numeroDeUsos;
    }

    public void setNumeroDeUsos(int numeroDeUsos) {
        this.numeroDeUsos = numeroDeUsos;
    }

    public List<DataHora> getListaDataHoraDeUso() {
        return listaDataHoraDeUso;
    }

    public void setListaDataHoraDeUso(DataHora dataHoraDeUso) {
        this.listaDataHoraDeUso.add(dataHoraDeUso);
    }
    public String getOcasiaoDeUso() {
        return ocasiaoDeUso;
    }

    public void setOcasiaoDeUso(String ocasiaoDeUso) {
        this.ocasiaoDeUso = ocasiaoDeUso;
    }

    public void setOcasioesDeUso(String ocasioesDeUso) {
        this.ocasioesDeUso.add(ocasioesDeUso);
    }

    //#endregion

    //#region Métodos de Uso
    public boolean Usar(String ocasiao) {
        DataHora data = new DataHora(DataUtils.diaNow(), DataUtils.mesNow(), DataUtils.anoNow(), DataUtils.horaNow(), DataUtils.minutoNow(), DataUtils.segundoNow());
        this.ocasiaoDeUso = ocasiao;
        this.ultimoUso = data;
        listaDataHoraDeUso.add(data);
        String dataString = data.toString();
        if (ocasiao != null) {this.ocasioesDeUso.add(" Em "+ dataString + " foi usado para " + ocasiao);}
        if (ocasiao == null) {this.ocasioesDeUso.add("Em " + dataString + " foi usado para algo não especificado");}
        return true;
    }

    public int diasDesdeOUltimoUso() {
        if (ultimoUso == null) {
            return -1;
        }

        return CalculadoraDias.CalcularDias(ultimoUso);
    }
    //#endregion

    @Override
    public String toString() {
        return nome;
    }

    
}
