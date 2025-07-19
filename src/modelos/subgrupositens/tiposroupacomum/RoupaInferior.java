package modelos.subgrupositens.tiposroupacomum;

import modelos.subgrupositens.RoupaComum;

import java.io.Serial;
import java.io.Serializable;

public class RoupaInferior extends RoupaComum implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Tipo tipo;

    public enum Tipo {
        CALCA("Calca"),
        SHORT("Short"),
        BERMUDA("Bermuda"),
        SAIA("Saia"),
        LEGGING("Legging");

        private final String nome;

        Tipo(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

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

    @Override
    public String toString() {
        return (getNome() + " : " + tipo.getNome());
    }
}

