package modelos.subgrupositens.tiposroupacomum;

import modelos.subgrupositens.RoupaComum;

public class RoupaInferior extends RoupaComum {
    public enum Tipo {
    CALCA,
    SHORT,
    BERMUDA,
    SAIA,
    LEGGING
    }

    private Tipo tipo;

    public RoupaInferior(Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

