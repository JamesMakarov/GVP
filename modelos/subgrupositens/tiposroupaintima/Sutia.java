package modelos.subgrupositens.tiposroupaintima;

import modelos.subgrupositens.RoupaIntima;

public class Sutia extends RoupaIntima {

    public Sutia(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }


}
