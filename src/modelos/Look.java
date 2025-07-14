package modelos;

import java.util.ArrayList;
import java.util.List;

import modelos.configdatahora.DataHora;
import modelos.interfaces.lavaveis.ILavavel;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import utils.DataUtils;

public class Look {

    //#region Atributos
    private final String nome;
    private RoupaSuperior roupaSuperior;
    private RoupaInferior roupaInferior;
    private Acessorio acessorio;
    private Chapelaria chapeu;
    private Calcado calcado;
    private RoupaIntima roupaIntima;
    private DataHora ultimoUso;
    private final DataHora dataDeCriacao;
    private int numeroDeUsos;
    private List<DataHora> listaUso;
    //endregion

    //#region Construtor
    public Look(String nome, RoupaSuperior roupaSuperior, RoupaInferior roupaInferior, Acessorio acessorio,
            Chapelaria chapeu, Calcado calcado, RoupaIntima roupaIntima) {
        this.nome = nome;
        this.roupaSuperior = roupaSuperior;
        this.roupaInferior = roupaInferior;
        this.acessorio = acessorio;
        this.chapeu = chapeu;
        this.calcado = calcado;
        this.roupaIntima = roupaIntima;
        this.ultimoUso = null;
        this.numeroDeUsos = 0;
        this.dataDeCriacao = new DataHora(DataUtils.diaNow(),
                                          DataUtils.mesNow(), 
                                          DataUtils.anoNow(), 
                                          DataUtils.horaNow(), 
                                          DataUtils.minutoNow(), 
                                          DataUtils.segundoNow());
    }

    //#endregion

    //#region Getters e Setters
    public String getNome() {
        return nome;
    }

    public RoupaSuperior getRoupaSuperior() {
        return roupaSuperior;
    }

    public RoupaInferior getRoupaInferior() {
        return roupaInferior;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public Chapelaria getChapeu() {
        return chapeu;
    }

    public Calcado getCalcado() {
        return calcado;
    }

    public RoupaIntima getRoupaIntima() {
        return roupaIntima;
    }

    public int getNumeroDeUsos() {
        return numeroDeUsos;
    }

    public void setNumeroDeUsos(int numeroDeUsos) {
        this.numeroDeUsos = numeroDeUsos;
    }

    public void mudarLook(RoupaSuperior roupaSuperior) {
        this.roupaSuperior = roupaSuperior;
    }

    public void mudarLook(RoupaInferior roupaInferior) {
        this.roupaInferior = roupaInferior;
    }

    public void mudarLook(Chapelaria chapeu) {
        this.chapeu = chapeu;
    }

    public void mudarLook(Calcado calcado) {
        this.calcado = calcado;
    }

    public void mudarLook(RoupaIntima roupaIntima) {
        this.roupaIntima = roupaIntima;
    }
    
    public void mudarLook(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    public List<DataHora> getListaUso() {
        return listaUso;
    }

    public void setListaUso(List<DataHora> listaUso) {
        this.listaUso = listaUso;
    }

    public DataHora getUltimoUso() {
        return ultimoUso;
    }

    public void setUltimoUso(DataHora ultimoUso) {
        this.ultimoUso = ultimoUso;
    }

    public DataHora DataDeCriacao() {
        return dataDeCriacao;
    }
    //#endregion

    //#region Métodos de Uso
    public void UsarLook() {
        if (roupaSuperior.isLavado() && !(roupaSuperior.isEmprestado()) &&
            roupaInferior.isLavado() && !(roupaInferior.isEmprestado()) &&
            calcado.isLavado() && !(calcado.isEmprestado()) &&
            chapeu.isLavado() && !(chapeu.isEmprestado()) &&
            roupaIntima.isLavado() && !(acessorio.isEmprestado())) {
            
                DataHora dataHora = new DataHora(
                    DataUtils.diaNow(),
                    DataUtils.mesNow(),
                    DataUtils.anoNow(),
                    DataUtils.horaNow(),
                    DataUtils.minutoNow(),
                    DataUtils.segundoNow()
                );
                this.ultimoUso = dataHora;
                listaUso.add(dataHora);
                roupaSuperior.setUltimoUso(ultimoUso);
                roupaInferior.setUltimoUso(ultimoUso);
                roupaIntima.setUltimoUso(ultimoUso);
                acessorio.setUltimoUso(ultimoUso);
                chapeu.setUltimoUso(ultimoUso);
                calcado.setUltimoUso(ultimoUso);
                numeroDeUsos++;
        } else {
            System.out.println("Algum item do Look está sujo ou emprestado, lave-o para poder usar ou devolva-a!");
        }
    }
    //#endregion

    //#region Lavagem
    public void LavarLooK () {
        for (Item i : listarItensDoLook()) {
            if (i instanceof ILavavel j) {
                if (!(j.isLavado())) j.Lavar();
            }
        }
    }
    //endregion

    //#region Retorno de todos os itens
    public List<Item> listarItensDoLook() {
        List<Item> lista = new ArrayList<>();
        lista.add(roupaSuperior);
        lista.add(roupaInferior);
        lista.add(roupaIntima);
        lista.add(acessorio);
        lista.add(calcado);
        lista.add(chapeu);
        return lista;
    }
    //#endregion

    @Override
    public String toString() {
        return nome;
    }
}
