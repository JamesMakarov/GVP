package modelos.subgrupositens.tiposroupacomum.roupasuperior;

import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public class Blusa extends RoupaSuperior {

    public Blusa(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }

}
