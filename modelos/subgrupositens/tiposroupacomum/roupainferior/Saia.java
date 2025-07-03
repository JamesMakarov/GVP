package modelos.subgrupositens.tiposroupacomum.roupainferior;

import modelos.subgrupositens.tiposroupacomum.RoupaInferior;

public class Saia extends RoupaInferior {

    public Saia(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }
}


