package modelos.subgrupositens.tiposroupacomum;

import modelos.subgrupositens.RoupaComum;

public class RoupaSuperior extends RoupaComum {
    public enum Tipo {
    CAMISETA,
    CAMISA,
    BLUSA,
    REGATA,
    MOLETOM
    }

    private Tipo tipo;

    public RoupaSuperior(Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
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
