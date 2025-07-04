package modelos.subgrupositens.tiposacessorio;

import modelos.subgrupositens.Acessorio;

public class Gravata extends Acessorio {

    public Gravata(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Gravata";
    }


}
