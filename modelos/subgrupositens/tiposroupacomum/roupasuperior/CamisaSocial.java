package modelos.subgrupositens.tiposroupacomum.roupasuperior;

import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public class CamisaSocial extends RoupaSuperior {

    public CamisaSocial(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "CamisaSocial";
    }
}
