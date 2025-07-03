package modelos.subgrupositens.tiposroupaintima;

import modelos.subgrupositens.RoupaIntima;

public class Top extends RoupaIntima {

    public Top(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }


}
