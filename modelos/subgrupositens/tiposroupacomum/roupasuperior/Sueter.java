package modelos.subgrupositens.tiposroupacomum.roupasuperior;

import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public class Sueter extends RoupaSuperior {

    public Sueter(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }
}
