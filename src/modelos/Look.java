package modelos;

import modelos.Config_DataHora.DataHora;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import utils.DataUtils;

public class Look {
    
    private String nome;
    private RoupaSuperior roupaSuperior;
    private RoupaInferior roupaInferior;
    private Acessorio acessorio;
    private Chapelaria chapeu;
    private Calcado calcado;
    private RoupaIntima roupaIntima;
    private DataHora ultimoUso;
    private DataHora dataDeCriacao;

    //#region exigencia de adicionar um item e alterar a parte correspondente no look automaticamente
    
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
        this.dataDeCriacao = new DataHora(DataUtils.diaNow(),
                                          DataUtils.diaNow(), 
                                          DataUtils.diaNow(), 
                                          DataUtils.diaNow(), 
                                          DataUtils.diaNow(), 
                                          DataUtils.diaNow());
    }

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


    public void UsarLook() {
        if (roupaSuperior.isLavado() && !(roupaSuperior.isEmprestado()) &&
            roupaInferior.isLavado() && !(roupaInferior.isEmprestado()) &&
            calcado.isLavado() && !(calcado.isEmprestado()) &&
            chapeu.isLavado() && !(chapeu.isEmprestado()) &&
            roupaIntima.isLavado() && !(acessorio.isEmprestado())) {
            
                this.ultimoUso = new DataHora(
                    DataUtils.diaNow(),
                    DataUtils.mesNow(),
                    DataUtils.anoNow(),
                    DataUtils.horaNow(),
                    DataUtils.minutoNow(),
                    DataUtils.segundoNow()
                );

                roupaSuperior.setUltimoUso(ultimoUso);
                roupaInferior.setUltimoUso(ultimoUso);
                roupaIntima.setUltimoUso(ultimoUso);
                acessorio.setUltimoUso(ultimoUso);
                chapeu.setUltimoUso(ultimoUso);
                calcado.setUltimoUso(ultimoUso);
                return;
        } else {
            System.out.println("Algum item do Look está sujo ou emprestado, lave-o para poder usar ou devolva-a!");
        }
    }

    public void LavarLooK () {
        roupaSuperior.Lavar();
        roupaInferior.Lavar();
        roupaIntima.Lavar();
        calcado.Lavar();
        chapeu.Lavar();
    }

    public DataHora DataDeCriacao() {
        return dataDeCriacao;
    }


    //#endregion
}
