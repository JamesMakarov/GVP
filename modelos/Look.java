package modelos;

import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public class Look {
    
    private String nome;
    private RoupaSuperior roupaSuperior;
    private RoupaInferior roupaInferior;
    private Acessorio acessorio;
    private Chapelaria chapeu;
    private Calcado calcado;
    private RoupaIntima roupaIntima;

    public Look(String nome) {
        this.nome = nome;
    }

    //#region Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RoupaSuperior getRoupaSuperior() {
        return roupaSuperior;
    }

    public void setRoupaSuperior(RoupaSuperior roupaSuperior) {
        this.roupaSuperior = roupaSuperior;
    }

    public RoupaInferior getRoupaInferior() {
        return roupaInferior;
    }

    public void setRoupaInferior(RoupaInferior roupaInferior) {
        this.roupaInferior = roupaInferior;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    public Chapelaria getChapeu() {
        return chapeu;
    }

    public void setChapeu(Chapelaria chapeu) {
        this.chapeu = chapeu;
    }

    public Calcado getCalcado() {
        return calcado;
    }

    public void setCalcado(Calcado calcado) {
        this.calcado = calcado;
    }

    public RoupaIntima getRoupaIntima() {
        return roupaIntima;
    }

    public void setRoupaIntima(RoupaIntima roupaIntima) {
        this.roupaIntima = roupaIntima;
    }

    //#endregion

    //#region exigencia de adicionar um item e alterar a parte correspondente no look automaticamente
    public void AdicionarItemGenéricoAoLook(Item item) {
        if (item instanceof RoupaSuperior) {
            this.roupaSuperior = (RoupaSuperior) item;
        } else if (item instanceof RoupaInferior) {
            this.roupaInferior = (RoupaInferior) item;
        } else if (item instanceof RoupaIntima) {
            this.roupaIntima = (RoupaIntima) item;
        } else if (item instanceof Calcado) {
            this.calcado = (Calcado) item;
        } else if (item instanceof Acessorio) {
            this.acessorio = (Acessorio) item;
        } else if (item instanceof Chapelaria) {
            this.chapeu = (Chapelaria) item;
        }
    }

    //#endregion
}
