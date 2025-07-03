package modelos.subgrupositens.tiposroupacomum.roupainferior;

import modelos.subgrupositens.tiposroupacomum.RoupaInferior;

public class Shorts extends RoupaInferior {

    public Shorts(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }
}


