package modelos.subgrupositens.tiposroupacomum.roupasuperior;

import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public class Jaqueta extends RoupaSuperior{

    public Jaqueta(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Jaqueta";
    }
}
