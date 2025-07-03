package modelos.subgrupositens.tiposroupacomum.calcado;

import modelos.subgrupositens.tiposroupacomum.Calcado;

public class Bota extends Calcado {

    public Bota(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }
}


